Oauth2.0 Server and API
=================

The package of the project referees to: com.project : 'com.oauth.server'.

## About
This project is developed with the finality of gives a Authorization Server, using the Password OAuth2.0 Flow´s.

## Architecture:

Open the file located in the folder Doc/Diagrams "Auth_Server-Architecture"  in this [URI](https://sequencediagram.org/) to see the Sequence Diagram.

## Reference Documentation
The following links have the official Documentation implemented in this code.

* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)
* [Spring Secuirity](https://docs.spring.io/spring-security/reference/servlet/oauth2/login/core.html)


## End-Points

### Original OAuth2 Server Endpoints 
* For request new  [Token](http://127.0.0.1:9000/oauth2/token)

  HTTP POST: 
  Example: http://127.0.0.1:9000/oauth2/token?grant_type={grantType}&username={user}&password={pass}&scope={scope}

- grant_type: the grantType configured on server, default value: custom_password
- username: from a DB User. (for this project send the email of the user in this field)
- password: the password for the DB User.
- scope: the grant authorities for this project are openid, profile,  write and read.

* For [Refresh_Token](http://127.0.0.1:8081/oauth2/token)
  
  - HTTP POST:
  - Example: http://127.0.0.1:9000/oauth2/token?grant_type={grantType}&username={user}&password={pass}&scope={scope}
  - grant_type: the grantType configured on server, default value: refresh_token
  - client_id: Client-App Identification value for request the server
  - client_secret: Client-secret Identification value for request the server
  - refresh_token: value of the refresh token requested in a new token.

## Custom Oauth2 server Endpoints

* For [New Token](http://127.0.0.1:9000/login/token)

  - HTTP: POST
  - request : see Open API documentation for more info.
  - response: see Open API documentation for more info.

* For [Refresh_Token](http://127.0.0.1:8081/login/refresh)

 - HTTP: POST
 - request : see Open API documentation for more info.
 - response: see Open API documentation for more info.


## API endpoints

* List all users (paginables) [getUsersList](http://localhost:8081/api/user/all/pageables)

- HTTP: GET
- request : see Open API documentation for more info.
- response: see Open API documentation for more info.


## Database Objects

*  *DB name*: authentication.
*  *url*: jdbc:postgresql://localhost:5432/authentication
*  *username*: postgres
*  *password*: root

* *Tables*:
  * users
  * role
  * users_role
  * function
  * role_function

The full description of the Database is in the SQL Backup located in the folder doc/db_backup

The example user: admin@correo.com, password:123456 (hash: $2a$11$rWuZQcv4n3.KrtjLUrinh.wRxXLSEuPMR/vYeW2mdsvptdzhJUvYW )

## OpenAPI Documentation 
* [AuthServer](http://localhost:9000/swagger-ui/index.html)
* [API](http://localhost:8081/swagger-ui/index.html)


## Execution

For the execution of the complete application, you have to follow this steps:

* Database:
1. Install PostgresSQL App (remember to use User and Password from the Database Object)
2. You must create a database with the DB name authentication
3. Restore the authentication.sql

* Java Environment 
1. Install the JDK 17.
2. Follow the installation daemon. 

* Deploy the AuthServer for test the request & refresh token endpoints. 
* Deploy the resourceServer for get information using the JWT token. 

