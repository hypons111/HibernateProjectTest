package tw.hibernateproject.product.model;

import java.io.File;
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
		System.out.println("ProductDao: insert: " + product);
		Product productResult = session.get(Product.class, product.getP_ID());
		
		if (productResult == null) {
			session.save(product);
			return product;
		}
		return null;
	}

	@Override
	public Product selectByID(int id) {
		System.out.println("ProductDao: selectByID");
		return session.get(Product.class, id);
	}

	@Override
	public List<Product> selectAll() {
		System.out.println("ProductDao: selectAll");
		Query<Product> result = session.createQuery("from Product", Product.class);
		return result.list();
	}
	
	@Override
	public Product update(int id, String name, String type, int stock, double cost, double price, String Description) {
		Product result = session.get(Product.class, id);
		if (result != null) {
			result.setP_Name(name);
			result.setP_Type(type);
			result.setP_Stock(stock);
			result.setP_Cost(cost);
			result.setP_Price(price);
			result.setP_Description(Description);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		Product result = session.get(Product.class, id);
		System.out.println("ProductDao: delete: " + result);
		if (result != null) {
			session.delete(result);
			File image = new File("C:/DataSource/workspace/HibernateProjectTest/src/main/webapp/admin/images/product/" + result.getP_Image());
			image.delete();
			return true;
		}
		return false;
	}
}