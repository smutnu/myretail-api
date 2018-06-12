# myretail-api
Restful Api services for myretail service to retrive information from redsky target service and nosql redis database

## Index

* [Getting Started](#getting-started)
* [Build and Run](#build-and-run)
* Plugins
  * Sonar
* [Features](#features)
* [Upcoming Features](#upcoming-features)

## Getting Started

Required Softwares:
1. Install git in desktop (https://git-scm.com/downloads) or plugin to your IDE
2. Install rest client (eg: Postman (https://www.getpostman.com/apps)/ advanced rest client etc..)
3. Add Gradle, Maven, Sonarlint plugins in IDE
4. Download Java (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and set configurations to Java Version 1.8 (configured in IDE/ system environment variables)
5. Install redis https://redis.io/download
	+ Option 1: Download and extract Redis
	$ wget http://download.redis.io/releases/redis-4.0.9.tar.gz
	$ tar xzf redis-4.0.9.tar.gz
	$ cd redis-4.0.9
	$ make
	+ Option 2:https://docs.microsoft.com/en-us/windows/wsl/install-win10?f=255&MSPPError=-2147217396
	+ Option 3: 
		 + Install docker cli
		 + docker run --name myretail-redis -d redis
		 + docker run -p 6379:6379 -d redis
     + docker-machine ip default >> to get hostname/ip address
		
6. Run redis client cli
	    + docker run -it --link myretail-redis:redis --rm redis redis-cli -h redis -p 6379
      + Redis commands to verify in cli https://redis.io/commands

## Build and Run
1. Clone this git project into your working IDE/local desktop
2. Use Gradle:
    + ./gradlew clean build bootRun
3. Or Maven:
`   + mvn clean package spring-boot:run
4. To run static code analysis
    + mvn clean verify sonar:sonar
5. Open Restclient (eg: Postman/ advanced rest client etc..) to test the service with below url and required headers
	  + Get Product information (http://localhost:8080/my-retail/products/13860428)
	  + Put the product price information (http://localhost:8080/my-retail/products/13860428/price)
    + Health check (http://localhost:8085/actuator/health)

## Features
1. Spring Boot Rest Service 
2. JSR 303 Bean validation framework 
3. Integrated with Rest Service to get the required product data
4. Integrated with Redis NoSQL database
5. Static Code Analysis

## Upcoming Features
1. Spring Basic/OAuth Security/XACML specification for Authentication and Authorization
2. Micro Services Architecture - Create utility services
3. Metrics with Spring Actuator integrated to AWS
4. Reactive/Async programming
5. Odata implementation
6. Add build and code coverage status in Read me.
7. Add Redis cluster and persistence storage