package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
 	List<Product> findByCategory_CategoryId(int categoryId);
	
 	Product getByid(int categoryId);
 	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	 
	List<Product> getByProductNameStartsWith(String productName);

	//select * from products where productName = birşey and categoryId = birşey > EŞDEĞERİ SORGU
	@Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.category.categoryId = :categoryId")
	List<Product> getByNameAndCategory(@Param("productName") String productName, @Param("categoryId") int categoryId); //*///
	
	//Select p.productId, p.productName, c.categoryName from Category c inner join Product p on c.categoryId = p.categoryId > Eşdeğeri
	@Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}