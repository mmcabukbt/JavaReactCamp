package kodlamaIo;

public class InstructorManager extends UserManager {
	@Override
	public void add(User user) {
		super.add(user);
		System.out.println("Kullanýcý Instructor tablosuna eklendi.");
	}
}