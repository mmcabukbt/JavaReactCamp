package inheritanceOverriding;

public class BaseKrediManager {
	public void krediVer() {
		String str = this.getClass().getSimpleName();
		System.out.println(str.substring(0, str.length()-7) +"si verildi");
	}
	
	// 	Daha sonra ezilmesini istemedi�imiz metodlar� final keywordu ile i�aretliyoruz.
	//public final double krediGeriOdemesiHesapla(double krediTutar) {
	public double krediGeriOdemesiHesapla(double krediTutar) {
		String str = this.getClass().getSimpleName();
		System.out.println(str.substring(0, str.length()-12) +" Kredisi hesapland�. >" + krediTutar + "< TL i�in:" );
		return krediTutar * 1.18;
	}
}