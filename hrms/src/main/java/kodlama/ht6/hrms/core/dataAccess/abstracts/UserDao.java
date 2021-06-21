package kodlama.ht6.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	User getByEmail(String email);
	User getByid(Long id);
/*	
	@Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.category.categoryId = :categoryId")
	List<Product> getByNameAndCategory(@Param("productName") String productName, @Param("categoryId") int categoryId); 
	
	//Select p.productId, p.productName, c.categoryName from Category c inner join Product p on c.categoryId = p.categoryId > Eşdeğeri
	@Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails(); //*////

	//@Query("SELECT new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	//List<String> getWithClaims();
}