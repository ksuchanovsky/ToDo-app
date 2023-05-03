package com.bezkoder.spring.jpa.postgresql.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DataSourceConfiguration {

    @Autowired
    private AwsConfig awsConfig;

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource appDataSource() {

        String secretName = awsConfig.getSecretsManager().getSecretName();
        String endpoint = awsConfig.getSecretsManager().getEndpoint();
        String region = awsConfig.getRegion();
        String profile = awsConfig.getProfile();
        if (profile != null) {
            System.setProperty("aws.profile", profile);
        }

        AwsClientBuilder.EndpointConfiguration config = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
        clientBuilder.setEndpointConfiguration(config);
        AWSSecretsManager client = clientBuilder.build();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode secretsJson = null;

        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResponse = null;
        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);

        } catch(ResourceNotFoundException e) {
            log.error("The requested secret " + secretName + " was not found");
        } catch (InvalidRequestException e) {
            log.error("The request was invalid due to: " + e.getMessage());
        } catch (InvalidParameterException e) {
            log.error("The request had invalid params: " + e.getMessage());
        }

        if(getSecretValueResponse == null) {
            return null;
        }

        // Decrypted secret using the associated KMS CMK
        // Depending on whether the secret was a string or binary, one of these fields will be populated
        String secret = getSecretValueResponse.getSecretString();
        if(secret == null) {
            log.error("The Secret String returned is null");
            return null;
        }
        try {
            secretsJson = objectMapper.readTree(secret);
        } catch (IOException e) {
            log.error("Exception while retreiving secret values: " + e.getMessage());
        }

        String host = secretsJson.get("host").textValue();
        int port = secretsJson.get("port").intValue();
        String username = secretsJson.get("username").textValue();
        String password = secretsJson.get("password").textValue();
        appDataSourceProperties().setUrl("jdbc:postgresql://" + host + ":" + port + "/");
        appDataSourceProperties().setUsername(username);
        appDataSourceProperties().setPassword(password);

        return appDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
