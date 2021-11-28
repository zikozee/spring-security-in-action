package com.zikozee.authenticationserver.domain.otp;

import com.zikozee.authenticationserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> getOtpByUsername(String username);
}
