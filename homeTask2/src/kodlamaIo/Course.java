package kodlamaIo;

public class Course {
	int id;
	int categoryId;
	int educatorId;
	String name;
	String content;
	double price;
	
	public Course() {
	};
	
	public Course(int id, int categoryId, int educatorId, String name, String content, double price) {
		this.id = id;
		this.categoryId = categoryId;
		this.educatorId = educatorId;
		this.name = name;
		this.content = content;
		this.price = price;
	}
}