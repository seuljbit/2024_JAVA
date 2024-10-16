package jdbcStudent;
/*  1) 학생 등록 | 2) 학생 리스트 | 3) 학생 검색(내 정보 보기)
	4) 학생 삭제 | 5) 학생 정보 수정 | 6) 학부/학과 검색 | 7) 종료 */
public class Student {
	private String student_id;
	private String student_name;
	private String student_phone_number;
	private String student_address;
	private String student_birth_date;
	private String student_admission_date;
	private String student_department;
	private String student_major;
	
	public Student() {}

	// 학생 등록, 정보 수정
	public Student(String student_id, String student_name, String student_phone_number, String student_address,
			String student_birth_date, String student_department, String student_major) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone_number = student_phone_number;
		this.student_address = student_address;
		this.student_birth_date = student_birth_date;
		this.student_department = student_department;
		this.student_major = student_major;
	}
	
	// 학생 검색 -> 전체
	public Student(String student_id, String student_name, String student_phone_number, String student_address,
			String student_birth_date, String student_admission_date, String student_department, String student_major) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone_number = student_phone_number;
		this.student_address = student_address;
		this.student_birth_date = student_birth_date;
		this.student_admission_date = student_admission_date;
		this.student_department = student_department;
		this.student_major = student_major;
	}

	// 학생 리스트 (학번, 이름, 학부, 학과)
	public Student(String student_id, String student_name, String student_department, String student_major) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_department = student_department;
		this.student_major = student_major;
	}
	
	// 학부 검색
	// 학과 검색

	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append(student_id).append(") ").append(student_name).append("[")
	          .append(student_department).append("/").append(student_major).append("]");

	    if (student_birth_date != null) {
	        result.append("\n생년월일 : ").append(student_birth_date);
	    }
	    if (student_address != null) {
	        result.append(" | 주소 : ").append(student_address);
	    }
	    if (student_phone_number != null) {
	        result.append("\n전화번호 : ").append(student_phone_number);
	    }
	    if (student_admission_date != null) {
	        result.append(" | 입학일 : ").append(student_admission_date);
	    }

	    return result.toString();
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_phone_number() {
		return student_phone_number;
	}

	public void setStudent_phone_number(String student_phone_number) {
		this.student_phone_number = student_phone_number;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_birth_date() {
		return student_birth_date;
	}

	public void setStudent_birth_date(String student_birth_date) {
		this.student_birth_date = student_birth_date;
	}

	public String getStudent_admission_date() {
		return student_admission_date;
	}

	public void setStudent_admission_date(String student_admission_date) {
		this.student_admission_date = student_admission_date;
	}

	public String getStudent_department() {
		return student_department;
	}

	public void setStudent_department(String student_department) {
		this.student_department = student_department;
	}

	public String getStudent_major() {
		return student_major;
	}

	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
}
