package tw.hibernateproject.order.action;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernateproject.member.model.Member;
import tw.hibernateproject.order.model.Order;
import tw.hibernateproject.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Long datetime = System.currentTimeMillis();
			Member member = new Member(1011, "王孝小","女", "AAA", "1234", 0, "QQQ@FF", "1.jpg", new Timestamp(datetime), 0);
            
            
            Order o1 = new Order(new Timestamp(datetime), 0, 0);
            Order o2 = new Order(new Timestamp(datetime), 2, 9);
            Order o3 = new Order(new Timestamp(datetime), 5, 6);

            o1.setMember(member);
            o2.setMember(member);
            o3.setMember(member);
        
            
            Set<Order> Orders = new HashSet<Order>();
            //Set<StockTransaction> stockTrans = new LinkedHashSet<StockTransaction>();
            Orders.add(o1);
            Orders.add(o2);
            Orders.add(o3);
            
            member.setOrders(Orders);
            
            session.save(member);
			
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
