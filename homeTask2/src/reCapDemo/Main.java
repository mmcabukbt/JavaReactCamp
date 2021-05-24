package reCapDemo;

public class Main {

	public static void main(String[] args) {
		
		DortIslem dortIslem = new DortIslem();

		System.out.println("Toplama sonucu: " + dortIslem.topla(15,25));
		System.out.println("Çýkarma sonucu: " + dortIslem.cikar(15,25));
		System.out.println("Çarpma sonucu: " + dortIslem.carp(15,25));
		System.out.println("Bölme sonucu: " + dortIslem.bol(15,25));
	}
}