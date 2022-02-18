##CLIENT APP SUING GITHUB AS AUTHORIZATION AND RESOURCE

- create new application on GitHub: **https://github.com/settings/applications/new**
- instead of form or basic login, we use **oauth2Login()**
- in case of basic/form login that adds BasicAuthenticationFilter,
- oauth2Login adds **OAuth2LoginAuthenticationFilter** to the filter chain


### CLIENT REGISTRATION

- All Oauth 2 follow the same standard. so you must provide the following details for **client registration**
- below is GitHub's details found in : **https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/**
- ```java
    ClientRegistration cr = ClientRegistration
    .withRegistrationId("github")  :: USER DEFINED
    .clientId("CLIENT_ID_VALUE")   :: FROM PROVIDER
    .clientSecret("CLIENT_SECRET_VALUE") :: FROM PROVIDER
    .scope(new String[]{"read:user"})    :: WHAT TO ACCESS
    .authorizationUri("https://github.com/login/oauth/authorize") :: FROM PROVIDER -> where client is redirected for authentication
    .tokenUri("https://github.com/login/oauth/access_token") :: FROM PROVIDER -> where client obtains access and refresh token
    .userInfoUri("https://api.github.com/user") :: FROM PROVIDER -> where token is used to access user details
    .userNameAttributeName("id")
    .clientName("GitHub") :: USER DEFINED
    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
    .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
    .build();
  ```

- Spring provides a simpler impl for common oauth providers: **Google, github, facebook, Okta**
- namely: **CommonOAuth2Provider**  which defaults the above implementation to last known provider value


### CLIENT REPOSITORY
- The oauth authentication filter obtains details about the authorization server client registrations from
- a **ClientRegistrationRepository**

- ClientRegistrationRepository has one or more ClientRegistration Objects (e.g GITHUB, FACEBOOK, LINKEDIN etc)

- This can be configured via code (inline or declarative) or via application ppties

### USING PROVIDERS NOT KNOWN AS COMMON TO SPRINGBOOT
- we need to define alongside clientId and clientSecret the below: 
- **spring.security.oauth2.client.provider .myprovider.authorization-uri=<some uri>**
- and
- **spring.security.oauth2.client.provider .myprovider.token-uri=<some uri>**
- where **myprovider** is the name of the provider


##### TEST
- http://localhost:8080
- http://localhost:8080/context