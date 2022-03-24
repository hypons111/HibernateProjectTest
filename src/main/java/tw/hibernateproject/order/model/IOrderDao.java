package tw.hibernateproject.order.model;

import java.util.List;

public interface IOrderDao {
	public Order selectById(int id);
	public List<Order> selectAll();
	public Order insert(Order oBean);
	public Order update(int order_id,Order order);
	public boolean delete(int order_id);
}
