package com.zikozee.implementingauthentication.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 02 Dec, 2021
 */

@AllArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findAny().orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
