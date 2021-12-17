# Documentation

- Notice in **checkPassword()** method, we are returning 
- UsernamePasswordAuthenticationToken because that is we
- specified that Authentication Provider supports in the **AuthenticationProviderService class**

<br/>

## UsernamePasswordAuthenticationToken constructor
- the constructor called sets authentication to true
- in case of two-factor authentication, we use the first that
- that takes no authority(-ies) and sets authentication to false