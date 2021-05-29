package staticDemo;

public class Main {
	 //*************************************************\\
	// ProductValidator + DatabaseHelper classes incele! \\
//	\\---------------------------------------------------//
	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
		Product product = new Product();
		product.id = 1;
		product.name = "Mouse";
		product.price = 45;
		
		productManager.add(product);
		// static (metodu olan) s�n�f sadece new lenince constructoru �ALI�IR!
		ProductValidator denemeValidator = new ProductValidator();
		denemeValidator.testing();
		
		//inner class kullan�m �rne�i: ayn� class ta gruplanm�� farkl� g�revler;
		DatabaseHelper.Connection.createConnection();
		DatabaseHelper.Connection.okuStream();
		DatabaseHelper.Crud.add();
		DatabaseHelper.Crud.update();
		DatabaseHelper.Crud.delete();
		
		//********************************
		//Ancak inner classlar tavsiye edilmez. >Single Responsibility !!!

	}
}