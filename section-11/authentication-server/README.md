# AUTHENTICATION SERVER
### ADD USER
```
 - curl -XPOST \
  -H "content-type: application/json" \
  -d "{\"username\":\"danielle\",\"password\":\"12345\"}" \
  http://localhost:65530/user/add
```

### GENERATE OTP
```
 curl -XPOST \
-H "content-type: application/json" \
-d "{\"username\":\"danielle\",\"password\":\"12345\"}" \
http://localhost:65530/user/auth
```
### OTP CHECK
```
curl -v -XPOST -H "content-type: application/json" -d \
"{\"username\":\"danielle\",\"code\":\"243728\"}" \
http://localhost:65530/otp/check
```

### FETCH USER KEY: 
- ->>> This is just for demo purpose to ensure each user has a unique signing key 
- upon compromise, we only need change user's signing key and all tokens are invalidated
```
    This is a security flaw
    as it means exposing the userkey via network
    
    Solution: move all the authetication to the authenticationserver(authProviders, authObjects, Authentication Mnanger)
    this way no detail is exposed
    
    Secondly: talk to the db directly from the business logic server

```

