package carRent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.Query;

import java.util.Optional;

public class CustomerRepository {


    public static Optional<Customer> findByEmail(String email){

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hgl = "SELECT c FROM Customer c WHERE c.id = (SELECT u.id FROM User u WHERE u.email = :email)";
            Query query = (Query) session.createQuery(hgl);
            query.setParameter("email", email);
            return Optional.ofNullable((Customer) query.getSingleResult());
        }catch (Exception ex){
            ex.printStackTrace();
            return Optional.empty();
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }

        }
    }

    public static boolean update(Customer customer){

        return false;
    }

}
