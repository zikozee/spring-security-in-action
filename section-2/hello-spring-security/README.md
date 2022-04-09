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

# UNIT TEST
- **@WithMockUser**  skips authentication: assumes user is already authenticated