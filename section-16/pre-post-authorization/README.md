## PREPOST AUTHORIZATION
- Also known as call authorization
- use for method security

- @EnableGlobalMethodSecurity(prePostEnabled = true)
- @PreAuthorize("hasAuthority('<AUTHORITY>')")
- @PreAuthorize("hasAnyAuthority('<AUTHORITY>')")
- @PreAuthorize("hasRole('<ROLE>')")

### PREAUTHORIZE TEST

#### TESTING WITH AUTHORITY
- curl -u 'natalie:12345' -XGET http://localhost:8080/hello | json_pp
- curl -u 'emma:12345' -XGET http://localhost:8080/hello 

#### TESTING WITH AUTHENTICATION
- curl -u 'natalie:12345' -XGET http://localhost:8080/secret/names/natalie | json_pp
- curl -u 'emma:12345' -XGET http://localhost:8080/secret/names/emma | json_pp

### POSTAUTHORIZE TEST

#### TESTING WITH AUTHORITY
- curl -u 'emma:12345' -XGET http://localhost:8080/book/details/emma | json_pp
- curl -u 'natalie:12345' -XGET http://localhost:8080/book/details/emma | json_pp
- curl -u 'natalie:12345' -XGET http://localhost:8080/book/details/natalie | json_pp


- NOTE: if required, you can use both preauthorize and postauthorize on a method


### COMPLEX AUTHORIZATION RULES SCENARIOS
- instead of writing long SpEl expressions, we can take out the logic to another class
- Spring Security provides a concepts of permissions which is just like **access** .anyRequest.access(SpEl)
- it uses spring expression language
- What needs be done: Create a class that implements **PermissionEvaluator** provided by org.springframework.security.access
- PermissionEvaluator has two contract
- ```java
        boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission);
        boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission)  
  ```
  
- FOR REACTIVE VERSION SEE [section-19 reactive-app-auth-access]
  
### USE CASES
- NOTE: Authentication is injected by spring so no need to provide it
- 
- for the first best suited for **PostAuthorize** which has a return Object 
- **@PostAuthorize("hasPermission(returnObject, '<ROLE OR AUTHORITY>')")**
- the second best suited for **PreAuthorize** using the uniqueId 
- **@PreAuthorize("hasPermission(#uniqueId, 'ROLE or AUTHORITY')")**
- see @DocumentPermissionEvaluator and DocumentService for details

### TESTING COMPLEX SCENARIO
#### PRE-AUTHORIZE
- curl -u natalie:12345 http://localhost:8080/documents/pre/abc123  | json_pp
- curl -u natalie:12345 http://localhost:8080/documents/pre/asd555 | json_pp
- curl -u emma:12345 http://localhost:8080/documents/pre/asd555 | json_pp
- curl -u emma:12345 http://localhost:8080/documents/pre/abc123 | json_pp

#### POST-AUTHORIZE
- curl -u natalie:12345 http://localhost:8080/documents/abc123  | json_pp
- curl -u natalie:12345 http://localhost:8080/documents/asd555 | json_pp
- curl -u emma:12345 http://localhost:8080/documents/asd555 | json_pp
- curl -u emma:12345 http://localhost:8080/documents/abc123 | json_pp