package carRent.rent;

import carRent.rent.Car;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    Set<Car> carSet;


}
