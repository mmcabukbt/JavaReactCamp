package kodlamaIo;

public class Main {

	public static void main(String[] args) {

		Category category1 = new Category(1, "Web Tasar�m");

		Category category2 = new Category();
		category2.id = 2;
		category2.name = "Programlama";

		Category category3 = new Category();
		category3.id = 3;
		category3.name = "RDBMS Tasar�m/Y�netim";

		Category category4 = new Category(4, "Machine Learning");

		Category[] categories = { category1, category2, category3, category4 };

		System.err.println("- Kurs kategorileri:__________");
		for (Category category : categories) {
			System.out.println(category.id + "\t" + category.name);
		}
//******************************
		Course course1 = new Course();
		course1.id = 1;
		course1.educatorId = 1; // Engin Demiro�
		course1.categoryId = 2; // Programlama
		course1.name = "Programlamaya Giri� ��in Temel Kurs";
		course1.content = "PYTHON, JAVA, C# gibi t�m programlama dilleri i�in temel programlama mant���n� anla��l�r �rneklerle ��renin.";
		course1.price = 0.0;

		Course course2 = new Course(2, 1, 2, "Yaz�l�m Geli�tirici Yeti�tirme Kamp�",
				"2 ay s�recek �cretsiz ve profesyonel bir programla, s�f�rdan yaz�l�m geli�tirme ��reniyoruz.", 0.0);

		Course course3 = new Course(3, 1, 2, "Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA & REACT)",
				"2 ay s�recek �cretsiz ve profesyonel bir programla, s�f�rdan yaz�l�m geli�tirme ��reniyoruz.", 0.0);

		Course[] courses = { course1, course2, course3 };

		System.err.println("\n- Kurs Listesi:_____________");
		for (Course course : courses) {
			System.out.println(course.id + "\t" + course.name + "\t" + course.content + "\t"
					+ ((course.price == 0) ? "�cretsiz" : course.price));
		}

	}

}
