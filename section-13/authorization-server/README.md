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


### TESTING PASSWORD GRANT
- ```
  curl --location --request POST 'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' \
   --header 'Authorization: Basic Y2xpZW50OnNlY3JldA==' | json_pp
  
  OR
  
   curl -v --header 'Authorization:Basic Y2xpZW50OnNlY3JldA==' -XPOST  \
  'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' | json_pp

  ```