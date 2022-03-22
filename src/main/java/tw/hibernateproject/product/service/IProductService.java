package tw.hibernateproject.product.service;

import java.util.List;

import tw.hibernateproject.product.model.Product;
import tw.hibernateproject.product.model.ProductType;

public interface IProductService {
	
	Product insert(Product product);

	Product selectByID(int id);

	List<Product> selectAll();

	Product update(int id, String name, String type, int stock, double cost, double price, String Description);

	boolean delete(int id);

}