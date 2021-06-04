package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	
	Result add(Product product);
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getByCategoryId(int id);

}