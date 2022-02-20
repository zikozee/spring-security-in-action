### ASYMMETRIC KEY RESOURCE SERVER

- we generate public key using the below referencing the file that hold the private key i.e asym.jks
- ```text
           
  keytool -list -rfc --keystore asym.jks | openssl x509 -inform pem -pubkey
    ```
- we configure public key in the **JwtAccessConverter** by setting th verifier key