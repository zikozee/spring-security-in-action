## POST-FILTERING-PERFORMANCE

- This favors optimizing queries before fetching
- as fetching directly and filtering within the application or using **post-filtering** to filter
- causes either memory out of heap or very poor performance


- solution
- bring dependency **spring-security-data**
- which in turn brings in **SecurityEvaluationContextExtension**
- we create a bean of this
- which allows us do this: (injection authentication into query)
- ```sql
    @Query("SELECT p from Product  p WHERE p.name LIKE %:text% AND " +
            "p.owner=?#{authentication.name}")
```

## TEST
- curl -u nikolai:12345 http://localhost:8080/products/c | json_pp
- curl -u julien:12345 http://localhost:8080/products/c | json_pp


