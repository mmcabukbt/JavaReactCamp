package kodlamaIo;

public class User {
	//base class
	private int id;
	private String nationalId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
/*	private String address1;
	private private String address2;
	private String county;
	private String city;
	private String country;
	private String mobile;	
	private byte[] profilImage;//*/
	
//*
	public User() {		
	}

	public User(int id, String nationalId, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.nationalId = nationalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	} //*/// Çabuk kapat/aç	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}