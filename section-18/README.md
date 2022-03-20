# KEYCLOAK - SPRING SECURITY

### Create Realm and See endpoints
- where all app is details is defined more like a namespace
- to see endpoints provided
- Choose Realm > Realm Settings > General  > Endpoints > click on OpenId Endpoint Configuration

### Token Duration
- Choose Realm > Realm Settings > Tokens > Access Token LifeSpan 
- Remember to reduce for production

### KeyCloak Authorization Server Configuration Steps
- Register Client :: one who makes request for users
- Define client scope :: what client can access
- Add users for our application :: who the client is accessing resource on behalf of
- Define user roles and custom access tokens :: what user can access on resource server


### Register client
- Choose Realm > Clients > Create Button on the top right hand

### Define client scope
- client scope is the role the client can access in the authorization system just like user roles
- Choose Realm > Client Scopes > Click Create Button on the top right hand
- give a unique name
- ensure **Protocol** is openid-connect
- **SAML 2.0** is no longer actively developed in spring

#### Assign client scope to **client**
- Choose Realm > Clients> Client Scopes tab
- map created client scope to client

### Adding Users and Obtaining access tokens
- Choose Realm > Users > Click Add user tab (Top Right Hand)
- unique username
- click email verified
- ensure **Require User Action** is left empty else user will not be able to authenticate

- click user UUID > credentials > Turn off **Temporary** password
- else you will be required to change password at first login :: which leads to not being able to 
- authenticate user

### Define user roles
- Choose Realm > Roles > Click Add Roles tab (Top Right Hand)

### Mapping User to Roles
- Choose Realm > Users > Role Mapping Tab
- map user to specific role(s)

### New details will not appear in the token by default, 
- we add three more details to our token
- Roles - Used to apply a part of the authorization rules at the endpoint layer
- Username - Filters the data when we apply the authorization rule
- Audience Claim (aud) - used by resource server to acknowledge the requests
- 
- to achieve this, we create mappers for a specific client scope to customize the access token
- 
- Choose Realm > Client Scope > choose app scope > Mappers Tab > Click Create Button at the right hand
- 1. authorities :::
- ```text
   name > authorities
   Mapper Type > User Realm Role    ::: i.e the role(s) of the user hence a list
   Token Claim Name > authorities
  ```
- 2. username :::
- ```text
   name > username
   Mapper Type > User Property    ::: maps username property to this JSON property
   Token Claim Name > user_name
   Claim JSON Type > String
  ```
3. Audience Claim :::
- ```text
   name > aud
   Mapper Type > Audience    :: defines the recipient(targeted audience) of the access token (i.e our resource server)
                                we configure the same value on the resource server 
  Included Client Audience > fitnessapp
  ```


