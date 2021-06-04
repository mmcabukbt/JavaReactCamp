package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
//	 	@Query("select p from Product p where p.categoryId = ?1") 
// Query e Gerek yok! spring Supperted Keyword leri ile (direkt fonksiyon isminden) hallettik:
// find......By +  ProductName >>> findByProductName  gibi
	List<Product> findByCategoryId (int id);	

}