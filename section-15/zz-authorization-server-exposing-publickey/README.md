### AUTHORIZATION SERVER

- here we manage both the private and public keys
- for easy rotation
- we expose an endpoint to allow the public key to be retrieved only to authenticated users
- ```java
  
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");//oauth/token_key   :: checking public key to be used by resourceserver
    }
  
    ```
- NOTE we can also use **permitALl()**

- we also register resource server as client inorder to to be authenticated
- ```text

           curl -v --header 'Authorization:Basic Y2xpZW50MTpzZWNyZXQx' -XPOST  \
  'http://localhost:8080/oauth/token?grant_type=password&username=john&password=12345&scope=read' | json_pp
    ```

#### ACCESSING THE PUBLIC KEY
    base64 : resource-server:resource-server-secret  ::::: registered resouce server
- ```text
    curl -H "Authorization: Basic cmVzb3VyY2Utc2VydmVyOnJlc291cmNlLXNlcnZlci1zZWNyZXQ=" http://localhost:8080/oauth/token_key 
    ```
