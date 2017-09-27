package ogloszenia.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Atest implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "atest")
    Toys toys;

    String atestNumber;


    public Atest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Toys getToys() {
        return toys;
    }

    public void setToys(Toys toys) {
        this.toys = toys;
    }

    public String getAtestNumber() {
        return atestNumber;
    }

    public void setAtestNumber(String atestNumber) {
        this.atestNumber = atestNumber;
    }
}
