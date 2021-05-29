package abstractClasses;

public class Main {

	public static void main(String[] args) {

		WomanGameCalculator womanGameCalculator = new WomanGameCalculator();
		womanGameCalculator.hesapla();
		womanGameCalculator.gameOver();
		
		// Abstract classes; Boþ(abstract tanýmlý) ya da dolu, hem ikisinden ya da birinden istenen sayýda metod olabilir 
		// Abstract classes; Abstract metodlarýný alt sýnýflarýnda bulundurmaya ve ezmeye zorunlu kýlar.
		// Abstract classes; kendisi ASLA >> new << LENEMEZ !
		//GameCalculator gameCalculator = new GameCalculator(); // HATA !!
		
		//Abstract classes diðer tüm özellikleriyle normal class dýr ve referans tutucudurlar
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