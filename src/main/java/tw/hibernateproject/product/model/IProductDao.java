package tw.hibernateproject.product.model;

import java.util.List;

public interface IProductDao {

	Product insert(Product product);
	Product selectByID(int id);
	List<Product> selectAll();
	Product update(int id, String name, String type, int stock, double cost, double price, String Description);
	boolean delete(int id);

}
