## Restricting Access

- curl -v -u jane:12345 http://localhost:8080/hello    **200**
- curl -v -u john:12345 http://localhost:8080/hello    **200**

## using .access() 
- this uses SpEl
- this can be used for complex permissions
- e.g use that has **read** but not delete **permission**
- i.e user must have the authority **read** but not the authority **delete**
- **.access(hasAuthority('read') and !hasAuthority('delete'))**
- curl -v -u jim:12345 http://localhost:8080/hello    **403**


## complex expression using SpEL
- access endpoint only before 9:17pm
- **.access("T(java.time.LocalTime).isBefore(T(java.time.LocalTime).of(21, 17, 0))")**