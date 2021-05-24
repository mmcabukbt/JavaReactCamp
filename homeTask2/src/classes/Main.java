package classes;

public class Main {

	public static void main(String[] args) {

		// class lar referans tiptir.
		CustomerManager customerManager = new CustomerManager();
		customerManager.add();
		customerManager.remove();
		customerManager.update();

		// değer-referans tipleri anlamak!
		// değer tiplerde
		int sayi1 = 10;
		int sayi2 = 20;
		sayi1 = sayi2;
		sayi2 = 30;
		// sayi1 kaçtır?
		System.out.println("sayi1: " + sayi1);

		// referans tiplerde
		int sayilar1[] = new int[] { 1, 2, 3, 5 };
		int sayilar2[] = new int[] { 4, 6, 7, 8, 9 };
		sayilar1 = sayilar2;
		sayilar2[0] = 30;
		// sayilar1[0] kaçtır?
		System.out.println("sayilar1[0]: " + sayilar1[0]);
	}
}