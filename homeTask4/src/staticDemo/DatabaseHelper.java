package staticDemo;

public class DatabaseHelper {
	public static class Crud { //(inner class örneği)  CRUD -> Create, Read, Update, Delete
		public static void add() {
			System.out.println("static Crud class> Eklendi");
		}
		public static void delete() {
			System.out.println("static Crud class> Silindi");
		}
		public static void update() {
			System.out.println("static Crud class> Güncellendi");
		}
	}
	public static class Connection { //(inner class örneği)  CRUD -> Create, Read, Update, Delete
		public static void createConnection() {
			System.out.println(" static Connection class> connection Sağlandı!");
		}
		public static void okuStream() {
			System.out.println(" static Connection class> Stream okundu");
		}
	}
}