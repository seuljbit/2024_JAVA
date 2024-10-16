package day08;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* 단어장 프로그램 작성
		 * menu
		  1. 단어 등록 | 2. 단어 검색 | 3. 단어 수정
		  4. 단어 삭제 | 5. 단어 출력 | 6. 단어장 종료 
		 * map을 이용하여 단어 등록
		 * 기본 단어(5가지) 등록
		 * main에서 메뉴 반복 처리 */
		
		WordController c = new WordController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			System.out.println
            ("\n1) 단어 등록 | 2) 단어 검색 | 3) 단어 수정"
           + "\n4) 단어 삭제 | 5) 단어 출력 | 6) 단어장 종료");
			System.out.print("menu > ");
            menu = scan.nextInt();
            System.out.println();
            
            switch(menu) {
            	case 1 : c.addWord(scan); break;
            	case 2 : c.searchWord(scan); break;
            	case 3 : c.modifyWord(scan); ; break;
            	case 4 : c.deleteWord(scan); break;
            	case 5 : c.printWordNote(); break;
            	case 6 : System.out.println("단어장을 종료합니다."); break;
	            default : System.out.println("잘못된 메뉴입니다.");
            }
		} while(menu != 6);
		
		scan.close();
	}
}