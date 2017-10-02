package ogloszenia;

import ogloszenia.model.Color;
import ogloszenia.model.Material;
import ogloszenia.model.Price;
import ogloszenia.model.Toys;
import ogloszenia.repository.OrderRepository;
import ogloszenia.repository.ToysRepository;
import ogloszeniar.hibernate.util.HibernateUtil;

import java.beans.Transient;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Lukasz on 27.09.2017.
 */
public class App {

    public static void main(String[] args) throws Exception {
        HibernateUtil.openSession();

//        Path path = Paths.get("C://Users//RENT//Desktop//doll.jpg");
//        byte[] image = Files.readAllBytes(path);
//
//        Path pathPdf = Paths.get("C://Users//RENT//Desktop//Wynik.pdf");
//        byte[] pdf = Files.readAllBytes(pathPdf);
//
//        Price dollPrice = new Price(new BigDecimal(10), "PLN");
//        Toys doll = new Toys("lalka", dollPrice, Color.RED, 1, true, LocalDate.now(), image, Material.WOOD, pdf);
//
//        ToysRepository.save(doll);
//
//        List<Toys> toysWithPriceLessThen11 = ToysRepository.findToysPriceLessThenParamiter(new BigDecimal(11));
//        toysWithPriceLessThen11.forEach(x -> System.out.println(x.getName()));
//
//        List<Toys> toysWithPriceLessThen5 = ToysRepository.findToysPriceLessThenParamiter(new BigDecimal(5));
//        System.out.println("Toys for less then 5");
//        toysWithPriceLessThen5.forEach(x -> System.out.println(x.getName()));
//
//
//        Long count = ToysRepository.countAll();
//        System.out.println("Liczba zabawek: " +count);
//
//        HashMap<Toys, Integer> listaZakupow = new HashMap<>();
//        listaZakupow.put(toysWithPriceLessThen11.stream().findAny().orElse(doll),
//                new Integer(5));
//
//        // TWORZENIE ZAMOWIENIA
//        OrderRepository.createOrder(listaZakupow, "test@gmail.com");
//
////        OrderRepository.createOrder(listaZakupow, "test@gmail.com");
//
//        Optional<Toys> toy = ToysRepository.findToy(14);
//        if (toy.isPresent()) {
//            toy.get().getId();
//        }
//        toy.ifPresent(x -> System.out.println("z IfPresent " + x.getId()));
//
////        if (toy.isPresent()) {
////            ToysRepository.deliteToy(toy.get());
////        }
//
//        if(toy.isPresent()){
//            Toys t = toy.get();
//            t.setAvailability(50);
//            t.setName("car");
//            t.setColor(Color.BLACK);
//            t.setMaterial(Material.PLASTIC);
//            ToysRepository.update(t);
//
//            System.out.println(OrderRepository.findAllOrdersByToys(t).size());
//        }
//
//        String s = ToysRepository.findToysWithStanAndName().get(0).toString();
//
//        ToysRepository.updatePrice(new BigDecimal(55.30));
//
//
//        System.out.println(ToysRepository.findToysByNameLike("ar").size());
    }
}
