package com.zikozee.security.customsecuritycontext;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Ezekiel Eromosei
 * @created: 09 April 2022
 */

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = CustomSecurityContextFactory.class)
public @interface WithCustomUser {

    String username(); // we can define whatever details we need to create the mock Authentication
    String authority();
}
