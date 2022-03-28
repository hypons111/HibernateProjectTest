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
		Product productResult = session.get(Product.class, product.getProduct_ID());
		
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
		System.out.println("ProductDao : update");
		Product productResult = session.get(Product.class, id);
		if (productResult != null) {
			System.out.println(productResult.getProduct_ID());
			System.out.println(productResult.getProduct_Name());
			System.out.println(productResult.getProduct_Type());
			System.out.println(productResult.getProduct_Stock());
			System.out.println(productResult.getProduct_Cost());
			System.out.println(productResult.getProduct_Price());
			System.out.println(productResult.getProduct_Image());
			productResult.setProduct_Name(name);
			productResult.setProduct_Type(type);
			productResult.setProduct_Stock(stock);
			productResult.setProduct_Cost(cost);
			productResult.setProduct_Price(price);
			productResult.setProduct_Description(Description);
		}
		System.out.println(productResult.getProduct_ID());
		System.out.println(productResult.getProduct_Name());
		System.out.println(productResult.getProduct_Type());
		System.out.println(productResult.getProduct_Stock());
		System.out.println(productResult.getProduct_Cost());
		System.out.println(productResult.getProduct_Price());
		System.out.println(productResult.getProduct_Image());
		return productResult;
	}

	@Override
	public boolean delete(int id) {
		Product result = session.get(Product.class, id);
		System.out.println("ProductDao: delete: " + result);
		if (result != null) {
			session.delete(result);
			File image = new File("C:/DataSource/workspace/HibernateProjectTest/src/main/webapp/admin/images/product/" + result.getProduct_Image());
			image.delete();
			return true;
		}
		return false;
	}
}