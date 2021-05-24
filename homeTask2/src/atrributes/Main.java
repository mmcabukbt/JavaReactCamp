package atrributes;

public class Main {

	public static void main(String[] args) {
		
		Product product1 = new Product(1,"Desktop", "Amd Ryzen", 4500, 12, "Siyah");
		
		Product product= new Product();
		product.setName("Laptop");
		product.setId(1);
		product.setDescription("Asus laptop");
		product.setPrice(5000);
		product.setStockAmount(8);
		
		System.out.println("-----------------------------");
		
		System.out.println(product.getKod() + "\t" + product.getName());
		System.out.println("-----------------------------");
		
		System.out.println(product1.getKod() + "\t" + product1.getName());
		
		ProductManager productManager = new ProductManager();
		productManager.add(product);
		
	}
}