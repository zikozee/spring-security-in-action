## RESOURCE SERVER BLACKBOARDING
- This only makes sense to be used: if we know there won't be many calls else a bottleneck

- The resource server uses the token store to validate the token and retrieve details needed for authorization.
- These details are stored in the security context
- Here we avoid direct calls between the resource server and the authorization server for validating tokens
- Here we don't need the **oauth/check_token**