package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tooys")
public class Toys implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;

    @Embedded
    private Price price;
    @Enumerated(EnumType.STRING)
    private Color color;

    private int availability;
    private boolean discounted;
    private LocalDate expirationDate;

    @Lob
    private byte[] image;

    @Lob
    private byte[] pdf;

    @OneToOne
    private Atest atest;

    @Enumerated(EnumType.STRING)
    private  Material material;

    @Transient
    private Price productPrice;

    @OneToMany(mappedBy = "toys")
    Set<OrderPosition> orderPositionSet;

    public Toys() {
    }

    public Toys(String name, Price price, Color color, int availability, boolean discounted, LocalDate expirationDate, byte[] image, Material material, byte[] pdf) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.availability = availability;
        this.discounted = discounted;
        this.expirationDate = expirationDate;
        this.image = image;
        this.material = material;
        this.pdf = pdf;
    }

    public Set<OrderPosition> getOrderPositionSet() {
        return orderPositionSet;
    }

    public void setOrderPositionSet(Set<OrderPosition> orderPositionSet) {
        this.orderPositionSet = orderPositionSet;
    }

    public Price getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Price productPrice) {
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public void setDiscounted(boolean discounted) {
        this.discounted = discounted;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
