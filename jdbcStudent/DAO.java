package jdbcStudent;

import java.util.List;

public interface DAO {

	int insert(Student stu);

	List<Student> selectList();

	Student search(String id);

	int delete(String student_id);

	int update(Student stu);

	List<Student> majorSearch(String major);
}
