package student;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		/* 메뉴 처리
		   1. 학생 등록 | 2. 학생 리스트 보기 | 3. 학생 검색 | 4. 학생 정보 수정 |
		   5. 학생 삭제 | 6. 수강 신청 | 7. 수강 철회 | 8. 종료
		   
		 * 3번 입력 시 학생 정보, 수강 정보 출력
		 * 7개의 메뉴 메서드 정리, StudentController가 구현
		  - Student class 배열처리
		  
		 * Student class : 학생 정보
		  - 학번, 이름, 나이, 전화번호, 주소, 수강과목s (Subject class를 배열로 처리)
		  
		 * Subject class : 과목 정보
		  - 과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장 */
		
		StudentController stu = new StudentController();
		SubjectController sub = new SubjectController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			System.out.println
            ("\n1) 학생 등록 | 2) 학생 리스트 보기 | 3) 학생 검색 | 4) 학생 정보 수정 |"
           + "\n5) 학생 삭제 | 6) 수강 신청      | 7) 수강 철회 | 8) 종료");
			System.out.print("menu > ");
            menu = scan.nextInt();
			
			switch(menu) {
	            case 1 : stu.insertStudent(scan); break;
	            case 2 : stu.printStudent(); break;
	            case 3 : System.out.println("검색할 학생명 또는 학번을 입력하세요.");
	            		 stu.searchStudent(scan); break;
	            case 4 : stu.modifyStudent(scan); break;
	            case 5 : stu.deleteStudent(scan); break;
	            case 6 : System.out.println("수강 신청 대상 학생명 또는 학번을 선택하세요.");
	            		 stu.printStudent();
	                	 Students foundStudentForSubject = stu.searchStudent(scan);
	                	 if (foundStudentForSubject != null) {
	                	 	 sub.registerSubject(scan, foundStudentForSubject);
	                	 }  break;
	            case 7 : System.out.println("수강 철회 대상 학생명 또는 학번을 선택하세요.");
	            		 stu.printStudent();
	            		 Students foundStudentForWithdrawal = stu.searchStudent(scan);
	            		 if (foundStudentForWithdrawal != null) {
	            			 sub.delectSubject(scan, foundStudentForWithdrawal); 
	            		 } break;
	            case 8 : System.out.println("키오스크 종료!!"); break;
	            default : System.out.println("잘못된 메뉴입니다.");
			}
		} while(menu != 8);
		scan.close();
	}
}