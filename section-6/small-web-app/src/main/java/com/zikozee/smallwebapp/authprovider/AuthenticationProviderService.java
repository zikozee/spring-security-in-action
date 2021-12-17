package com.zikozee.smallwebapp.authprovider;

import com.zikozee.smallwebapp.userdetails.CustomUserDetails;
import com.zikozee.smallwebapp.userdetails.JpaUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@AllArgsConstructor
public class AuthenticationProviderService implements AuthenticationProvider {

    private JpaUserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SCryptPasswordEncoder sCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        CustomUserDetails customUserDetails = userDetailsService.loadUserByUsername(username);

        switch (customUserDetails.getUser().getAlgorithm()){
            case BCRYPT:
                return checkPassword(customUserDetails, password, bCryptPasswordEncoder);
            case SCRYPT:
                return checkPassword(customUserDetails, password, sCryptPasswordEncoder);
            default:
                throw new BadCredentialsException("Bad Credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }// this indicates that the supported authentication type is UsernamePasswordAuthenticationToken


    private Authentication checkPassword(CustomUserDetails customUserDetails, String rawPassword, PasswordEncoder passwordEncoder) {
        if(passwordEncoder.matches(rawPassword, customUserDetails.getPassword()))
            return new UsernamePasswordAuthenticationToken(customUserDetails.getUsername(), customUserDetails.getPassword(), customUserDetails.getAuthorities());
        else throw new BadCredentialsException("Bad Credentials");
    }
}
