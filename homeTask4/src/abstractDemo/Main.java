package abstractDemo;

public class Main {

	public static void main(String[] args) {

		CustomerManager customerManager = new CustomerManager();

	// Kullan�ma Dikkat: vvvvvALTTAvvvvvvv <Abstracta >>> Injection yapma...
//		customerManager.baseDatabaseManager = new OracleDatabaseManager();
		customerManager.baseDatabaseManager = new SqlServerDatabaseManager();
//		customerManager.baseDatabaseManager = new MySqlDatabaseManager();

		customerManager.getCustomers();

	}
}