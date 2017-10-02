package carRent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarRepository {

    public static Optional<Car> findCar(int id){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Car.class, id));

        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session!=null && session.isOpen()){
                session.isOpen();
            }
        }

    }
    public static List<Car> findAviliblecCar(ZonedDateTime startData, ZonedDateTime endData) {
        return findAviliblecCar(startData, endData, null);
    }

    public static List<Car> findAviliblecCar(ZonedDateTime startData, ZonedDateTime endData, Integer capasity){
        return findAviliblecCar(startData, endData, capasity, null);
    }

    public static List<Car> findAviliblecCar(ZonedDateTime startData, ZonedDateTime endData, Integer capasity, CarSegment carSegment){
        return findAviliblecCar(startData, endData, capasity, carSegment, null);

    }

    public static List<Car> findAviliblecCar(ZonedDateTime startData, ZonedDateTime endData, Integer capasity, CarSegment carSegment, Make make){
        return Collections.emptyList();
    }
}
