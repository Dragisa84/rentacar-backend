package com.rentacar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * @created type Car
 * /p
 * @created by dstankovski
 * /p
 * @since 25/10/2023
 */
@Entity(name = "cars")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;
    private String model;
    private int year;
    private double price;
    private boolean available;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "car")
    @ToString.Exclude
    private List<Reservation> reservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year && Double.compare(price, car.price) == 0 && available == car.available && Objects.equals(id, car.id) && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(owner, car.owner) && Objects.equals(reservations, car.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year, price, available, owner, reservations);
    }
}
