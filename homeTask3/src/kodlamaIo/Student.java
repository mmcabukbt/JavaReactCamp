package kodlamaIo;

public class Student extends User {
	private int id;
	private int userId;
	
	public Student() {
		super();
	}

	//Diyelim ki Studente Parametreli Consutructor için izin vermek istemiyoruz.
	//Artýk sadece getter ve setter kullanabilir
/*	public Student(int id, int userId) {
		super();
		this.id = id;
		this.userId = userId;
	} //*///

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}