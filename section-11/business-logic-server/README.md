
# BUSINESS LOGIC SERVER

###
- AuthenticationServerProxy.sendAuth : authenticates and generates OTP and sends to customer
- AuthenticationServerProxy.sendOtp: verifies if OTP is correct

### Filter
- we use the OncePerRequestFilter in InitialAuthenticationFilter
- so that we can leverage : **shouldNotFilter**
- to ensure our custom filter applies only to  **/login** path
- d
- we use the OncePerRequestFilter in JwtAuthenticationFilter
- to ensure it does not apply to  **/login** path using **shouldNotFilter**

### FETCHING USER KEY:
- ->>> This is just for demo purpose to ensure each user has a unique signing key
- upon compromise, we only need change user's signing key and all tokens are invalidated
```
    This is a security flaw
    as it means exposing the userkey via network
    
    Solution: move all the authetication to the authenticationserver(authProviders, authObjects, Authentication Mnanger)
    this way no detail is exposed
    
    Secondly: talk to the db directly from the business logic server

```

### TESTING
- curl -H "username:danielle" -H "password:12345" http://localhost:9090/login
- curl -v -H "username:danielle" -H "code:<GENERATED_CODE>" http://localhost:9090/login
- curl -v -H "Authorization:eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImRhbmllbGxlIn0.ioOpk2CqlcE0DFKSSQMeBu6trlP-7x_rjTaaGA7O5_7jCBscu3qhU9UndoB-7y8GYj1SYmMKoSA4cB3m7gO7Rg" http://localhost:9090/test
