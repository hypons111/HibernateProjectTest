package tw.hibernateproject.order.service;

import java.util.List;

import tw.hibernateproject.order.model.OrderItem;

public interface IOrderItemService {
	public OrderItem insert(OrderItem oiBean);
	public OrderItem selectById(int id);
	public List<OrderItem> selectAll();
	public OrderItem update(int item_id,int orderitem_amount);
	public boolean delete(int item_id);
}
