package inheritanceOverriding;

public class BaseKrediManager {
	public void krediVer() {
		String str = this.getClass().getSimpleName();
		System.out.println(str.substring(0, str.length()-7) +"si verildi");
	}
	
	// 	Daha sonra ezilmesini istemediðimiz metodlarý final keywordu ile iþaretliyoruz.
	//public final double krediGeriOdemesiHesapla(double krediTutar) {
	public double krediGeriOdemesiHesapla(double krediTutar) {
		String str = this.getClass().getSimpleName();
		System.out.println(str.substring(0, str.length()-12) +" Kredisi hesaplandý. >" + krediTutar + "< TL için:" );
		return krediTutar * 1.18;
	}
}