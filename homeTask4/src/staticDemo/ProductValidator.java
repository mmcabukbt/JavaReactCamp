package staticDemo;

public class ProductValidator {
  //^^^^^^^^^\\ Java da DI�(ana) class ASLA static olamaz; inner classlar� var ise onlar olabilir
	
	
	//static metodlar�n constructoru �a��rmas� i�in;
	static {
		System.out.println(" >>>> static <<<< Yap�c� blok �al��t�");
	}

	public ProductValidator() {
		System.out.println("Yap�c� blok �al��t�");
	}

	public static boolean isValid(Product product) { // !!!static method
		// Bu method constructoru �ALI�TIRMAZ!
		if (product.price > 0 && !product.name.isEmpty()) {
			return true;
		}
		return false;
	}

	public void testing() { 						// normal method
		// Bu method constructoru �ALI�TIRIR!
	}
	
	public static class DenemeClass{			// <<<<<<< inner class -satic olabilir.
		public void bireyYap() {
			System.out.println("birsey yap�ld�");			
		}
	}
}