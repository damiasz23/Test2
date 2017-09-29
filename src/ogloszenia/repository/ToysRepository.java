package ogloszenia.repository;

import ogloszenia.model.Toys;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

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
}
