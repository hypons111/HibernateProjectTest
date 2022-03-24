package tw.hibernateproject.order.service;

import java.util.List;

import org.hibernate.Session;
import tw.hibernateproject.order.model.OrderItem;
import tw.hibernateproject.order.model.OrderItemDao;

public class OrderItemService implements IOrderItemService {
	
	private OrderItemDao oiDao;
	
	public OrderItemService(Session session) {
		oiDao = new OrderItemDao(session);
	}

	@Override
	public OrderItem insert(OrderItem oiBean) {
		return oiDao.insert(oiBean);
	}

	@Override
	public OrderItem selectById(int id) {
		return oiDao.selectById(id);
	}

	@Override
	public List<OrderItem> selectAll() {
		return oiDao.selectAll();
	}

	@Override
	public OrderItem update(int item_id, int orderitem_amount) {
		return oiDao.update(item_id, orderitem_amount);
	}

	@Override
	public boolean delete(int item_id) {
		return oiDao.delete(item_id);
	}

}
