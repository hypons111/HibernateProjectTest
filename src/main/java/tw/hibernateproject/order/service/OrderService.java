package tw.hibernateproject.order.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernateproject.order.model.Order;
import tw.hibernateproject.order.model.OrderDao;

public class OrderService implements IOrderService {
	
	private OrderDao oDao;
	
	public OrderService(Session session) {
		oDao = new OrderDao(session);
	}

	@Override
	public Order selectById(int id) {
		return oDao.selectById(id);
	}

	@Override
	public List<Order> selectAll() {
		return oDao.selectAll();
	}

	@Override
	public Order insert(Order oBean) {
		return oDao.insert(oBean);
	}

	@Override
	public Order update(int order_id, int orderpd_amount) {
		return oDao.update(order_id, orderpd_amount);
	}

	@Override
	public boolean delete(int order_id) {
		return oDao.delete(order_id);
	}

}
