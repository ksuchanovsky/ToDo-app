#!/usr/bin/env bash

set -euo pipefail

# enable debug
# set -x

echo "configuring secret manager"
echo "==================="
LOCALSTACK_HOST=localhost


create_secret() {
    local SECRET_NAME=$1
    local SECRET_VALUE=$2
    awslocal secretsmanager create-secret --name "${SECRET_NAME}" --endpoint-url=http://${LOCALSTACK_HOST}:4566 --secret-string ${SECRET_VALUE}
}

create_secret "rds-db-credentials/postgres-jaws-tutorial" '{"username":"postgres","password":"123","engine":"postgres","host":"localhost","port":5432,"dbInstanceIdentifier":"jaws"}'