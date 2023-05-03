package com.bezkoder.spring.jpa.postgresql.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.aws")
public class AwsConfig {

    private String profile;
    private String region;
    private SecretManager secretsManager;

    public static class SecretManager {
        private String endpoint;
        private String secretName;

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getSecretName() {
            return secretName;
        }

        public void setSecretName(String secretName) {
            this.secretName = secretName;
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public SecretManager getSecretsManager() {
        return secretsManager;
    }

    public void setSecretsManager(SecretManager secretsManager) {
        this.secretsManager = secretsManager;
    }
}
