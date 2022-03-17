package tw.hibernateproject.product.service;

import java.util.List;
import org.hibernate.Session;
import tw.hibernateproject.product.model.ProductType;
import tw.hibernateproject.product.model.ProductTypeDao;

public class ProductTypeService implements IProductTypeService  {

	private ProductTypeDao productTypeDao;
	
	public ProductTypeService(Session session) {
		System.out.println("ProductTypeService");
		productTypeDao = new ProductTypeDao(session);
	}
	
	@Override
	public ProductType insert(ProductType product) {
		return productTypeDao.insert(product);
	}

	@Override
	public ProductType selectByID(int id) {
		return productTypeDao.selectByID(id);
	}

	@Override
	public List<ProductType> selectAll() {
		return productTypeDao.selectAll();
	}

	@Override
	public ProductType update(int id, String name) {
		return productTypeDao.update(id, name);
	}

	@Override
	public boolean delete(int id) {
		return productTypeDao.delete(id);
	}
}
