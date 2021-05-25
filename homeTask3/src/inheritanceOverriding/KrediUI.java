package inheritanceOverriding;

public class KrediUI {
	public void krediHesaplaButton(BaseKrediManager baseKrediManager, double krediTutar) {
		System.out.println(baseKrediManager.krediGeriOdemesiHesapla(krediTutar));
	}
}