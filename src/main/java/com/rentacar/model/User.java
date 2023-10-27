package com.rentacar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @created type User
 * /p
 * @created by dstankovski
 * /p
 * @since 25/10/2023
 */
@Entity(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Reservation> reservations;
    private Date createDate;
    private Date modifyDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(reservations, user.reservations) && Objects.equals(createDate, user.createDate) && Objects.equals(modifyDate, user.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, reservations, createDate, modifyDate);
    }
}
