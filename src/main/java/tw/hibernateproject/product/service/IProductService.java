package tw.hibernateproject.product.service;

import java.util.List;

import tw.hibernateproject.product.model.Product;

public interface IProductService {

	Product insert(Product product);

	Product selectByID(int id);

	List<Product> selectAll();

	Product update(int id, String name);

	boolean delete(int id);

}