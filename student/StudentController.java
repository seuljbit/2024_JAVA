package student;
import java.util.Scanner;

public class StudentController implements StudentProgram {
	/* Student class : 학생 정보
	  - 학번, 이름, 나이, 전화번호, 주소, 수강과목 (Subject class를 배열로 처리) */
	
	private Students[] student = new Students[10];  // 학생 배열
	private int stuCnt;  // 현재 등록된 학생 수
	
	@Override // 학생의 기본 정보 출력
	public void printStudent() {
		if (stuCnt == 0) {
            System.out.println("등록된 학생이 없습니다.");
        } else {
            for (int i=0; i<stuCnt; i++) {
                System.out.println(i+1 + ". " + student[i]);
            }
        }
	}
	
	@Override
	public void insertStudent(Scanner scan) {
		if (stuCnt == student.length) {
			Students[] tmp = new Students[student.length + 5];
			System.arraycopy(student, 0, tmp, 0, stuCnt);
			student = tmp;
		}
		
		System.out.print("학생명 : ");
		String name = scan.next();
		
		System.out.print("나이 : ");
		int age = scan.nextInt();
		
		System.out.print("학번 : ");
		String stuNum = scan.next();
		
		System.out.print("전화번호 : ");
		String phoneNumber = scan.next();
		
		System.out.print("주소 : ");
		String address = scan.next();
		
		student[stuCnt] = new Students(name, age, stuNum, phoneNumber, address);
		stuCnt++; 
		
		System.out.println("학생 정보가 등록되었습니다.");
	}
	
	@Override
	public Students searchStudent(Scanner scan) {
	    if (stuCnt == 0) {
	        System.out.println("학생 목록이 비어있습니다.");
	        return null;
	    }
	    
	    String search = scan.next();
	    
	    for (int i = 0; i < stuCnt; i++) {
	        if (student[i].getName().equals(search) || student[i].getStuNum().equals(search)) {
	            System.out.println("검색한 학생 정보 : " + student[i]);
	            return student[i]; // 검색된 학생 반환
	        }
	    }
	    
	    System.out.println("해당하는 학생명/학번이 없습니다.");
	    return null; // 검색 실패 시 null 반환
	}

	@Override
	public void modifyStudent(Scanner scan) {
	    if (stuCnt == 0) {
	        System.out.println("학생 목록이 비어있습니다.");
	        return;
	    }
	    
	    printStudent();
	    Students studentToModify = searchStudent(scan); 
	    if (studentToModify == null) {
	        return; // 학생을 찾지 못한 경우
	    }
	    
	    System.out.println("수정할 학생명 : ");
	    String newName = scan.next();
	    
	    System.out.print("수정할 전화번호: ");
	    String newPhoneNumber = scan.next();
	    
	    System.out.print("수정할 주소: ");
	    String newAddr = scan.next();
	    
	    studentToModify.setName(newName);
	    studentToModify.setPhoneNumber(newPhoneNumber);
	    studentToModify.setAddress(newAddr);
	    
	    System.out.println("학생 정보가 수정되었습니다.");
	}

	
	@Override
	public void deleteStudent(Scanner scan) {
	    if (stuCnt == 0) {
	        System.out.println("학생 목록이 비어있습니다.");
	        return;
	    }
	    
	    printStudent();
	    Students studentToDelete = searchStudent(scan);
	    if (studentToDelete == null) {
	        return; 
	    }
	    
	    int index = -1;
	    for (int i = 0; i < stuCnt; i++) {
	        if (student[i] == studentToDelete) {
	            index = i;
	            break;
	        }
	    }
	    
	    if (index != -1) {
	        int copyCnt = stuCnt - index - 1;
	        if (copyCnt > 0) {
	            System.arraycopy(student, index + 1, student, index, copyCnt);
	        }
	        student[--stuCnt] = null; 
	        System.out.println("해당 학생이 삭제되었습니다.");
	    }
	}

}