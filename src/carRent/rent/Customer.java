package carRent.rent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private LocalDateTime driversLicenceDate;

    @Transient //adnotacja zebyu nie pokazywal tego pola w tabeli
    private Boolean isExperience;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    Set<Rent> rentSet;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, LocalDateTime birthday, LocalDateTime driversLicenceDate, Boolean isExperience, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.driversLicenceDate = driversLicenceDate;
        this.isExperience = isExperience;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getDriversLicenceDate() {
        return driversLicenceDate;
    }

    public void setDriversLicenceDate(LocalDateTime driversLicenceDate) {
        this.driversLicenceDate = driversLicenceDate;
    }

    public Boolean getExperience() {
        return isExperience;
    }

    public void setExperience(Boolean experience) {
        isExperience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Rent> getRentSet() {
        return rentSet;
    }

    public void setRentSet(Set<Rent> rentSet) {
        this.rentSet = rentSet;
    }
}
