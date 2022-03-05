package com.zikozee.postfilteringperfomance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Ezekiel Eromosei
 * @created: 05 March 2022
 */

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String owner;
}
