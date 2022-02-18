## Authorization Server
- Authorization server is the component that deals with authenticating a user in th OAuth2 Framework
- Result of **authentication** no longer stored in SecurityContext but in **TokenStore**

### Linking AuthenticationManager to AuthorizationServer
- we expose the AuthenticationManager in the Spring context to register the Authentication manager
- with the AuthorizationServer

### Registering clients with the authorization server
- for managing **users** we use UserDetails and UserDetailsService
- for managing **    clients** we use: **ClientDetails** and **ClientDetails** Service
- like for clients we have an **InMemoryClientDetailsService** just like InMemoryUserDetailsService for managing clients in memory
- Also we have **JdbcClientDetailsService** for clients as JdbcUserDetailsService fo users for connecting to the database


### VALIDATING TOKEN FROM RESOURCE SERVER
- we override **configure(AuthorizationServerSecurityConfigurer security)** in the AuthServerConfig class
- we then specify **security.checkTokenAccess("isAuthenticated()")** or **security.checkTokenAccess("permitAll()");**
- but it is recommended to use the first


### TESTING PASSWORD GRANT
- ```
  curl --location --request POST 'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' \
   --header 'Authorization: Basic Y2xpZW50MTpzZWNyZXQx' | json_pp
  
  OR
  
   curl -v --header 'Authorization:Basic Y2xpZW50MTpzZWNyZXQx' -XPOST  \
  'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' | json_pp

  ```
  
### BEST PRACTICE
- Each client should have its own clientId and ClientSecret:: **DO NOT SHARE**
- each client should have its grant saved alongside its credentials e.g a column for grant_type



### AUTHORIZATION GRANT TYPE
- we provide the redirected URI : where the user will be redirected to after successful login with the authorization code appended
- Also, we **Override HttpSecurity to provide form login** where user will be redirected to in order to provide credentials

### TESTING AUTHORIZATION CODE
- http://localhost:8080/oauth/authorize?response_type=code&client_id=client2&scope=read
- input user details configured :: john:12345
- Authorization ask you to confirm the **scopes** you want to authorize
- the Authorization Server redirects you to the provided RedirectedURI for the client with the code appended
#### Obtaining token after the above steps
- ```java
  curl -v --header 'Authorization:Basic Y2xpZW50MjpzZWNyZXQy' \
   -XPOST  http://localhost:8080/oauth/token?grant_type=authorization_code&scope=read&code=<CODE_GENERATED>
  ```
- NOTE CODE CAN ONLY BE USED ONCE else we get
```json
    {
        "error": "invalid_grant",
        "error_description": "Invalid authorization code: 3uRFne"
        }
```

### CLIENT CREDENTIALS GRANT TYPE
- curl -v --header 'Authorization: Basic Y2xpZW50MzpzZWNyZXQz' -XPOST 'http://localhost:8080/oauth/token?grant_type=client_credentials&scope=info'


### REFRESH TOKEN GRANT TYPE
- to support refresh token you must add it to the list of grant provided, else it will not be included
- i.e List.of("authorization_code", "refresh_token)
- i.e List.of("password", "refresh_token)
- Best Used to reduce signing in with **username and password for authorization_code and password grant**   