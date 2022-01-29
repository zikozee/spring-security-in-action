package com.zikozee.businesslogic.dto;

import lombok.*;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String username;
    private String password;
    private String code;
}
