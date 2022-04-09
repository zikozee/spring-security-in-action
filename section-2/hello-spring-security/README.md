# Access Endpoint
- curl -u "john:12345" http://localhost:8080/hello    200 OK
- curl  http://localhost:8080/hello                   401 UNAUTHORIZED

- using
       .permitAll(); // to allow no authentication for all endpoints


# Alternative to defining PasswordEncoder and UserDetailService Bean
- we use override the "configure(AuthenticationManagerBuilder auth)"
- and set the userdetailservice ans passwordEncoder in it.

# Another alternative
- define Password Encoder Bean
- define userDetailsService in the  "configure(AuthenticationManagerBuilder auth)" #
- but don't configure the passwordEncoder in it (#)
- This still works fine as the PasswordEncoder Bean already exist in context



# AUTH FLOW
- The AuthenticationProvider implements the authentication logic. :-> CustomAuthenticationProvider
- It receives the request from the AuthenticationManager and delegates finding the user to a UserDetailsSerService, 
- and verifying the password to a PasswordEncoder.

### UNIT TEST -- see also ch 05 (security context, form-based-login), ch 06(testing with mock user, repo),  ch 16, ch 10(cors-csrf-protection)
- **@WithMockUser**  skips authentication: assumes fake user is already authenticated
- **@WithUserDetails** requires a bean of userdetails service in the spring context, i enforced this 
- by defining the optional **userDetailsServiceBeanName**
- using requestPostProcessor **httpBasic** to test authentication

### USING CUSTOM SECURITY CONTEXT
- create a custom annotation we would use say @WithCustomUser
- crate a class that implements the WithSecurityContext<WithCustomUser>
- we link annotation and factory class to create the test securityContext