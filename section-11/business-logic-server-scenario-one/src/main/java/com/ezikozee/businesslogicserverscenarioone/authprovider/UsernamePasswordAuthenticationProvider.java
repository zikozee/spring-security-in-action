package com.ezikozee.businesslogicserverscenarioone.authprovider;

import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.UsernamePasswordAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authserverproxy.AuthenticationServerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Component
@RequiredArgsConstructor
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationServerProxy proxy;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        proxy.sendAuth(username, password);

        return new UsernamePasswordAuthentication(username, password);
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.isAssignableFrom(UsernamePasswordAuthentication.class);
//        return UsernamePasswordAuthentication.class.isAssignableFrom(authentication); // same
    }
}
