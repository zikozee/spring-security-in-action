package com.zikozee.authenticationserver.domain.otp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Entity(name = "AUTH_OTP")
@Table(name = "AUTH_OTP")
@Data
public class Otp {

    @Id
    private String username;
    private String code;
}
