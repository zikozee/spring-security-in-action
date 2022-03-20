### to avoid using postFilter for performance
- bring dependency **spring-security-data**
- which in turn brings in **SecurityEvaluationContextExtension**
- we create a bean of this
- which allows us do this: (injection authentication into query)
- ```sql
    @Query("SELECT p from Product  p WHERE p.name LIKE %:text% AND " +
            "p.owner=?#{authentication.name}")
  ```

### choosing the right way to validate token
- With a direct call to the authorization server
- Using a blackboarding approach
- With cryptographic signatures
-
- we use cryptographic signatures
- as keycloak provides a way to validate JWT token by exposing public keys
- **http://localhost:8180/auth/realms/SpringSecurityInAction/protocol/openid-connect/certs**

### validating a token
- JwKTokenStore looks for a specific key wjose ID needs to exist in the header of the 
- provided JWT token

## UNABLE TO START UP. use  SPRING-BOOT 2.3.1.RELEASE


### TESTING
- A client can add a workout only for the authenticated user 
- ```text
    save-workout 
    save-workout-wrong-user (view postman documentation)
    fetch-workout-specific-user (view postman documentation)
  ```

- A client can only retrieve their own workout records
- Only admin users can delete a workout