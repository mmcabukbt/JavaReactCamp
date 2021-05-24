package methodOverloading;

public class Main {

	public static void main(String[] args) {

		DortIslem dortIslem = new DortIslem();
		System.out.println(dortIslem.topla(2, 5));
		
		System.out.println(dortIslem.topla(2, 5,6));
		
		System.out.println(dortIslem.topla(2, 5,6,35,8775,84456,486468,865468,45));
	}
}