package student;

import java.util.Scanner;

public class SubjectController implements SubjectProgram {
	private Subjects[] subject = new Subjects[10]; // 과목 배열

	public SubjectController() {
		subject[0] = new Subjects("알고리즘 및 자료구조", "CS101", 3.0, 3, "김교수", "월 09:00-11:00", "IT관 101호");
		subject[1] = new Subjects("운영체제 개론", "CS102", 3.1, 4, "박교수", "화 13:00-15:00", "IT관 202호");
		subject[2] = new Subjects("컴퓨터 네트워크", "CS103", 3.2, 2, "이교수", "수 09:00-11:00", "공학관 305호");
		subject[3] = new Subjects("프로그래밍 언어론", "CS104", 3.3, 3, "최교수", "목 14:00-16:00", "컴퓨터과학관 401호");
		subject[4] = new Subjects("데이터베이스 설계", "CS105", 3.4, 4, "홍교수", "금 10:00-12:00", "멀티미디어관 102호");
		subject[5] = new Subjects("인공지능 기초", "CS106", 3.5, 5, "정교수", "월 13:00-15:00", "전자정보관 203호");
		subject[6] = new Subjects("소프트웨어 공학", "CS107", 3.6, 3, "백교수", "화 10:00-12:00", "강의동 501호");
		subject[7] = new Subjects("컴퓨터 구조", "CS108", 3.7, 4, "김교수", "수 14:00-16:00", "정보기술관 402호");
		subject[8] = new Subjects("웹 프로그래밍", "CS109", 3.8, 5, "문교수", "목 09:00-11:00", "AI연구센터 301호");
		subject[9] = new Subjects("모바일 애플리케이션 개발", "CS110", 3.9, 2, "서교수", "금 14:00-16:00", "컴퓨터실습실 205호");
	}

	public void printSubject() {
		for (int i = 0; i < subject.length; i++) {
			System.out.println(i + 1 + ". " + subject[i]);
		}
	}

	@Override
	public void registerSubject(Scanner scan, Students student) {
		printSubject();
		System.out.println("수강을 원하는 과목 코드를 입력해 주세요.");
		String subCode = scan.next();
		boolean found = false;

		for (Subjects sub : subject) {
			if (sub != null && sub.getSubCode().equals(subCode)) {
				student.addSubject(sub);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 과목 코드를 찾을 수 없습니다.");
		}
	}

	@Override
	public void delectSubject(Scanner scan, Students student) {
	    if (student.getSubCnt() == 0) {
	        System.out.println("철회할 과목이 없습니다.");
	        return;
	    }

	    student.printStudentInfo(); 
	    System.out.println("수강 과목 목록: ");
	    student.printSubjects(); // 수강 과목만 출력

	    System.out.println("철회할 과목 코드를 입력하세요: ");
	    String subCode = scan.next();
	    boolean found = false;

	    for (int i = 0; i < student.getSubjects().length; i++) {
	        Subjects[] subjects = student.getSubjects();
	        if (subjects[i] != null && subjects[i].getSubCode().equals(subCode)) {
	            for (int j = i; j < student.getSubCnt() - 1; j++) {
	                subjects[j] = subjects[j + 1];
	            }
	            subjects[student.getSubCnt() - 1] = null;
	            student.decSubCnt(); 
	            System.out.println(subCode + "과목 철회 완료: ");
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("해당 과목을 찾을 수 없습니다.");
	    }
	}
}