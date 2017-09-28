package ogloszenia;

import ogloszenia.model.Color;
import ogloszenia.model.Material;
import ogloszenia.model.Price;
import ogloszenia.model.Toys;
import ogloszenia.repository.ToysRepository;
import ogloszeniar.hibernate.util.HibernateUtil;

import java.beans.Transient;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {
        HibernateUtil.openSession();

        Path path = Paths.get("C://Users//RENT//Desktop//doll.jpg");
        byte[] image = Files.readAllBytes(path);

        Path pathPdf = Paths.get("C://Users//RENT//Desktop//Wynik.pdf");
        byte[] pdf = Files.readAllBytes(pathPdf);

        Price dollPrice = new Price(new BigDecimal(10), "PLN");
        Toys doll = new Toys("lalka",dollPrice,Color.RED,1, true, LocalDate.now(), image,Material.WOOD, pdf);

        ToysRepository.save(doll);

        List<Toys> toysWithPriceLessThen11 = ToysRepository.findToysPriceLessThenParamiter(new BigDecimal(11));
        toysWithPriceLessThen11.forEach(x-> System.out.println(x.getName()));

        List<Toys> toysWithPriceLessThen5 = ToysRepository.findToysPriceLessThenParamiter(new BigDecimal(5));
        System.out.println("Toys for less then 5");
        toysWithPriceLessThen5.forEach(x-> System.out.println(x.getName()));



    }

}
