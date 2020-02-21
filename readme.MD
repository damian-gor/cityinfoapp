STEPS TO START:
1. Create in MySQL new database, named "oauthdb"
	a) -In src/main/resources/application.yml file of AUTHORIZATION-SERVERit was necessary for me to add 
	additional parameters to spring.datasource.url property. In mostly cases value 
	"jdbc:mysql://localhost:3306/oauthdb?createDatabaseIfNotExist=true" will be adequate.
	Please update also your username and password to data source, if they're different than "root".
	b) if You want to restart the authorization-server: change file src/main/resources/data.sql to data.txt
2. Run microservices in following order:
	1) spring-cloud-config-server,
	2) the rest (with any order).
3. Visit Swagger API at http://localhost:8081/swagger-ui.html#/ address.
4. Log in with one of three users:
	1) user: admin password: apass (complete access to data)
	2) user: user1 password: u1pass (limited access to data)
	3) user: user2 password: u2pass (limited access to data)
5. Try out CityInfoApp!

	
Additional information:

1. Application structure:
-Service responsible for communication with application clients is city-info-service, which is fetching data from 
weather-info-service and country-info-service. That services are getting data from other, open-access online APIs.
-The communication between microservices is supported by authorization / discovery / spring-cloud-configuration / 
gateway servers. Configurations are fetched from the remote GitHub repository.


2. Access data
client_id: client
client_secret: pass

3. CityInfoServiceApplication's endpoints:
1) http://localhost:8081/ -> open-access
2) http://localhost:8081/city/{city-name} -> main feature of the application, available after positive authorization
3) http://localhost:8081/admin -> confidential information, available only for admin.