## USING MVC-MATCHERS
- The order of the rules should be from particular to general
- that is why the **anyRequest()** method cannot be called before
- a more specific matcher method like **mvc-matchers()**

### UNAUTHENTICATED vs FAILED AUTHENTICATION
- Though an endpoint might be accessible to everyone,
- however, if you provide credentials, spring will authenticate it first before accessing the endpoint
- remember it is **Authentication Filter** before **Authorization Filter** 
- hence, its stops at Authentication Filter if credentials is invalid

### URLS USED
- curl -v -u john:12345 http://localhost:8080/hello
- curl -v -u john:12345 http://localhost:8080/ciao | json_pp
- curl -v -u jane:12345 http://localhost:8080/ciao
- curl -v -u jane:12345 http://localhost:8080/hello | json_pp
