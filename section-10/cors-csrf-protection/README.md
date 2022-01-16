
## GENERATION OF THE CSRF 
- any get request, generates the csrf
- curl -v  http://localhost:8080/hello

## POST WITH CSRF GENERATED
- copy JESSIONID and  id from verbose above
- Also check the log for the csrf we have generated
- curl  -X POST http://localhost:8080/hello -H 'Cookie: JSESSIONID=<SESSION_ID>' -H 'X-CSRF-TOKEN: <TOKEN_GENERATED>'
