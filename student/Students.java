package student;

public class Students {
	/* Student class : 학생 정보
	  - 학번, 이름, 나이, 전화번호, 주소, 수강과목 (Subject class를 배열로 처리)
	  - 멤버변수 / 생성자 / getter/setter / toString
	  - 수강신청 / 수강철회 / 수강과목 출력 */

	private String name;
	private int age;
	private String stuNum;
	private String phoneNumber;
	private String address;
	private Subjects[] subjects = new Subjects[5]; 
	private int subCnt = 0; 
	
	public Students() {}
	
	public Students(String name, int age, String stuNum,String phoneNumber, String address) {
		this.name = name;
		this.age = age;
		this.stuNum = stuNum;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(stuNum).append(" ").append(name).append("(").append(age).append("세)").append(" / ")
	      .append(phoneNumber).append(", ").append(address).append("\n");

	    sb.append("수강 과목 목록 : ");
	    if (subCnt == 0) {
	        sb.append("수강 중인 과목이 없습니다.");
	    } else {
	        for (int i=0; i<subCnt; i++) {
	            sb.append("\n").append(i + 1).append(". ").append(subjects[i].toString());
	        }
	    }

	    return sb.toString();
	}
	
	public void addSubject(Subjects subject) {
		if (subCnt < subjects.length) {
			subjects[subCnt] = subject;
			subCnt++;
			System.out.println("<" + subject.getSubName() + "> 과목이 등록되었습니다.");
		} else {
			System.out.println("더 이상 수강 신청을 할 수 없습니다.");
		}
	}

	public void decSubCnt() {
		if (subCnt > 0) { subCnt--; }
	}

	public void printStudentInfo() {
		System.out.println(this.toString());
		System.out.println("수강 과목 목록 :");
		for (int i = 0; i < subCnt; i++) {
			System.out.println(subjects[i]);
		}
	}
	
	public void printSubjects() {
	    if (getSubCnt() == 0) {
	        System.out.println("수강 중인 과목이 없습니다.");
	        return;
	    }
	    for (int i = 0; i < getSubCnt(); i++) {
	        System.out.println((i + 1) + ". " + subjects[i].getSubName() + "(" + subjects[i].getSubCode() + ", " + subjects[i].getProfName() + ")");
	    }
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Subjects[] getSubjects() {
		return subjects;
	}
	public void setSubjects(Subjects[] subjects) {
		this.subjects = subjects;
	}
	public int getSubCnt() {
		return subCnt;
	}
	public void setSubCnt(int subCnt) {
		this.subCnt = subCnt;
	}
}