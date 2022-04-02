### Configuration

- we use resource-server-asymmetric introspection like **section 15 z-resource-server-asymmetric-introspection**
- we use either **authorization server signature endpoint**
- or we configure **public directly** commented out part see ProjectConfig
- we use Keycloak as **authorization server**

### TEST
- KEY-CLOAK
- start up keycloak and use 
- ```text
   curl --location --request POST 'http://localhost:8180/auth/realms/SpringSecurityInAction/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=bill' \
--data-urlencode 'password=12345' \
--data-urlencode 'scope=fitnessapp' \
--data-urlencode 'client_id=fitnessapp'
  
    ```


- RESOURCE SERVER
- ```text
curl --location --request GET 'http://localhost:9090/hello' \
--header 'Authorization: Bearer <TOKEN>'
```