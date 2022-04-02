## PRE-POST AUTHORIZE

- we no longer use @EnableGlobalMethodSecurity we use **@EnableReactiveMethodSecurity**

### TEST
- curl -u 'john:12345' 'http://localhost:8080/hello'
- curl -u 'bill:12345' 'http://localhost:8080/hello'    ::::: ERROR