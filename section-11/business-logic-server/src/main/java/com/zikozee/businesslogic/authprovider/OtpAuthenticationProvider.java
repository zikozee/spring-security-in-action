package com.zikozee.businesslogic.authprovider;

import com.zikozee.businesslogic.authprovider.authobject.OtpAuthentication;
import com.zikozee.businesslogic.authserverproxy.AuthenticationServerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Component
@RequiredArgsConstructor
public class OtpAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationServerProxy proxy;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String code = authentication.getCredentials().toString();

        boolean result = proxy.sendOtp(username, code);

        if(result){
            return new OtpAuthentication(username, code);
        }

        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthentication.class.isAssignableFrom(authentication);
    }
}
