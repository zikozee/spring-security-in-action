package com.zikozee.authenticationserver.domain.user;

import lombok.Data;

import javax.persistence.*;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Entity(name = "AUTH_USER")
@Table(name = "AUTH_USER")
@Data
public class User {

    @Id
    private String username;
    private String password;
}
