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

