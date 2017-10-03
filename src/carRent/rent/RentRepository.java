package carRent.rent;

import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class RentRepository {

    public static boolean save(Rent rent){
        Session session =null;

        try {
            session = HibernateUtil.openSession();
            session.save(rent);
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
}
