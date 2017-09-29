package ogloszenia.repository;

import ogloszenia.model.Order;
import ogloszenia.model.OrderPosition;
import ogloszenia.model.Toys;
import ogloszeniar.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {

    public static boolean createOrder(HashMap<Toys, Integer> toys, String email){

        Session session = null;

        try {
            session = HibernateUtil.openSession();
            Order order = new Order(email, toys);

            Set<OrderPosition> orderPositionSet = new HashSet<>();

            toys.forEach((toy, amount) -> orderPositionSet.add(new OrderPosition(amount, toy, order)));
            for(OrderPosition op: orderPositionSet){
                session.save(op);
            }
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }

        }
        return false;
    }
}
