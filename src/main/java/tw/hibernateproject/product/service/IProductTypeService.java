package tw.hibernateproject.product.service;

import java.util.List;
import tw.hibernateproject.product.model.ProductType;

public interface IProductTypeService {

	ProductType insert(ProductType productType);

	ProductType selectByID(int id);

	List<ProductType> selectAll();

	ProductType update(int id, String name);

	boolean delete(int id);

}