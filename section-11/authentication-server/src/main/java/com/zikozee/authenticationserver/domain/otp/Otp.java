package com.zikozee.authenticationserver.domain.otp;

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

@Entity(name = "AUTH_OTP")
@Table(name = "AUTH_OTP")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Otp {

    @Id
    private String username;
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Otp otp = (Otp) o;
        return username != null && Objects.equals(username, otp.username);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
