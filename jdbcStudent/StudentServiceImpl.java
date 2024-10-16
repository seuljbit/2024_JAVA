package jdbcStudent;

import java.util.List;

public class StudentServiceImpl implements Service {
	
	private DAO dao;
	
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}

	@Override
	public int insert(Student stu) {
		System.out.println("학생 등록(ServiceImpl) 성공!");
		return dao.insert(stu);
	}

	@Override
	public List<Student> getList() {
		System.out.println("학생 리스트 출력(ServiceImpl) 성공!");
		return dao.selectList();
	}

	@Override
	public Student search(String id) {
		System.out.println("학생 검색(ServiceImpl) 성공!");
		return dao.search(id);
	}

	@Override
	public int delete(String student_id) {
		return dao.delete(student_id);
	}

	@Override
	public int update(Student stu) {
		System.out.println("학생 정보 수정(ServiceImpl) 성공!");
		return dao.update(stu);
	}

	@Override
	public List<Student> majorSearch(String major) {
	    System.out.println("학부/학과 조회(ServiceImpl) 성공!");
	    return dao.majorSearch(major);  // DAO의 majorSearch 메서드를 호출
	}
}
