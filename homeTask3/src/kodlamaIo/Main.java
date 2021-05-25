package kodlamaIo;

public class Main {

	public static void main(String[] args) {

		Instructor instructor = new Instructor(1, 1, new int[]{3,2,5},"125456","Engin", "Demiroğ","engin@demirog.com","1111111");
		Student student = new Student();
		student.setId(122);
		student.setFirstName("Mehmet");
		student.setLastName("Çabuk");
		student.setNationalId("1010100");
		student.setEmail("mehmet@cabuk.com");
		student.setPassword("22222");
		student.setStudentId(22);
		
		//Base UserManager kullanılarak
		UserManager userManager = new UserManager();
		userManager.add(instructor);
		userManager.add(student);

		//Ezilmiş (Override) add methoduna sahip InstructorManager kullanarak yapalım
		System.out.println("------------------------");
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);
	}
}