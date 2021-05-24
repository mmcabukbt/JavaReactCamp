package kodlamaIo;

public class CourseManagar {
	public void add(Course course) {
		System.out.println(course.name + " veritabanına eklendi");
	}
	public void update(Course course) {
		System.out.println(course.name + " veritabanında güncellendi");
	}
	public void delete(Course course) {
		System.out.println(course.name + " veritabanından silindi!");
	}
}
