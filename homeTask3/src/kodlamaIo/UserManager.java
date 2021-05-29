package kodlamaIo;

public class UserManager {
	public void getAllUsers() {
		System.out.println("Tüm kullanýcýlar listelendi.");
	}

	public void add(User user) {
		System.out.println(user.getId() + " Id Nolu User eklendi.");
	}

	public void update(User user) {
		System.out.println(user.getId() + " Id Nolu User güncellendi.");
	}

	public void delete(User user) {
		System.out.println(user.getId() + " Id Nolu User silindi!");
	}
}