package methodOverloading;

public class DortIslem {

	public int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
	public int topla(int sayi1, int sayi2, int sayi3) {
		return sayi1 + sayi2 + sayi3;
	}
	public int topla(int... sayilar) { //Çoklu toplama için Override
		int sonuc = 0;
		for (int sayi : sayilar) {
			sonuc += sayi;
		}
		return sonuc;

	}
}