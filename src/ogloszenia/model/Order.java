package ogloszenia.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long productAmount;
    private LocalDateTime orderDate;
    private String email;


    @OneToMany(mappedBy = "order")
    Set<OrderPosition> orderPositionSet;


    public Order(String email, HashMap<Toys, Integer> orderPosition) {
        this.email = email;
        this.orderDate = LocalDateTime.now();
        this.productAmount = new Long(orderPosition.values().stream().mapToInt(x->x).sum());
    }


    public Set<OrderPosition> getOrderPositionSet() {
        return orderPositionSet;
    }

    public void setOrderPositionSet(Set<OrderPosition> orderPositionSet) {
        this.orderPositionSet = orderPositionSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Long productAmount) {
        this.productAmount = productAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
