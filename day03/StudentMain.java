package day03;

public class StudentMain {
    public static void main(String[] args) {
        // 학생 객체 생성
        Student student1 = new Student("서울 지점", "이혜인", "Java", "010-1111-1111");
        Student student2 = new Student("인천 지점", "강해린", "JS", "010-2222-2222");
        Student student3 = new Student("부산 지점", "팜하니", "Python", "010-3333-3333");
        Student student4 = new Student("제주 지점", "다니엘", "React", "010-4444-4444");
        Student student5 = new Student("강원 지점", "김민지", "AWS", "010-5555-5555");

        Student[] studentArr = new Student[5];

        studentArr[0] = student1;
        studentArr[1] = student2;
        studentArr[2] = student3;
        studentArr[3] = student4;
        studentArr[4] = student5;

        // 전체 학생 명단 출력
        System.out.println();
        System.out.println("전체 학생 명단:");
        for (int i = 0; i < studentArr.length; i++) {
            studentArr[i].print();
        }

        for (Student stemp : studentArr) {
            System.out.println(stemp);  
        }
        
        System.out.println();
        // 김민지의 정보만 출력
        // equals() : String 값이 같은지 확인하는 메서드
        String searchName = "김민지";
        for (Student stemp : studentArr) {
            if (stemp.getName().equals(searchName)) {
                stemp.print();
            }
        }
        
        System.out.println();
        // 인천 지점 학생의 정보 출력
        String searchBranch = "인천 지점";
        int cnt = 0;
        for (Student stemp : studentArr) {
            if (stemp.getBranch().equals(searchBranch)) {
                stemp.print();
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("명단에 없습니다.");
        }
        System.out.println();
        System.out.println("======================");
        // 김민지의 과정명을 AMS로 변경 -> 출력
        System.out.println();
        for (int i=0; i<studentArr.length; i++) {
        	if(studentArr[i].getName().equals(searchName)) {
        		studentArr[i].setCourse("JAVA");
        		System.out.println(studentArr[i]);
        	}
        }
    }
}