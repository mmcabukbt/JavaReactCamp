package kodlamaIo;

public class Student extends User {
	private int studentId;
	
	public Student() {
		super();
	}
	//Diyelim ki Studente Parametreli Consutructor i�in izin vermek istemiyoruz.
	//Art�k sadece getter ve setter kullanabilir
/*	public Student(int studentId, int id, String nationalId, String firstName, String lastName, String email, String password) {
		super(id, nationalId, firstName, lastName, email, password);
		this.studentId = studentId; 
	} //*///

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}