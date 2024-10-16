package jdbcStudent;

import java.util.List;

public interface Service {

	int insert(Student stu);

	List<Student> getList();

	Student search(String student_id);

	int delete(String student_id);

	int update(Student stu);

	List<Student> majorSearch(String major);
}
