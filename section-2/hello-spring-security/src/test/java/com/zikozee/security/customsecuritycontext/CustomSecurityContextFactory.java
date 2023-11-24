package com.zikozee.security.customsecuritycontext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 09 April 2022
 */

public class CustomSecurityContextFactory implements WithSecurityContextFactory<WithCustomUser> {
    @Override
    public SecurityContext createSecurityContext(WithCustomUser withCustomUser) {

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(withCustomUser.username(), null, List.of(withCustomUser::authority));

        securityContext.setAuthentication(usernamePasswordAuthenticationToken);

        return securityContext;
    }
}
