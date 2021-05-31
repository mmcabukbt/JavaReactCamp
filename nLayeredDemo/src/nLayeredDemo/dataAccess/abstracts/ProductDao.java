package nLayeredDemo.dataAccess.abstracts;

import java.util.List;

import nLayeredDemo.entities.concretes.Product;

public interface ProductDao {

	void add(Product produc);

	void update(Product produc);

	void delete(Product produc);

	Product get(int id);

	List<Product> getAll();
}