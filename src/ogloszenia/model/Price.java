package ogloszenia.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
public class Price implements Serializable{

    private BigDecimal value;
    private String currencySymbol;

    public Price() {
    }

    public Price(BigDecimal value, String currencySymbol) {
        this.value = value;
        this.currencySymbol = currencySymbol;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
