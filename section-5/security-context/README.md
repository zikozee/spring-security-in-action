
    TESTING SECURITY CONTEXT
### MODE_THREADLOCAL
- curl -u user:<generated-password>  http://localhost:8080/hello
- curl -u user:<generated-password>  http://localhost:8080/hello2

### MODE_INHERITABLETHREADLOCAL
#### SPRING CREATED THREAD e.g @Async
- curl -u user:<generated-password>  http://localhost:8080/hello3
- The config where we set the strategy name enables this. see ProjectConfig
- where the security context details is copies over to the newly created thread

####  NON-SPRING CREATED THREAD
- Here we use 
- DelegatingSecurityContextRunnable for "void" tasks
- DelegatingSecurityContextCallable<T> for tasks that return a value. see @GetMapping(path="ciao")
- DelegatingSecurityContextExecutorService for tasks that return a value. see @GetMapping(path="ciaoExec")
- FOR A MORE ABSTRACT METHOD THAT TAKES YOUR EXECUTOR, see https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/concurrency.html#DelegatingSecurityContextExecutor

### MODE_GLOBAL
- only advisable for standalone applications
- more so, it is not threadsafe synchronization needs be handled

## UNIT TEST
- @WithMockUser(username = "mary")  : skips authentication and configures user as mary
- RequestProcessor:   with(requestProcessor)  e.g with(user(...)) :: ctrl user to see
###DIFF  BTW ANNOTATION AND REQUEST_PROCESSOR
- annotation: test security environment is setup first
- requestprocessor: test request is created and then altered to define other constraints like test security environment