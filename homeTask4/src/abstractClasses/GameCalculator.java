package abstractClasses;

public abstract class GameCalculator {
	
	public abstract void hesapla(); 
	//abstract olarak tanýmlayýp sadece imzasýný yazýyor ve extends edecek classlarýn 
	//bu metodu ezmesini zorunlu kýlýyoruz
//	{	System.out.println("Hesaplama yapýldý:> Puanýnýz : 100"); }
	
	public void gameOver() {
		System.out.println("Oyun bitti!");		
	}
}