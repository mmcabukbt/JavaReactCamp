package abstractClasses;

public abstract class GameCalculator {
	
	public abstract void hesapla(); 
	//abstract olarak tan�mlay�p sadece imzas�n� yaz�yor ve extends edecek classlar�n 
	//bu metodu ezmesini zorunlu k�l�yoruz
//	{	System.out.println("Hesaplama yap�ld�:> Puan�n�z : 100"); }
	
	public void gameOver() {
		System.out.println("Oyun bitti!");		
	}
}