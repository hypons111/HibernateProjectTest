package tw.hibernateproject.product.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import tw.hibernateproject.product.model.ProductDao;

public class ProductDao implements IProductDao {

	private Session session;

	public ProductDao() {}

	public ProductDao(Session session) {
		this.session = session;
	}

	@Override
	public Product insert(Product product) {
		Product houseResult = session.get(Product.class, product.getP_ID());
		if (houseResult == null) {
			session.save(product);
			return product;
		}
		return null;
	}

	@Override
	public Product selectByID(int id) {
		return session.get(Product.class, id);
	}

	@Override
	public List<Product> selectAll() {
		System.out.println("selectAll");
		Query<Product> result = session.createQuery("from Product", Product.class);
		System.out.println(result.list().size());
		return result.list();
	}

	@Override
	public Product update(int id, String name) {
		Product result = session.get(Product.class, id);
		if (result != null) {
			result.setP_Name(name);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		Product result = session.get(Product.class, id);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
}
