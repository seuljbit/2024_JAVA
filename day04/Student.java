package day04;

public class Student {
	/* 학생 정보를 관리하기 위한 클래스
	  - 학생 기본 정보 : 이름, 생년월일, 전화번호, 나이
	  - 학원 정보 : 학원명 = "EZEN" (final static), 지점
	  - 수강 정보 : 수강과목, 기간(배열로 구성)
	   => 여러 과목을 들을 수 있음(여러 과목을 수강하기 위해서는 배열로 처리, 5과목까지 가능)
	   
	  ex) 홍길동(010101) 010-1111-2222 /25 -> 학생정보
	  	  EZEN(인천) -> 학원 정보
	  	  java 6개월, 파이썬 1개월, SQLD 1개월 -> 수강정보
	  	  
	 * 메서드(기능)
	  - 학생의 기본 정보를 출력하는 기능
	  - 학원 정보를 출력하는 기능
	  - 수강 정보를 출력하는 기능
	  - 학생이 수강정보를 추가하는 기능 */
	
    private String name;
    private String birth;
	private String phoneNumber;
    private int age;

	public static final String academyName = "EZEN";
    private String branch;

    private String subjects[] = new String[5];
    private String durations[] = new String[5];
    private int subjectCount = 0;  

    public Student(String name, String birth, String phoneNumber, int age, String branch) {
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.branch = branch;
    }

    // 학생의 기본 정보 출력
    public void printStudentInfo() {
        System.out.println(name + "(" + birth + ") " + phoneNumber + " / " + age + "세");
    }

    // 학원 정보를 출력하는 기능
    public void printAcademyInfo() {
        System.out.println(academyName + "(" + branch + ")");
    }

    // 수강 정보를 출력하는 기능
    public void printSubjects() {
        System.out.println("수강 정보:");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println((i+1) + ". " + subjects[i] + " " + durations[i]);
        }
    }

    // 학생이 수강정보를 추가하는 기능
    public void addSubject(String subject, String duration) {
        if (subjectCount < 5) {
            subjects[subjectCount] = subject;
            durations[subjectCount] = duration;
            subjectCount++;
        } else {
            System.out.println("더이상 과목을 추가할 수 없습니다.");
        }
    }
    
    public boolean booleanSubject(String subject) {
        for (String sub : subjects) {
            if (subject.equals(sub)) {
                return true;
            }
        }
		return false;
    }
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public String[] getDurations() {
		return durations;
	}

	public void setDurations(String[] durations) {
		this.durations = durations;
	}

    public int getSubjectCount() {
		return subjectCount;
	}

	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}
}
