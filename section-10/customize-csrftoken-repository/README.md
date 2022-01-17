## Custom CSRF TOKEN
- **NOTE** 
- backend and client must be on the same server
- 
- Here we attempt to customize the default csrf token generation
- so that it can suit our needs, and we have total control
- 
- Here we implement the CsrfTokenRepository 
- storing the details in JPARepository

- we use each user's unique identifier to assign a token
- we expect the client to send back his unique identifier 
- via header with key **X-IDENTIFIER**
- THE WHOLE IDEA IS EACH USER WITH ITS OWN CSRF

## CUSTOMIZING SPRING DEFAULT
- here we can change the default token **header name** and **parameter name**


## OBTAINING AND USING THE CSRF TOKEN
- assuming user's unique identifier is UNIUE-123
- we use the GET /hello
- curl -vH "X-IDENTIFIER:UNQUE-123"  http://localhost:8080/hello
- check token table

- using csrf token
- curl -XPOST -H "X-IDENTIFIER:UNQUE-123"  -H "X-CSRF-TOKEN:<TOKEN_GENERATED>"  http://localhost:8080/hello

## IMPLEMENTING CORS THAT EXPIRE
- create a csrf token that has expiration time embedded in it: say time changed to base64 + uuid
- on every request, check csrf token and evaluate time if expired refuse and throw Anuthentication exception

