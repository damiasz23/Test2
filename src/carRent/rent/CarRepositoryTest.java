package carRent.rent;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;


public class CarRepositoryTest {

    @Test
    public void save(){
        Engine engine = new Engine(new BigDecimal(4500), EngineType.DIESEL, new BigDecimal(23), GearBox.AUTOMATIC,300, 500);
        Car car = new Car("SKODA", Make.SKODA, 5, engine, CarSegment.VIP, Color.BLACK, new BigDecimal(500), new BigDecimal(100) );
        CarRepository.save(car);

    }
    @Test
    public void findAviliblecCarTest() throws Exception{
        List<Car> aviliblecSkodaCar = CarRepository.findAviliblecCar(ZonedDateTime.now(), ZonedDateTime.now(), 5, CarSegment.VIP, Make.SKODA);

        Assert.assertTrue("find car",aviliblecSkodaCar.size()>0);


        List<Car> aviliblecKiaCar = CarRepository.findAviliblecCar(ZonedDateTime.now(), ZonedDateTime.now(), 5, CarSegment.VIP, Make.SKODA);

        Assert.assertTrue("find car",aviliblecKiaCar.size()==0);
    }

    @Test
    public void testRentCar(){
        List<Car> aviliblecSkodaCar = CarRepository.findAviliblecCar(ZonedDateTime.now(), ZonedDateTime.now(), 5, CarSegment.VIP, Make.SKODA);

        Optional<Car> car = aviliblecSkodaCar.stream().findAny();
        if(car.isPresent()){
            car.get().rentCar(new Customer(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));
        }
    }
    @Test
    public void testAvilible(){
        Engine engine = new Engine(new BigDecimal(4500), EngineType.DIESEL, new BigDecimal(23), GearBox.AUTOMATIC,300, 500);
        Car car = new Car("SKODA", Make.KIA, 5, engine, CarSegment.VIP, Color.BLUE, new BigDecimal(300), new BigDecimal(90) );
        CarRepository.save(car);

        car.rentCar(new Customer(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));
        List<Car> avilibleCar = CarRepository.findAvilibleCar(ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        Assert.assertEquals(car, CarRepository.findCar(car.getId()).get());
        Assert.assertFalse("rent car is no longer avelible", avilibleCar.contains(car));

        car.rentCar(new Customer(), ZonedDateTime.now().plusDays(2), ZonedDateTime.now().plusDays(5));
        List<Car> avilibleCar2 = CarRepository.findAvilibleCar(ZonedDateTime.now(), ZonedDateTime.now().plusDays(3));


        Assert.assertFalse("rent car is no longer avelible", avilibleCar2.contains(car));
    }
}