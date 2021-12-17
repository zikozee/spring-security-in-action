package com.zikozee.smallwebapp.repository;

import com.zikozee.smallwebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByUsername(String username);
}
