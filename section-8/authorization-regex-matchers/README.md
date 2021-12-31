## REGEX MATCHER
- Use this only if requirements are hard and MVC and ANT can't solve it
### authenticating for US region and English Language
- curl -u john:12345 http://localhost:8080/video/us/en :::: 200
- curl -u jane:12345 http://localhost:8080/video/us/en :::: 200
### authenticating for FR region and FRENCH Language
- curl -u john:12345 http://localhost:8080/video/fr/fr :::: 403
- curl -u jane:12345 http://localhost:8080/video/fr/fr :::: 200