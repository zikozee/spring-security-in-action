##RESOURCE SERVER

- we delegate all keys to authorization server
- no public key configured here

- we only specify the endpoint to access the public key
- **security.oauth2.resource.jwt.key.key-uri=http://localhost:8080/oauth/token_key**
- set clientid
- **security.ouath2.client.client-id: <resource-server-client-id>**
- set client secret
- **security.ouath2.client.client-secret: <resource-server-client-secret>**
- NOTE: the client id and client secret must be hardcoded or or fetched from the db of client details in he authorization server