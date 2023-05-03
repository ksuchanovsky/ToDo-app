AWS profiles setup
---------

2 AWS profiles are about to be created locally:

* localstack one - for the local development and
* AWS cloud one - to be used for the AWS cloud deployment

Profile creation
---------

1. Create localstack profile:

        aws configure --profile localstack
        AWS Access Key ID [None]: dummy
        AWS Secret Access Key [None]: dummy
        Default region name [None]: eu-central-1
        Default output format [None]: json

1. Create jaws profile:

        aws configure --profile localstack
        AWS Access Key ID [None]: <actual Access Key ID of the AWS Cloud user>
        AWS Secret Access Key [None]: <actual Secret Access Key of the AWS Cloud user>
        Default region name [None]: eu-central-1
        Default output format [None]: json
