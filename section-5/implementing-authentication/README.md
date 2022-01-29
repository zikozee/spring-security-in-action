- Here we are using Username and password authentication
- remember that is what we told the supports' method to cater for
- 
- in this custom authentication, we check if the user exists if not, throw and AuthenticationException
- which encapsulates the UsernameNotFound Exception
- 
- if the user exist, then the password is checked by the passwordEncoder
- if it matches the authentication is returned else throw AuthenticationException
- which encapsulates the BadCredentials
- 
- we then plug it into the AuthenticationManager

## NOTE:
- The AuthenticationException thrown results in a 401
- Note instead of using userDetailsService directly in the AuthenticationManager
- we define all we need in the AuthenticationProvider and pass it to the AuthenticationManager

## NOTE NOTE
- ask yourself when using AuthenticationProvider and UserDetailsService in the AuthenticationManagerBuilder
- is this the right implementation

- curl -u john:12345 http://localhost:8080/hello   :: 200
- curl -u john:1234 http://localhost:8080/hello    :: 401
