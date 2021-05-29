package newestGamersCo.Entities;

public class Gamer extends User {
	private int id;
	private int userId;
	private String nationalId;
	private String firstName;
	private String lastName;
	private int yearOfBirth; 
	
	public Gamer() {		
	}
	
	public Gamer(String nationalId, String firstName, String lastName, int yearOfBirth, String password, String email) {
		super(password, email);
		this.nationalId = nationalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}

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

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	public String getPassword() {
		return super.password;
	}

	public void setPassword(String password) {
		super.password = password;
	}

	public String getEmail() {
		return super.email;
	}

	public void setEmail(String email) {
		super.email = email;
	}
}