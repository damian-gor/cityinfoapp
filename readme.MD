STEPS TO START:
1. Make sure that You have available local MySQL instance. 
	a) If it's port is different that 3306, or username and password are different than "root" 
	please change it in src/main/resources/bootstrap.yml file of AUTHORIZATION-SERVER application.
2. Run microservices in following order:
	1) spring-cloud-config-server
	2) discovery-server
	3) the rest (with any order).
3. Visit Swagger API at http://localhost:8081/swagger-ui.html#/ address or by Gateway: http://localhost:8080/city-info-api/swagger-ui.html)
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