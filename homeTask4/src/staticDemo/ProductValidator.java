package staticDemo;

public class ProductValidator {
  //^^^^^^^^^\\ Java da DIÞ(ana) class ASLA static olamaz; inner classlarý var ise onlar olabilir
	
	
	//static metodlarýn constructoru çaðýrmasý için;
	static {
		System.out.println(" >>>> static <<<< Yapýcý blok çalýþtý");
	}

	public ProductValidator() {
		System.out.println("Yapýcý blok çalýþtý");
	}

	public static boolean isValid(Product product) { // !!!static method
		// Bu method constructoru ÇALIÞTIRMAZ!
		if (product.price > 0 && !product.name.isEmpty()) {
			return true;
		}
		return false;
	}

	public void testing() { 						// normal method
		// Bu method constructoru ÇALIÞTIRIR!
	}
	
	public static class DenemeClass{			// <<<<<<< inner class -satic olabilir.
		public void bireyYap() {
			System.out.println("birsey yapýldý");			
		}
	}
}