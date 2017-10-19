package carRent.rent;

import carRent.account.User;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class OptionRepository {
    public static List<Option> findAll(){

        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT o FROM Option o";
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

    public static boolean save(Option option){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(option);
            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
    }

    public static boolean delete(int optionId) {

        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            Option o = session.find(Option.class, optionId);
            if (o != null) {
                session.delete(o);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
            return false;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
