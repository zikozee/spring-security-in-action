## PRE-POST FILTERING
- Suppose we don't want to forbid a method but ensure that the parameters follow a set of rules
- Another scenario ensuring the method's caller only receives an authorized part of the returned value
- helps decouple authorization rules from the business logic

### Categories
- Prefiltering :-> The framework filters values of the parameters before calling the method
- Postfiltering :->  The framework filters the returned value after calling the method

### NOTE
 - Prefiltering can  be used only if the method receives an array or collection as a parameter
 - Postfiltering can be applies only if the returned value is an array or collection


### TEST -- check number of products returned
- curl -u 'nikolai:12345' http://localhost:8080/sell | json_pp
- curl -u 'julien:12345' http://localhost:8080/sell | json_pp
- 
- ALWAYS Provide a mutable list else an error is thrown :: in my case UnsupportedOperationException
- ```text
    java.lang.UnsupportedOperationException: null
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:72) ~[na:na]...
```
- try using List.of(...)
- ```json
    {
    "timestamp": "2022-02-27T15:40:56.012+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/sell"
    }
  ```

## POST-FILTERING
- Unlike **pre-filtering*, post-filtering throws an exception to the caller when the returned value doesn't
- follow the authorization rule
- it must be used on a method returning a collection

## TEST
- curl -u 'nikolai:12345' http://localhost:8080/find | json_pp
- curl -u 'julien:12345' http://localhost:8080/find | json_pp