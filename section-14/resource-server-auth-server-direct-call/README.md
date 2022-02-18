## RESOURCE SERVER


### CONFIGURE RESOURCE SERVER IN AUTHORIZATION SERVER
- note to an authorization server, a  **resource server** is also a client and also need be configured ...
- in the database but in our case HARDCODE
- we have configured resource server in the authorization server in **section-13** 

### TESTING
#### GET TOKEN USING PASSWORD GRANT (WE CAN USE OTHER GRANTS DEPENDING ON OUR FLOW)
- let's test with password grant (because it easy lolz) to get our token when a user logs in
- ```text
    curl --location --request POST 'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' \
    --header 'Authorization: Basic Y2xpZW50MTpzZWNyZXQx' | json_pp     
  ```

#### VALIDATING TOKEN
- now letz **access oauth/check_token** (remember it is disabled by default) enabled by the below
- ```java
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }
  ```
- validating token directly from auth server
- ```text
  curl --location --request POST 'http://localhost:8080/oauth/check_token?token=<TOKEN_GENERATED>' \
   --header 'Authorization: Basic cmVzb3VyY2Utc2VydmVyOnJlc291cmNlLXNlcnZlci1zZWNyZXQ=' | json_pp
  ```

####  RESOURCE SERVER CONNECTING VIA APPLICATION PPTIES to AUTH SERVER
- ```text
  curl -H "Authorization: bearer <GENERATED_TOKEN>" "http://localhost:9090/hello"

```