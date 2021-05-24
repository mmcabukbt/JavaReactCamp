package intro;

public class Main {

	public static void main(String[] args) {

		// De�er Tipler
		int sayi1 = 10;
		int sayi2 = 20;
		
		sayi1 = sayi2;
		sayi2 = 100;
		System.out.println(sayi1);
		
		// Referans Tipler
		int[] sayilar1 = {1,2,3,4,5};
		int[] sayilar2 = {10,20,30,40,50};
		
		sayilar1 = sayilar2;
		sayilar2[0] = 100;
		System.out.println(sayilar1[0]);
		
		// De�er tip davranana "String"ler de arka planda asl�nda Referans tiptir.
		String sehir1 = "Ankara";
		String sehir2 = "�stanbul";
		sehir1 = sehir2;
		sehir2 = "�zmir";
		System.out.println(sehir1);

		//****************************************
		
		double dolarYesterday = 8.20;
		double dolarToday = 8.30;

		if (dolarYesterday < dolarToday) {
			System.out.println("dolar y�kseldi");
		} else if (dolarYesterday > dolarToday) {
			System.out.println("dolar d��t�");
		} else {
			System.out.println("dolar de�i�medi");
		}

		// Lists
		String[] krediler = { "H�zl� Kredi", "Mutlu Emekli Kredisi", "Konut Kredisi", "�ift�i Kredisi", "MSB Kredisi",
				"K�lt�r Bakanl��� Kredisi" };

		// For-each Loop
		for (String kredi : krediler) {

			System.out.println(kredi);

		}

		System.out.println("----------------------");
		// For Loop
		for (int i = 0; i < krediler.length; i++) {
			System.out.println(krediler[i]);
		}
		
	}
}
