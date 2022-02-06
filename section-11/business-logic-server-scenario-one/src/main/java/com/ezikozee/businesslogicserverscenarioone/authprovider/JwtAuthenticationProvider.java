package com.ezikozee.businesslogicserverscenarioone.authprovider;

import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.JwtAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.OtpAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authprovider.authobject.UsernamePasswordAuthentication;
import com.ezikozee.businesslogicserverscenarioone.authserverproxy.AuthenticationServerProxy;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        log.info(userName);
        log.info(authorities.toString());

        return new JwtAuthentication(userName, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.isAssignableFrom(authentication);
    }
}
