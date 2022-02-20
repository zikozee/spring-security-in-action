## ASYMMETRIC KEY AUTHORIZATION SERVER

- we generate the key pair using the below command
- ```text
   filename: asym.jks
   alias: asym
   password: asym123  
   
  keytool -genkeypair -alias asym -keyalg RSA -keypass asym123 -keystore asym.jks -storepass asym123
  
  ```
  
- configuration with symmetric is how we configure **jwtAccessConverter**
- where we pass in all the details


- to avoid configuring public key in resource server, we can expose it with 
- ```java
  
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");// oauth/check_token
        security.tokenKeyAccess("isAuthenticated()");//oauth/token_key   :: checking public key to be used by resourceserver
    }
    ```
- then we can access with
- ```text
    curl XGET 'http://localhost:8080/oauth/token_key?token=<ACCESS_TOKEN>  -H 'Authorization: Basic Y2xpZW50MTpzZWNyZXQx' \
    ```