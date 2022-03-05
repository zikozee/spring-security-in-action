package com.zikozee.prepostfiltering.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Ezekiel Eromosei
 * @created: 27 February 2022
 */

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private String owner; // same as username
}
