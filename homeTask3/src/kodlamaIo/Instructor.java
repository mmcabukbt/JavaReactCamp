package kodlamaIo;

public class Instructor extends User {
	private int instructorId;
	private int[] teachingBrancheIds;
//	private String aboutContent;
	
//*
	public Instructor() {
		super(); //Useri çaðýr
	}
	//Diyelim ki Instructor classýnýn Parametreli Constructorýna izin vermek istiyoruz. 
	public Instructor(int id, int instructorId, int[] teachingBrancheIds, String nationalId, String firstName, String lastName, String email, String password) {
		super(id, nationalId, firstName, lastName, email, password);
		this.instructorId = instructorId;
		this.teachingBrancheIds = teachingBrancheIds;
	}//*/
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public int[] getTeachingBrancheIds() {
		return teachingBrancheIds;
	}
	public void setTeachingBrancheIds(int[] teachingBrancheIds) {
		this.teachingBrancheIds = teachingBrancheIds;
	}
}