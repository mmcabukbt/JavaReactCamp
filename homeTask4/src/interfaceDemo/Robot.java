package interfaceDemo;

public class Robot implements IWorkable, IMaintainable {

	@Override
	public void work() {
		System.out.println("Bizim Personel: Çalýþma Saati: 09:00 ~ 17:00");
	}

	@Override
	public void maintain() {
		System.out.println("Bizim personel: Bakým masrafý karþýlanýyor");
	}
}