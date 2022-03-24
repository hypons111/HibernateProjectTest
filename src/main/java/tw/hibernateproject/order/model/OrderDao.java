package tw.hibernateproject.order.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class OrderDao implements IOrderDao {
	private Session session;
	
	public OrderDao(){
		
	}
	
	public OrderDao(Session session) {
		this.session=session;
	}
	@Override
	public Order insert(Order oBean) {
		Order resultBean = session.get(Order.class,oBean.getOrder_id());
		if(resultBean!=null) {
			session.save(oBean);
			return oBean;
		}
		return null;
	}
	@Override
	public Order selectById(int id) {
		return session.get(Order.class, id);
	}
	@Override
	public List<Order> selectAll(){
		Query<Order> query = session.createQuery("from Order",Order.class);
		return query.list();
	}
	@Override
	public Order update(int order_id,int orderpd_amount) {
		Order resultBean = session.get(Order.class, order_id);
		
		if(resultBean!=null) {
			resultBean.setOrderpd_amount(orderpd_amount);
			
		}
		return resultBean;
		
	}
	@Override
	public boolean delete(int order_id) {
		Order resultBean = session.get(Order.class, order_id);
		
		if(resultBean!=null) {
			session.delete(resultBean);
			return true;
		}
		return false;
	}
}
