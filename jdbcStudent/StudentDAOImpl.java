package jdbcStudent;

import java.sql.*;
import java.util.*;

import jdbc.DatabaseConnection;

public class StudentDAOImpl implements DAO {
	
	private Connection conn; // DB 연결 객체
	private PreparedStatement pst; // SQL 구문을 실행시키는 기능을 가진 객체
	private String query = ""; // 쿼리문 저장 스트링
	
	public StudentDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int insert(Student stu) {
		System.out.println("insert DAOImpl 성공!");
		
		query = "insert into student("
				+ "student_id, student_name, student_phone_number, student_address,"
				+ "student_birth_date, student_department, student_major)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, stu.getStudent_id());
			pst.setString(2, stu.getStudent_name());
			pst.setString(3, stu.getStudent_phone_number());
			pst.setString(4, stu.getStudent_address());
			pst.setString(5, stu.getStudent_birth_date());
			pst.setString(6, stu.getStudent_department());
			pst.setString(7, stu.getStudent_major());
			
			return pst.executeUpdate();
		} catch (SQLException e) {// insert error
			System.out.println("insert error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> selectList() {
	    List<Student> students = new ArrayList<>();
	    query = "select student_id, student_name, student_department, student_major from student";
	    
	    try {
	        pst = conn.prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            String student_id = rs.getString("student_id");
	            String student_name = rs.getString("student_name");
	            String student_department = rs.getString("student_department");
	            String student_major = rs.getString("student_major");
	            
	            students.add(new Student
	            		(student_id, student_name, student_department, student_major));
	        }
	        return students;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public Student search(String student_id) {
		System.out.println("학생 검색(DAOImpl) 성공!");
	    query = "select * from student where student_id = ?";
	    
	    try {
	        pst = conn.prepareStatement(query);
	        pst.setString(1, student_id);  // 입력받은 학번을 쿼리로 설정
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	        	Student stu = new Student(
	        		    rs.getString("student_id"),
	        		    rs.getString("student_name"),
	        		    rs.getString("student_phone_number"),
	        		    rs.getString("student_address"),
	        		    rs.getString("student_birth_date"),
	        		    rs.getString("student_admission_date"),
	        		    rs.getString("student_department"),
	        		    rs.getString("student_major")
	        		);
	        return stu;
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public int delete(String student_id) {
		System.out.println("학생 정보 삭제(DAOImpl) 성공!");
	    query = "delete from student where student_id = ?";
	    
	    try {
			pst = conn.prepareStatement(query);
			pst.setString(1, student_id);
			
			return pst.executeUpdate();
		} catch (SQLException e) {
	        System.out.println("delete error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Student stu) {
		System.out.println("학생 정보 수정(DAOImpl) 성공!");
		query = "update student set student_name = ?, "
				+ "student_phone_number = ?, student_address = ?, "
				+ "student_birth_date = ?, student_department =?, student_major = ?"
				+ "where student_id = ?";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, stu.getStudent_name());
			pst.setString(2, stu.getStudent_phone_number());
			pst.setString(3, stu.getStudent_address());
			pst.setString(4, stu.getStudent_birth_date());
			pst.setString(5, stu.getStudent_department());
			pst.setString(6, stu.getStudent_major());
			pst.setString(7, stu.getStudent_id());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> majorSearch(String major) {
	    System.out.println("학부/학과 검색(DAOImpl) 성공!");
	    List<Student> stu = new ArrayList<>();
	    query = "SELECT student_id, student_name, student_department, student_major "
	            + "FROM student WHERE student_department = ? OR student_major = ?";  // 학부 또는 학과 검색
	    
	    try {
	        pst = conn.prepareStatement(query);
	        pst.setString(1, major);  // 학부/학과 검색용 입력 값
	        pst.setString(2, major);  // 학과도 동일한 값으로 검색
	        ResultSet rs = pst.executeQuery();
	        
	        while (rs.next()) {
	            String student_id = rs.getString("student_id");
	            String student_name = rs.getString("student_name");
	            String student_department = rs.getString("student_department");
	            String student_major = rs.getString("student_major");
	            
	            stu.add(new Student(student_id, student_name, student_department, student_major));
	        }
	        return stu;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
