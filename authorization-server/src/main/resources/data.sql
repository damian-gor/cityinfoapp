-- client: client; password: pass
 INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('client', '{bcrypt}$2y$12$JEfKA1acGzndWC26SNq3/Ov7zWPYW6d6djTydsjxBpeTm.uyUAodS', 'http://localhost:8081/login', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (NAME) VALUES
 ('get_data'),
 ('get_secretData');

 INSERT INTO role (NAME) VALUES
		('ROLE_admin'),('ROLE_user');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*get_data -> admin */
     (2,1), /* get_secretData -> admin */
     (1,2); /* get_data -> user */

insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'admin','{bcrypt}$2y$12$cG5Rq9HIIAaRIcJr2jGBUuJjG39Wnx41O.8qQCZq2jHKL2A420E46', 'admin@mail.com', '1', '1', '1', '1');
 insert into  user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'user1', '{bcrypt}$2y$12$Adf7ef5PxmlRMnNnJdxevOgsxHYYCCO4HJZh0ZQWo769yNooTF4Ya','user1@mail.com', '1', '1', '1', '1');
 insert into  user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('3', 'user2', '{bcrypt}$2y$12$on39i3q9BYPgkaAp5/4e1eYPGWIBc70rk9ZvYiP/v0ughirAGxGQW','user2@mail.com', '1', '1', '1', '1');
 /*
 passowrds:
 admin - apass
 user1 - u1pass
 user2 - u2pass
 */

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1), /* admin -> admin */
    (2, 2), /* user -> user1 */
    (2, 3); /* user -> user2 */