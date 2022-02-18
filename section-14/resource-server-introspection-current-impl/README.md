### CURRENT WAY OF USING RESOURCE SERVER

- here instead of @EnableResourceServer which is no longer available
- we use introspection with the help of
- ```xml
       <dependency>
            <groupId>com.nimbusds</groupId>
            <artifactId>oauth2-oidc-sdk</artifactId>
            <version>9.25</version>
        </dependency>

  ```