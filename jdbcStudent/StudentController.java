package jdbcStudent;

import java.util.*;

public class StudentController {
	private Scanner scan;
	private Service svc;
	private boolean flag;
	
	public StudentController() {
		scan = new Scanner(System.in);
		svc = new StudentServiceImpl(); // service interface 구현체(service) 연결
		flag = true;
		printMenu();
	}
	
	private void printMenu() {
		while(flag) {
			System.out.println("--< 학생 관리 프로그램 >--");
			System.out.println
				("1) 학생 등록 | 2) 학생 리스트 | 3) 학생 검색 \r\n"
			   + "4) 학생 삭제 | 5) 학생 정보 수정 | 6) 학부/학과 검색 | 7) 종료");
			System.out.print("menu > ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1 : enrollment(); break;
			case 2 : studentList(); break;
			case 3 : studentSearch(); break;
			case 4 : studentDelete(); break;
			case 5 : studentModify(); break;
			case 6 : majorSearch(); break;
			case 7 : flag = false; System.out.println("프로그램을 종료합니다.");break;
			default : System.out.println("잘못된 메뉴입니다."); break;
			}
		}
	}

	private void enrollment() { // 학생 등록
		System.out.println("학번 : ");
		String id = scan.next();
		scan.nextLine();

		System.out.print("학생명 : ");
		String name = scan.next();
		scan.nextLine();
		
		System.out.print("전화번호 : ");
		String phone_number = scan.next();
		scan.nextLine();

		System.out.print("주소 : ");
		String address = scan.next();
		scan.nextLine();
		
		System.out.print("생년월일 : ");
		String birth_date = scan.next();
		scan.nextLine();

		System.out.print("학부 : ");
		String department = scan.next();
		scan.nextLine();
		
		System.out.print("학과 : ");
		String major = scan.next();
		scan.nextLine();
		
		Student stu = new Student(id, name, phone_number, address, birth_date, department, major);
		
		int isOk = svc.insert(stu);
		System.out.println("학생 등록 > " + (isOk > 0 ? "등록이 성공했습니다." : "등록이 실패했습니다."));
	}

	private void studentList() { // 학생 리스트 출력 (일부 정보만)
		List<Student> list = svc.getList();
		
		System.out.println("--< 전체 학생 목록 >--");
		for(Student stu : list) {
			System.out.println(stu);
		}
	    System.out.println();
	}

	private void studentSearch() { // 학생 정보(모든 정보)
	    System.out.print("검색할 학번 입력 > ");
	    String student_id = scan.next();  // 학번을 입력받음
	    scan.nextLine(); 
	    
	    Student student = svc.search(student_id);  // 학번으로 학생 검색
	    
	    if (student != null) {
	        System.out.println(student);  // 검색된 학생 정보 출력
	    } else {
	        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
	    }
	    System.out.println();
	}

	private void studentDelete() { // 학생 정보 삭제
		System.out.println("정보 삭제할 학번 입력 > ");
		String student_id = scan.next();
		scan.nextLine();

	    int isOk = svc.delete(student_id);

	    System.out.println("학생 정보 삭제 > " + (isOk > 0 ? "삭제 성공!" : "삭제 실패"));
	}

	private void studentModify() {
	    System.out.print("수정할 학번 입력 : ");
	    String id = scan.next();  
	    scan.nextLine(); 

	    System.out.print("수정할 학생명 입력 : ");
	    String name = scan.nextLine(); 
	    
	    System.out.print("수정할 전화번호 입력 : ");
	    String phone_number = scan.nextLine(); 

	    System.out.print("수정할 주소 입력 : ");
	    String address = scan.nextLine(); 

	    System.out.print("수정할 생년월일 입력 : ");
	    String birth_date = scan.nextLine(); 

	    System.out.print("수정할 학부 입력 : ");
	    String department = scan.nextLine(); 

	    System.out.print("수정할 학과 입력 : ");
	    String major = scan.nextLine();  
	    
	    Student stu = new Student(id, name, phone_number, address, birth_date, department, major);
	    
	    int isOk = svc.update(stu);
	    System.out.println("학생 정보 수정 > " + (isOk > 0 ? "수정 성공!" : "수정 실패"));
	    System.out.println();
	}

	private void majorSearch() {
	    System.out.print("조회할 학부/학과 입력 : ");
	    
	    if (scan.hasNextLine()) {
	        scan.nextLine(); 
	    }
	    
	    String major = scan.nextLine();  
	    
	    List<Student> majors = svc.majorSearch(major);
	    
	    if (majors != null && !majors.isEmpty()) {
    	    System.out.println("--< " + major + " 학생 명단 >--");
	        for (Student stu : majors) {
	            System.out.println(stu);
	        }
	    } else {
	        System.out.println("해당 학부/학과는 존재하지 않습니다.");
	    }
	    System.out.println();
	}


}
