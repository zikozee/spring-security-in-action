- we name the database spring, and we name one of the tables users and the other authorities. 
- These names are the default table names known by the JdbcUserDetailsManager. As
- you’ll learn at the end of this section, the JdbcUserDetailsManager implementation is flexible and 
- lets you override these default names if you want to do so



- we use the default. no @Entity needed. just ensure you have a schema/database called spring.
- though we can override


- we load schema script via resources folder

curl -u john:12345 http://localhost:8080/hello
