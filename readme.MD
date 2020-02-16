Swagger API available: http://localhost:8081/swagger-ui.html#/

APPLICATION'S STRUCTURE:

-Service responsible for communication with application clients is city-info-service, which is fetching data from 
weather-info-service and country-info-service. That services are getting data from other, open-access online APIs.

-The communication between microservices is supported by authorization / discovery and spring-cloud-configuration 
servers. Configurations are fetched from remote GitHub repository.

AUTHORIZATION-SERVER:

-Please, create in MySQL new database, named "oauthdb".

-After initializing data by running AuthorizationServerApplication, please change file src/main/resources/data.sql
to data.txt (only if You are planning to restart the authorization-server).

-In src/main/resources/application.yml file it was necessary for me to add additional parameters to spring.datasource.url
property. In mostly cases value "jdbc:mysql://localhost:3306/oauthdb?createDatabaseIfNotExist=true" will be adequate.
Please update also your username and password to data source, if they're different than "root".

ACCESS DATA:

client_id: client client_secret: pass

There are also three users:
1) user: admin password: apass
2) user: user1 password: u1pass
3) user: user2 password: u2pass


CityInfoServiceApplication's endpoints:
1) http://localhost:8081/api/ -> open-access
2) http://localhost:8081/api/city/{city-name} -> main feature of the application, available after positive authorization
3) http://localhost:8081/api/admin -> confidential information, available only for admin.