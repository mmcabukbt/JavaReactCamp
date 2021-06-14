package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	Result add(Product product);
	DataResult<Product> getById(int productId);
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAllPaged(int pageNo, int pageSize);
	
	DataResult<List<Product>> getByCategoryId(int categoryId);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories); 
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);//*////
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}