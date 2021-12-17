package com.zikozee.smallwebapp.userdetails;

import com.zikozee.smallwebapp.entity.User;
import com.zikozee.smallwebapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository
                        .getUserByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Problem during authentication"));

        return new CustomUserDetails(user);
    }
}
