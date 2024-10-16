package day04;

public class StudentMain {

    public static void main(String[] args) {
        // 학생 객체 생성
        Student student1 = new Student("김민지", "010101", "010-1111-1111", 21, "강원");
        Student student2 = new Student("이혜인", "020202", "010-2222-2222", 22, "서울");
        Student student3 = new Student("팜하니", "030303", "010-3333-3333", 23, "인천");
        Student student4 = new Student("강혜린", "040404", "010-4444-4444", 24, "경기");
        Student student5 = new Student("다니엘", "050505", "010-5555-5555", 25, "경기");

        // 배열에 학생 객체 저장
        Student[] studentArr = {student1, student2, student3, student4, student5};
        
        // 학생 1명의 과목 추가 및 출력
        student1.addSubject("Java", "6개월");
        student1.addSubject("Python", "3개월");
        student1.addSubject("SQLD", "2개월");
        student1.addSubject("AWS", "1개월");
        student1.addSubject("JS", "5개월");
        

        student2.addSubject("SQLD", "6개월");
        student2.addSubject("Python", "3개월");
        student2.addSubject("JS", "1개월");
        student2.addSubject("AWS", "5개월");
        student2.addSubject("Java", "2개월");
        
        // 학생 전체 명단 출력
        System.out.println("< 전체 학생 명단 >");
        for (Student student : studentArr) {
            student.printStudentInfo();
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();
        
        // '김' 학생의 학생정보, 학원정보, 수강정보 출력
        System.out.println("< '김'씨 학생, 학원, 수강 정보 >");
        String searchName = "김";
        int cnt = 0;
        for (Student student : studentArr) {
        	if (student.getName().contains(searchName)) {
                student.printStudentInfo();
                student.printAcademyInfo();
                student.printSubjects();
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("해당 이름의 학생이 없습니다.");
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();
        
        // 인천 지점의 학생 명단 출력 (학생 정보만)
        int cnt2 = 0;
        System.out.println("< 인천 지점 학생 명단 >");
        for (Student student : studentArr) {
            if (student.getBranch().equals("인천")) {
                student.printStudentInfo();
                student.printAcademyInfo();
                cnt2++;
            }
        }
        if (cnt2 == 0) {
            System.out.println("해당 지점의 학생이 없습니다.");
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        // Java 과목을 수강하는 학생명단 출력(학생 정보, 학원정보, 수강정보 전부 출력)
        System.out.println("< Java 과목 수강 학생 명단 >");
        for (Student student : studentArr) {
            if (student.booleanSubject("Java")) {
                student.printStudentInfo();
                student.printAcademyInfo();
                student.printSubjects();
                System.out.println();
            }
        }
        System.out.println("-----------------------------");
        System.out.println();

        // 수강하지 않는 학생 명단 출력 (학생 정보만..)
        System.out.println("< 수강하지 않는 학생 명단 >");
        for (Student student : studentArr) {
            if (student.getSubjectCount() == 0) {
                student.printStudentInfo();
            }
        }
    }
}