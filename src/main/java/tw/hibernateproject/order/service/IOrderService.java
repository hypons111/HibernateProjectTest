package tw.hibernateproject.order.service;

import java.util.List;

import tw.hibernateproject.order.model.Order;

public interface IOrderService {
	public Order selectById(int id);
	public List<Order> selectAll();
	public Order insert(Order oBean);
	public Order update(int order_id,int orderpd_amount);
	public boolean delete(int order_id);
}
