# Players Service
Spring-boot Microservice providing READ access to Players Database

## 1. Build
The source code is in Java 21 using Springboot platform 3.1.4 can be found here:
https://github.com/leonidsh119/players-service

Build the project using Maven. Run the following command from the project root directory: 
````
mvn clean install
````

To crete docker container with the service, run
````
mvn clean install -Pdocker
````

## 2. Deploy
The docker image with the service can be found here:
https://hub.docker.com/r/leonidsh/players-service-server

Pull the image with command:
````
docker pull leonidsh/players-service-server
````

The docker container exposes port 80 for HTTP interface.
Run the docker image mapping the container port 80 to the host port according your needs.
````
docker run -p <host-port>:80 -d leonidsh/players-service-server
````

For example, if you like to map the service API in the container to host port 80, run as following:
````
docker run -p 80:80 -d leonidsh/players-service-server
````

## 3. Test
The service provides API visibility and OpenAPI documentation via Swagger UI:
http://localhost/api/swagger-ui/index.html

## 4. What could be done more
- Alternative DB Sources (MongoDB could improve performance as long as we use only whole document reads)
- Additional API Tests
- Authorization (Springboot Security)
- AspectJ
