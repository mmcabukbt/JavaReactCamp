package staticDemo;

public class ProductManager {
	public void add(Product product) {

	//ProductValidator tan�mlad���m�zda new gerekmez. Ancak bellekte s�rekli kal�r
	// Ve Direkt class ismi ile �A�IRILIR
//		ProductValidator validator = new ProductValidator();
		if (ProductValidator.isValid(product)) {
			System.out.println("Veritaban�na eklendi");
		}else {
			System.out.println("�r�n bilgileri ge�ersiz");	
		}		
	}
}