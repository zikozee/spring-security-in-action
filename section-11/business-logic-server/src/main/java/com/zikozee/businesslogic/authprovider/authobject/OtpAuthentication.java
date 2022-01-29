package com.zikozee.businesslogic.authprovider.authobject;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

public class OtpAuthentication extends UsernamePasswordAuthenticationToken {

    public OtpAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public OtpAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
