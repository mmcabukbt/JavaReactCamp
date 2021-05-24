package mukemmelSayi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Bir tamsayý girin: ");
		int sayi1 = in.nextInt();
		in.close(); // closing scanner
		for (int i = 2; i < sayi1; i++) {
			if (mukemmelSayimi(i)) {
				System.out.println("--------------------------------");
				System.out.println(i + " sayýsý MÜKEMMEL!: ");
			}
		}
	}

	private static boolean mukemmelSayimi(int sayi) {
		int toplam = 1;
		for (int i = 2; i < sayi; i++) {
			if (sayi % i == 0) {
				toplam += i;
			}
		}
		if (toplam == sayi) {
			return true;
		}
		return false;
	}
}