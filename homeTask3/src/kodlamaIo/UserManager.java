package kodlamaIo;

public class UserManager {
	public void getAllUsers() {
		System.out.println("T�m kullan�c�lar listelendi.");
	}

	public void add(User user) {
		System.out.println(user.getFirstName() +" "+ user.getLastName() + " eklendi.");
	}

	public void update(User user) {
		System.out.println(user.getFirstName() +" "+ user.getLastName() + " g�ncellendi.");
	}

	public void delete(User user) {
		System.out.println(user.getFirstName() +" "+ user.getLastName() + " silindi!");
	}

}
