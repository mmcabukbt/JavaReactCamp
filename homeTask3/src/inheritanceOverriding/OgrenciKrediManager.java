package inheritanceOverriding;

public class OgrenciKrediManager extends BaseKrediManager{
	//BaseKrediManager in methodunu OVERRIDE ettik.
	@Override
	public double krediGeriOdemesiHesapla(double krediTutar) {
		String str = this.getClass().getSimpleName();
		System.out.println(str.substring(0, str.length()-12) +" Kredisi hesaplandý. >" + krediTutar + "< TL için:" );
		return krediTutar * 1.10;
	}
}
