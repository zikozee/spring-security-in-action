package com.ezikozee.businesslogicserverscenarioone.authprovider.authobject;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 Feb, 2022
 */

public class JwtAuthentication extends UsernamePasswordAuthenticationToken {

    public JwtAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
