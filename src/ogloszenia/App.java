package ogloszenia;

import ogloszenia.model.Color;
import ogloszenia.model.Material;
import ogloszenia.model.Price;
import ogloszenia.model.Toys;
import ogloszenia.repository.ToysRepository;
import ogloszeniar.hibernate.util.HibernateUtil;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {
        HibernateUtil.openSession();

        Price dollPrice = new Price(new BigDecimal(10), "PLN");
        Toys doll = new Toys("lalka",
                dollPrice,
                Color.WHITE,
                10,
                true,
                LocalDate.now(),
                Material.WOOD);

        ToysRepository.save(doll);
    }

}
