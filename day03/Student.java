package day03;

public class Student {
    /* 학생 클래스 생성
     * 멤버변수 : 지점, 이름, 과정, 전화번호
     * 생성자 :
      - 지점과 이름만 받는 생성자
      - 지점, 이름, 과정, 전화번호를 받는 생성자 (생성자 호출로 호출)
     * 메서드 : 해당 내용을 출력하는 메서드(print()), getter / setter
      
     * 객체 생성 시 값을 초기화하는 방법
      - 기본값, 명시적 초기값
      
      1. 기본값 : 기본으로 지정되는 값 int =0 / String = null
      2. 명시적 초기값 : 사용자가 멤버변수를 선언함과 동시에 값을 지정
      3. 초기화 블럭 : { } 멤버변수들의 초기화
      4. 생성자 : 객체 생성 시 초기화해서 생성
      
      - 초기값의 우선순위(순위가 높은 값으로 덮어쓰여짐)
      1. 기본값 -> 명시적 초기값 -> 초기화블럭 -> 생성자(가장 우선순위가 높음)
      2. */

    // 멤버변수 선언
    private String name;        
    private String branch;      
    private String course;      
    private String phoneNumber; 

    public Student(String branch, String name) {
        this.name = name;
        this.branch = branch;
        this.course = "미정";       
        this.phoneNumber = "미정";  
    }

    public Student(String branch, String name, String course, String phoneNumber) {
        this(branch, name);
        this.course = course;
        this.phoneNumber = phoneNumber;
    }

    public void print() {
        System.out.println(this.branch + " > " + this.name + "(" + this.course + " / " + this.phoneNumber + ")");
    }

    @Override
    public String toString() {
        return this.branch + " > " + this.name + " (" + this.course + " / " + this.phoneNumber + ")";
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getCourse() {
        return course;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setter 메서드들
    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}