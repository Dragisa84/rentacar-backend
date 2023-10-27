package com.rentacar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @created type Reservation
 * /p
 * @created by dstankovski
 * /p
 * @since 25/10/2023
 */
@Entity(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    private LocalDate pickupDate;
    private LocalDate returnDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(pickupDate, that.pickupDate) && Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, car, pickupDate, returnDate);
    }
}
