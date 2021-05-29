package kodlamaIo;

public class Main {

	public static void main(String[] args) {

		Instructor instructor = new Instructor(1, 1, new int[]{3,2,5});
		Student student = new Student();
		student.setId(122);
		student.setUserId(5565);
		
		//Base UserManager kullan�larak
		UserManager userManager = new UserManager();
		userManager.add(instructor);
		userManager.add(student);

		//Ezilmi� (Override) add methoduna sahip InstructorManager kullanarak yapal�m
		System.out.println("------------------------");
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);
	}
}