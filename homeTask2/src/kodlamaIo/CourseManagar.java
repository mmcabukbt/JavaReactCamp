package kodlamaIo;

public class CourseManagar {
	public void add(Course course) {
		System.out.println(course.name + " veritaban�na eklendi");
	}
	public void update(Course course) {
		System.out.println(course.name + " veritaban�nda g�ncellendi");
	}
	public void delete(Course course) {
		System.out.println(course.name + " veritaban�ndan silindi!");
	}
}
