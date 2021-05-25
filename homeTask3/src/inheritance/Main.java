package inheritance;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer();
		Employee employee = new Employee();
		customer.firstName = "Mehmet";
		employee.firstName = "Mehmet";
		
		EmployeeManager employeeManager = new EmployeeManager();
		CustomerManager customerManager = new CustomerManager();
		
		customerManager.add();
		
		employeeManager.add();
		employeeManager.bestEmployee();
	}
}