package kodlamaIo;

public class Main {

	public static void main(String[] args) {

		Category category1 = new Category(1, "Web Tasarým");

		Category category2 = new Category();
		category2.id = 2;
		category2.name = "Programlama";

		Category category3 = new Category();
		category3.id = 3;
		category3.name = "RDBMS Tasarým/Yönetim";

		Category category4 = new Category(4, "Machine Learning");

		Category[] categories = { category1, category2, category3, category4 };

		System.err.println("- Kurs kategorileri:__________");
		for (Category category : categories) {
			System.out.println(category.id + "\t" + category.name);
		}
//******************************
		Course course1 = new Course();
		course1.id = 1;
		course1.educatorId = 1; // Engin Demiroð
		course1.categoryId = 2; // Programlama
		course1.name = "Programlamaya Giriþ Ýçin Temel Kurs";
		course1.content = "PYTHON, JAVA, C# gibi tüm programlama dilleri için temel programlama mantýðýný anlaþýlýr örneklerle öðrenin.";
		course1.price = 0.0;

		Course course2 = new Course(2, 1, 2, "Yazýlým Geliþtirici Yetiþtirme Kampý",
				"2 ay sürecek ücretsiz ve profesyonel bir programla, sýfýrdan yazýlým geliþtirme öðreniyoruz.", 0.0);

		Course course3 = new Course(3, 1, 2, "Yazýlým Geliþtirici Yetiþtirme Kampý (JAVA & REACT)",
				"2 ay sürecek ücretsiz ve profesyonel bir programla, sýfýrdan yazýlým geliþtirme öðreniyoruz.", 0.0);

		Course[] courses = { course1, course2, course3 };

		System.err.println("\n- Kurs Listesi:_____________");
		for (Course course : courses) {
			System.out.println(course.id + "\t" + course.name + "\t" + course.content + "\t"
					+ ((course.price == 0) ? "Ücretsiz" : course.price));
		}

	}

}
