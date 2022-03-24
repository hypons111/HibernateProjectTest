package tw.hibernateproject.order.model;

import java.util.List;

public interface IOrderItemDao {
	public OrderItem insert(OrderItem oiBean);
	public OrderItem selectById(int id);
	public List<OrderItem> selectAll();
	public OrderItem update(int item_id,int orderitem_amount);
	public boolean delete(int item_id);
}
