# Running localy

Getting project from github.ibm.com
--------
    git clone git@github.ibm.com:jAWS/ToDo-app.git
    cd ToDo-app
    git status

Result:
    
      On branch vanilla
      Your branch is up to date with 'origin/vanilla'.

Starting PostgreSQL
--------
To be able to run the app locally, run PostgreSQL using docker-compose (alternatively run podman-compose cmd instead of docker-compose) first:

    cd docker-compose
    docker-compose up


Building and deploying the backend app
--------

1. To build run: 

        cd spring-boot-server
        mvn spring-boot:run

2. To prove deployment suceeded, run:

        curl http://localhost:8080/api/tutorials

Building and running the frontend app
---------

1. Have NodeJS installed (LTS version is preffered, 18.12.1 is latest LTS). I have 16.15.0, this is version about 6 months old, should work just fine.

2. Install angular CLI globaly with npm (node package manager) -> if you have yarn, you can use that.

        npm install -g @angular/cli

3. Clone GitHub repository and navigate to angular app
application is located in angular-11-client/ folder.

4. Install application’s dependencies
    
        npm install

5. If you want to run app locally, you can start application by running:
    
        npm run start

    (which runs ng serve internally)
    
    OR 
        
        ng serve

    Application is then started on port defined in angular.json (by default 4200).

6. To build application, simply run:

        ng build

    You can also run ng build --prod, which will produce optimized production bundle.
    
    Difference between them is first one also has map files to allow tracing errors and issues to specific code.

    Production bundle will just produce mostly useless stacktrace, as compiled JS code is optimized for performance.


Produced bundle can be found in dist/Angular11Crud/ folder, you can just copy-paste this bundle into AWS S3 bucket
more info can be found here
https://levelup.gitconnected.com/learn-how-to-create-and-deploy-the-angular-application-to-aws-serverless-s3-81f8a838b563