package staticDemo;

public class ProductManager {
	public void add(Product product) {

	//ProductValidator tanýmladýðýmýzda new gerekmez. Ancak bellekte sürekli kalýr
	// Ve Direkt class ismi ile ÇAÐIRILIR
//		ProductValidator validator = new ProductValidator();
		if (ProductValidator.isValid(product)) {
			System.out.println("Veritabanýna eklendi");
		}else {
			System.out.println("Ürün bilgileri geçersiz");	
		}		
	}
}