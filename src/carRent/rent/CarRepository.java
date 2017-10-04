package carRent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CarRepository {

    public static boolean save(Car car){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(car);
            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }

        }
    }

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

    public static List<Car> findAvilibleCar(ZonedDateTime startDate, ZonedDateTime endDate) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT c FROM Car c WHERE c.id" +
                    " NOT IN (SELECT r.car.id FROM Rent r WHERE (r.startDate < :startDate AND r.endDate > :endDate  ) " +
                    "OR (  r.startDate > :endDate AND r.endDate > :startDate  ) ) ";
            Query query = session.createQuery(hgl);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();


        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.isOpen();
            }

        }

    }



    public static List<Car> findAviliblecCar(ZonedDateTime startData, ZonedDateTime endData, Integer capasity, CarSegment carSegment, Make make){

//        TODO dodac warunki z datami
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> query = criteriaBuilder.createQuery(Car.class);

            Root<Car> carRoot = query.from(Car.class);
            query.select(carRoot);

            Predicate makePredicate = criteriaBuilder.equal(carRoot.get("make"),make);
            Predicate carSegmentPredicate = criteriaBuilder.equal(carRoot.get("carSegment"), carSegment);
            Predicate capasityPredicate = criteriaBuilder.equal(carRoot.get("capasity"), capasity);

            Predicate and = criteriaBuilder.and(makePredicate, carSegmentPredicate);

            Predicate or = criteriaBuilder.or(and, capasityPredicate);
            query.where(or);

            return session.createQuery(query).getResultList();

        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
}
