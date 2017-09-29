package ogloszenia.repository;

import ogloszenia.model.Toys;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ToysRepository {

    public static int save(Toys toys){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(toys);
            return toys.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

//    SELECT z FROM Toys z WHERE z.price.value < :pric

    public static List<Toys> findToysPriceLessThenParamiter(BigDecimal price){
        Session session = null;
        try {

            session = HibernateUtil.openSession();

            String hgl = "SELECT t FROM Toys t WHERE t.price.value < :price";
            Query query = session.createQuery(hgl);
            query.setParameter("price", price);

            List<Toys> result = query.getResultList();
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
        finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }
    public static Long countAll(){
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT COUNT(t) FROM Toys t";
            Query query = session.createQuery(hgl);
            Long count = (Long) query.getSingleResult();
            return count;
        }catch (Exception ex){
            ex.printStackTrace();
            return new Long(-1);
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public static Optional<Toys> findToy(int id){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(Toys.class,id));

        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session !=null&&session.isOpen()){
                session.close();
            }
        }
    }

    public static boolean deliteToy(Toys toys) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            session.delete(toys);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (session.getTransaction().isActive() && session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session.isOpen() && session != null) {
                session.close();
            }
        }
    }
        public static boolean update(Toys toys){
            Session session = null;
            try {
                session = HibernateUtil.openSession();
                session.beginTransaction();
                session.update(toys);
                session.getTransaction().commit();
                return true;
            }catch (Exception ex){
                if(session!=null&&session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                }
                ex.printStackTrace();
                return false;
            }finally {
                if(session != null && session.isOpen()){
                    session.close();
                }
            }
    }

    public static List<Toys> findToysWithStanAndName(){
            Session session = null;
            try {
                session = HibernateUtil.openSession();
                String hgl = "SELECT new Toys (name, availability) FROM Toys t ";
                Query query = session.createQuery(hgl);
                return query.getResultList();

            }catch (Exception ex){
                ex.printStackTrace();
                return Collections.emptyList();
            }finally {
                if(session!=null && session.isOpen()){
                    session.close();

                }

            }
    }

    public static boolean updatePrice(BigDecimal price){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.beginTransaction();
            String hgl = "UPDATE Toys SET value = :price WHERE id >0";
            Query query = session.createQuery(hgl);
            query.setParameter("price", price);
            query.executeUpdate();
            session.getTransaction().commit();
            return true;

        }catch (Exception ex){
            if(session!=null&&session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            return false;
        }finally {
            if (session != null && session.isOpen()) {
                session.close();

            }
        }
    }

    public static List<Toys> findToysByNameLike(String name){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT t FROM Toys t WHERE t.name like :name";
            Query query = session.createQuery(hgl);
            query.setParameter("name", "%"+name+"%");
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }finally {
            if(session!=null&&session.isOpen()){
                session.close();
            }
        }
    }
}
