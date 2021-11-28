package com.zikozee.authenticationserver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> getUserByUsername(String username);
}
