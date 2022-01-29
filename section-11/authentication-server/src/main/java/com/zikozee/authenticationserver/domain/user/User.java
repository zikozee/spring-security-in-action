package com.zikozee.authenticationserver.domain.user;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author : Ezekiel Eromosei
 * @created : 27 Nov, 2021
 */

@Entity(name = "AUTH_USER")
@Table(name = "AUTH_USER")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    @Id
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return username != null && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
