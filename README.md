# myretail-api
Restful Api services for myretail service to retrive information from redsky target service and nosql redis database

Setup Workspace

Required Softwares:
1. Install git in desktop (https://git-scm.com/downloads) or plugin to your IDE
2. Install rest client (eg: Postman (https://www.getpostman.com/apps)/ advanced rest client etc..)
3. Add Gradle, Maven, Sonarlint plugins in IDE
4. Java Version 1.8 (configured in IDE/ system environment variables)
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

2. Clone this git project into your working IDE/local desktop
3. Install rest client (eg: Postman/ advanced rest client etc..) to test the service with below url and required headers
	a. Get Product information
	b. Put the product pricing information

Supporting Features:
1) Spring Boot Rest Service 
	a. Spring Security for Authentication and Authorization
	b. JSR 303 Bean validation framework integrated with Rest Service to get the required product data
	c. integrated with Redis NoSQL database to fetch the product balances when exists
	d. Async logging
	e. Metrics with Spring Actuator
	f. Unit Test Coverage
	g. Static Code Analysis
	
