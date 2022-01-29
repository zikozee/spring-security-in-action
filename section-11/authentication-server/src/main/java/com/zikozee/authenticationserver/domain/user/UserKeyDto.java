package com.zikozee.authenticationserver.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ezekiel Eromosei
 * @created : 29 Jan, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserKeyDto {

    private String username;
}
