package staticDemo;

public class DatabaseHelper {
	public static class Crud { //(inner class �rne�i)  CRUD -> Create, Read, Update, Delete
		public static void add() {
			System.out.println("static Crud class> Eklendi");
		}
		public static void delete() {
			System.out.println("static Crud class> Silindi");
		}
		public static void update() {
			System.out.println("static Crud class> G�ncellendi");
		}
	}
	public static class Connection { //(inner class �rne�i)  CRUD -> Create, Read, Update, Delete
		public static void createConnection() {
			System.out.println(" static Connection class> connection Sa�land�!");
		}
		public static void okuStream() {
			System.out.println(" static Connection class> Stream okundu");
		}
	}
}