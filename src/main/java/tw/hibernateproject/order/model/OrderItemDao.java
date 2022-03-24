package tw.hibernateproject.order.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class OrderItemDao  implements IOrderItemDao {
	private Session session;
	
	public OrderItemDao(){
		
	}
	
	public OrderItemDao(Session session) {
		this.session=session;
	}
	@Override
	public OrderItem insert(OrderItem oiBean) {
		Order resultBean = session.get(Order.class,oiBean.getOrder_id());
		if(resultBean!=null) {
			session.save(oiBean);
			return oiBean;
		}
		return null;
	}
	@Override
	public OrderItem selectById(int id) {
		return session.get(OrderItem.class, id);
	}
	@Override
	public List<OrderItem> selectAll(){
		Query<OrderItem> query = session.createQuery("from OrderItem",OrderItem.class);
		return query.list();
	}
	@Override
	public OrderItem update(int item_id,int orderitem_amount) {
		OrderItem resultBean = session.get(OrderItem.class, item_id);
		
		if(resultBean!=null) {
			resultBean.setOrderitem_amount(orderitem_amount);
			
		}
		return resultBean;
		
	}
	@Override
	public boolean delete(int item_id) {
		Order resultBean = session.get(Order.class, item_id);
		
		if(resultBean!=null) {
			session.delete(resultBean);
			return true;
		}
		return false;
	}
}
