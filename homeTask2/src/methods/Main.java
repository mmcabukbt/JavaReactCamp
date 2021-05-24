package methods;

public class Main {

	public static void main(String[] args) {
		// sayiBulmaca();

		
		//variable arguments
		int sonucCoklu = toplaCoklu(5, 9, 25, 36, 98, 43, 2, 2564);
		System.out.println("Çoklu Toplama Sonucu: " + toplaCoklu(sonucCoklu));
		
		//arguments
		int sonuc = topla(5, 9);

		System.out.println("Sonuç: " + sonuc);
		System.out.println("Þehir ver: "+ sehirVer());

	}
	
	//variable arguments
	public static int toplaCoklu(int... sayilar) {
		int sonuc = 0;
		for (int sayi : sayilar) {
			sonuc += sayi;
		}
		return sonuc;
	}

	public static int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}

	public static String sehirVer() {
		return "Ankara";
	}

	public static void sayiBulmaca() {
		int sayilar[] = new int[] { 1, 2, 6, 3, 9, 7, 0, 4 };
		int aranacak = 6;
		boolean varMi = false;

		for (int sayi : sayilar) {
			if (sayi == aranacak) {
				varMi = true;
				break;
			}
		}
		String mesaj = "";
		if (varMi) {
			mesaj = aranacak + " Sayýsý mevcuttur";
			ekranaYaz(mesaj);
		} else {
			ekranaYaz(aranacak + " Sayýsý mevcut DEÐÝLDÝR!");
		}

	}

	public static void ekranaYaz(String mesaj) {
		System.out.println(mesaj);
	}

}
