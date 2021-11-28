# run without adding Request-Id or making Request-Id blank in the header
curl -v http://localhost:8080/hello
# and run with Request-Id added with a non-null value
curl -H "Request-Id:12345" http://localhost:8080/hello


# to test using add filter at, comment out the below
correct
curl -H "Authorization:SD9cICj1le" http://localhost:8080/hello
incorrect
curl -vH "Authorization:SD9cICj1le" http://localhost:8080/hello

.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
.addFilterAfter(new AuthLoggingFilter(), BasicAuthenticationFilter.class)

## if we need a filter called only once per REQUEST then use OncePerRequestFilter

#if we want to implement logic if a filter should run or not
use: override shouldNotFilter()  and implement logic in it to return a true or false
default: false ctrl + click to vet


OncePerRequestFilter does not apply to async or error dispatch request
use shouldNotFilterAsyncDispatch or isAsyncDispatch 
and shouldNotFilterErrorDispatch



#USE HTTPS  --> self-signed certificate:
openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"
winpty openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365
winpty openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"


add certificate.p12 to resources folder
then add the below to application.yml
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:certificate.p12
server.ssl.key-store-password=12345 


# skip authenticity of ssl
use -k option
