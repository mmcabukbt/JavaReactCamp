package kodlamaIo;

public class UserManager {
	public void getAllUsers() {
		System.out.println("T�m kullan�c�lar listelendi.");
	}

	public void add(User user) {
		System.out.println(user.getId() + " Id Nolu User eklendi.");
	}

	public void update(User user) {
		System.out.println(user.getId() + " Id Nolu User g�ncellendi.");
	}

	public void delete(User user) {
		System.out.println(user.getId() + " Id Nolu User silindi!");
	}
}