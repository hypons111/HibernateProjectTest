package tw.hibernateproject.product.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import tw.hibernateproject.product.model.ProductDao;

public class ProductTypeDao implements IProductTypeDao {

	private Session session;

	public ProductTypeDao() {}

	public ProductTypeDao(Session session) {
		this.session = session;
	}

	@Override
	public ProductType insert(ProductType product) {
		System.out.println("ProductTypeDao: insert");
		Product houseResult = session.get(Product.class, product.getPT_ID());
		if (houseResult == null) {
			session.save(product);
			return product;
		}
		return null;
	}

	@Override
	public ProductType selectByID(int id) {
		System.out.println("ProductTypeDao: selectByID");
		return session.get(ProductType.class, id);
	}

	@Override
	public List<ProductType> selectAll() {
		System.out.println("ProductTypeDao: selectAll");
		Query<ProductType> result = session.createQuery("from ProductType", ProductType.class);
		return result.list();
	}

	@Override
	public ProductType update(int id, String name) {
		System.out.println("ProductTypeDao: update");
		ProductType result = session.get(ProductType.class, id);
		if (result != null) {
			result.setPT_Name(name);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		ProductType result = session.get(ProductType.class, id);
		System.out.println("ProductTypeDao: delete: " + result);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
}
