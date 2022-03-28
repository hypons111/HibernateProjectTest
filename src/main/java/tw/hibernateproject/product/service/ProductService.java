package tw.hibernateproject.product.service;

import java.util.List;
import org.hibernate.Session;

import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.model.ProductDao;
import tw.hibernateproject.product.model.ProductType;


public class ProductService implements IProductService  {

	private ProductDao productDao;
	
	public ProductService(Session session) {
		productDao = new ProductDao(session);
	}

	@Override
	public Product insert(Product product) {
		return productDao.insert(product);
	}

	@Override
	public Product selectByID(int id) {
		return productDao.selectByID(id);
	}

	@Override
	public List<Product> selectAll() {
		return productDao.selectAll();
	}

	@Override
	public Product update(int id, String name, String type, int stock, double cost, double price, String Description) {
		System.out.println("ProductService: " + "update: ");
		return productDao.update(id, name, type, stock, cost, price, Description);
	}

	@Override
	public boolean delete(int id) {
		return productDao.delete(id);
	}
}
