### TESTING BASED ON CONFIG
- curl -XPOST http://localhost:8080/a :::::::200
- curl -v -XGET http://localhost:8080/a ::::::: 401
- curl -u john:12345 -XGET http://localhost:8080/a ::::::: 200
- curl -vu john:12345 -XGET http://localhost:8080/a/b ::::::: 403
