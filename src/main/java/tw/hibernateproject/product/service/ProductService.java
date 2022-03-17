package tw.hibernateproject.product.service;

import java.util.List;
import org.hibernate.Session;

import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.model.ProductDao;


public class ProductService implements IProductService  {

	private ProductDao service;
	
	public ProductService(Session session) {
		System.out.println("ProductService");
		service = new ProductDao(session);
	}
	
	@Override
	public Product insert(Product product) {
		return service.insert(product);
	}

	@Override
	public Product selectByID(int id) {
		return service.selectByID(id);
	}

	@Override
	public List<Product> selectAll() {
		return service.selectAll();
	}

	@Override
	public Product update(int id, String name) {
		return service.update(id, name);
	}

	@Override
	public boolean delete(int id) {
		return service.delete(id);
	}
}
