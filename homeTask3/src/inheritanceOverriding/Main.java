package inheritanceOverriding;

public class Main {

	public static void main(String[] args) {
		OgretmenKrediManager ogretmenKrediManager = new OgretmenKrediManager();
		//ogretmenKrediManager.krediHesapla();
		
		KrediUI krediUI = new KrediUI();
		krediUI.krediHesaplaButton(ogretmenKrediManager, 1000);
		krediUI.krediHesaplaButton(new TarimKrediManager(), 2000);
		krediUI.krediHesaplaButton(new AskerKrediManager(), 1500);
		
		System.out.println("--------------------------------------- ");
		BaseKrediManager[] baseKrediManagers = new BaseKrediManager[]
				{new OgretmenKrediManager(), new TarimKrediManager(),
				new AskerKrediManager(), new OgrenciKrediManager() };
		
		for (BaseKrediManager baseKrediManager : baseKrediManagers) {
			System.out.println(baseKrediManager.krediGeriOdemesiHesapla(1000));
		}
		
		System.out.println("- YA DA UI kullanılarak -------------- ");
		for (BaseKrediManager baseKrediManager : baseKrediManagers) {
			krediUI.krediHesaplaButton(baseKrediManager, 1000);
		}	
	}
}