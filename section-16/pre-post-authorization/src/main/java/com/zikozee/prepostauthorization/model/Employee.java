package com.zikozee.prepostauthorization.model;

import lombok.*;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 21 Feb, 2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private String name;
    private List<String> books;
    private List<String> roles;
}
