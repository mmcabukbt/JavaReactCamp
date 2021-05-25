package oopIntro;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product(1, "Lenovo V14", 15000, "16 GB Ram",10); // Referans oluþturma, Intance

		/*product1.id = 1;
		product1.name = "Lenovo V14";
		product1.unitPrice = 15000;
		product1.detail = "16 GB Ram";*/
		
		Product product2 = new Product(); 
		product2.setId(2);
		product2.setName("Lenovo V15");
		product2.setUnitPrice(16000);
		product2.setDetail("32 GB Ram");
		product2.setDiscount(10);
		
		Product product3 = new Product(); 
		product3.setId(3);
		product3.setName("Acer Ideapad 5");
		product3.setUnitPrice(10000);
		product3.setDetail("8 GB Ram");
		product3.setDiscount(10);
		
		Product[] products = {product1, product2, product3}; 
		
		System.out.println("- Product List ____________");
		for (Product product : products) {
			
			System.out.println(product.getName() + "\t" +
					product.getDetail() + "\t" + product.getUnitPrice()+ "\t\t" +
					product.getUnitPriceAfterDiscount());		
		}
		
		System.out.println(products.length); // Dizi eleman sayýsý
		
		/*/ CATEGORY
		Category category1 = new Category();
		category1.id = 1;
		category1.name = "Bilgisayar";
		Category category2 = new Category();
		category2.id = 2;
		category2.name = "Ev/Bahçe";*/
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Bilgisayar");
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Ev / Bahçe");
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Spor-Hobi");
		
		Category[] categories = {category1, category2, category3}; 
		
		System.out.println("- Category List ____________");
		for (Category category : categories) {
			
			System.out.println(category.getId() + "\t" +
					category.getName());		
		}
		
		// PRODUCT MANAGER
		ProductManager productManager = new ProductManager();
		productManager.addToCart(product1);
		productManager.addToCart(product2);
		productManager.addToCart(product3);
	}
}