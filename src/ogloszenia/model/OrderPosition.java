package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class OrderPosition implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "how_much")
    private int numberOfOrder;

    @ManyToOne
    @JoinColumn
    private Toys toys;

    @ManyToOne
    @JoinColumn
    private Order order;

    public OrderPosition() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Toys getToys() {
        return toys;
    }

    public void setToys(Toys toys) {
        this.toys = toys;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
