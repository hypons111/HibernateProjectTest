package tw.hibernateproject.product.model;

import java.util.List;

public interface IProductTypeDao {

	ProductType insert(ProductType product);
	ProductType selectByID(int id);
	List<ProductType> selectAll();
	ProductType update(int id, String name);
	boolean delete(int id);

}