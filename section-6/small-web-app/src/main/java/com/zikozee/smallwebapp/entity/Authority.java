package com.zikozee.smallwebapp.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author : Ezekiel Eromosei
 * @created : 17 Dec, 2021
 */

@Entity(name="AUTHORITY")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Authority authority = (Authority) o;
        return id != null && Objects.equals(id, authority.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
