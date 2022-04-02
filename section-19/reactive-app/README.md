## REACTIVE APPS

### FLOW

- AuthenticationWebFilter intercepts the Http Request
- The filter delegates the responsibility to the authentication Manager (ReactiveAuthenticationManager)
- The AuthenticationManager implements the logic directly
- As Reactive apps don't have authentication Providers as non-reactive apps

### TEST
- curl -u 'john:12345' 'http://localhost:8080/hello'
- curl -u 'john:12345' 'http://localhost:8080/hello-auth'
- curl -u 'john:12345' 'http://localhost:8080/hello-auth-context'