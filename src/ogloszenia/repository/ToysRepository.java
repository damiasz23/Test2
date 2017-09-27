package ogloszenia.repository;

import ogloszenia.model.Toys;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ToysRepository {

    public static int save(Toys toys){
        try {
            Session session = HibernateUtil.openSession();
            session.save(toys);
            return toys.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
