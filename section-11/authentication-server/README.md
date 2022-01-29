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

