package com.zikozee.customizecsrftokenrepository.repo;

import com.zikozee.customizecsrftokenrepository.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @created : 16 Jan, 2022
 */

@Repository
public interface JpaTokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> getTokensByIdentifier(String identifier);
}
