package interfaceDemo;

public class Worker implements IWorkable, IEatable, IPayable {

	@Override
	public void work() {
		System.out.println("Bizim Personel: �al��ma Saati: 09:00 ~ 17:00");
	}

	@Override
	public void eat() {
		System.out.println("Bizim personel: Yemek kar��lan�yor");
	}

	@Override
	public void pay() {
		System.out.println("Bizim personel: Maa� kar��lan�yor");
	}
}