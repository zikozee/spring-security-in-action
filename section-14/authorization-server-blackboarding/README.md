### AUTHORIZATION SERVER BLACKBOARDING

- The contract representing the object that manages tokens in Spring Security...
- both on the authorization server as well as for the resource server : TOKENSTORE

### PROCESS
- The authorization server uses a **token store** to generate tokens at the end of the authentication process
- The client uses these tokens to access resources managed by the resource server
- Two tables required: (**WE CAN OVERRIDE THE NAMES**)
- **oauth_access_token**: used to store access tokens and 
- **oauth_refresh_token**: used to store refresh tokens

- create a bean of type TokenStore and link it to the AuthorizationServerEndpointsConfigurer