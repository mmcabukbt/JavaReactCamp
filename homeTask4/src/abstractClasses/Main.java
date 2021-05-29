package abstractClasses;

public class Main {

	public static void main(String[] args) {

		WomanGameCalculator womanGameCalculator = new WomanGameCalculator();
		womanGameCalculator.hesapla();
		womanGameCalculator.gameOver();
		
		// Abstract classes; Bo�(abstract tan�ml�) ya da dolu, hem ikisinden ya da birinden istenen say�da metod olabilir 
		// Abstract classes; Abstract metodlar�n� alt s�n�flar�nda bulundurmaya ve ezmeye zorunlu k�lar.
		// Abstract classes; kendisi ASLA >> new << LENEMEZ !
		//GameCalculator gameCalculator = new GameCalculator(); // HATA !!
		
		//Abstract classes di�er t�m �zellikleriyle normal class d�r ve referans tutucudurlar
		GameCalculator wGameCalculator = new WomanGameCalculator();
		GameCalculator mGameCalculator = new ManGameCalculator();
		GameCalculator kGameCalculator = new KidGameCalculator();
		wGameCalculator.hesapla();
		wGameCalculator.gameOver();
		
		mGameCalculator.hesapla();
		mGameCalculator.gameOver();
		
		kGameCalculator.hesapla();
		kGameCalculator.gameOver();		
	}
}