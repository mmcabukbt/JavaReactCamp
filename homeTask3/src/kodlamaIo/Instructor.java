package kodlamaIo;

public class Instructor extends User {
	private int id;
	private int userId;
	private int[] teachingBrancheIds;
//	private String aboutContent;
	
	public Instructor() {
		super(); //Useri çaðýr
	}
//*	//Diyelim ki Instructor classýnýn Parametreli Constructorýna izin vermek istiyoruz. 
	public Instructor(int id, int userId, int[] teachingBrancheIds) {
		super();
		this.id = id;
		this.userId = userId;
		this.teachingBrancheIds = teachingBrancheIds;
	}//*/
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
	public int[] getTeachingBrancheIds() {
		return teachingBrancheIds;
	}
	public void setTeachingBrancheIds(int[] teachingBrancheIds) {
		this.teachingBrancheIds = teachingBrancheIds;
	}
}