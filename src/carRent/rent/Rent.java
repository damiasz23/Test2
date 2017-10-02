package carRent.rent;

import carRent.rent.Car;
import carRent.rent.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Customer customer;
    private ZonedDateTime startDate;
    private ZonedDateTime endData;

    private BigDecimal rentPrice;
    private BigDecimal insurancePrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Car car;

    private String description;
    private boolean discount;



}
