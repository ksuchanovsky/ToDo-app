# Running localy (using localstack)

Checkout project from github.ibm.com and switch to refactor_lambda branch
--------
    git clone git@github.ibm.com:jAWS/ToDo-app.git
    cd ToDo-app
    git switch refactor_lambda
    git status

Result:

      On branch refactor_lambda
      Your branch is up to date with 'origin/refactor_lambda'.

Starting Localstack
--------
To be able to run the app locally, run localstack using docker-compose (alternatively run podman-compose cmd instead of docker-compoose) first:

    cd docker-compose
    docker-compose up


Building and deploying the backend lambda (using SAM local)
--------

1. To build run: 

        cd lambda
        sam build

2. To deply run:

        samlocal deploy --resolve-s3 --stack-name sam-app-demo --capabilities CAPABILITY_IAM --no-fail-on-empty-changeset --region eu-central-1 --parameter-overrides DynamoDBEndpointUrl=localhost.localstack.cloud:4566

3. To prove deployment suceeded, run:

        curl http://127.0.0.1:4566/restapis/<replace with random prefix from TutorialsApi output>/Prod/_user_request_/api/tutorials

Building and running the frontend app
---------

TODO