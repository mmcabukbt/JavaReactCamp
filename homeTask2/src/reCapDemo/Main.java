package reCapDemo;

public class Main {

	public static void main(String[] args) {
		
		DortIslem dortIslem = new DortIslem();

		System.out.println("Toplama sonucu: " + dortIslem.topla(15,25));
		System.out.println("��karma sonucu: " + dortIslem.cikar(15,25));
		System.out.println("�arpma sonucu: " + dortIslem.carp(15,25));
		System.out.println("B�lme sonucu: " + dortIslem.bol(15,25));
	}
}