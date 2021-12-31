### MULTIPLE PATHS CONFIG
- /a/b/** is authenticated, meaning /a/b and /a/b/... will be authenticated
- but /a will be unauthenticated
- curl http://localhost:8080/a  :::::: 200
- curl -v http://localhost:8080/a/b ::: 401
- curl -u john:12345 http://localhost:8080/a/b ::: 200
- curl -v http://localhost:8080/a/b/c ::: 401
- curl -u john:12345 http://localhost:8080/a/b/c ::: 200

### Matching Single paths
- /a/*/b will match /a/c/b, /a/d/b BUT NOT /a/e/d/b (only /a/**/b will match)
- /a Only path /a.
- /a/*   The * operator replaces one pathname. In this case, it matches /a/b or
- /a/c,  but not /a/b/c.
- /a/**   The ** operator replaces multiple pathnames. In this case, /a as well as
- /a/b and /a/b/c are a match for this expression.
- /a/{param}  This expression applies to the path /a with a given path parameter.
- /a/{param:regex}  This expression applies to the path /a with a given path parameter only
- when the value of the parameter matches the given regular expression.

### FOR PRODUCTS CONTROLLER
- The config only allows numbers as the path variable ay other thing is denied
- curl  http://localhost:8080/product/1234 ::::::::::::: 200
- curl  http://localhost:8080/product/1234a ::::::::::::: 401