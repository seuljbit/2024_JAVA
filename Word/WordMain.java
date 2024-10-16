package Word;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) throws IOException {
		/* 단어장 프로그램(Word class 생성)
		 * menu
		  1. 단어 등록 | 2. 단어 검색 | 3. 단어장 출력
		  4. 단어 수정 | 5. 단어 삭제 | 6. 파일 생성 | 7. 종료
		 * 단어, 뜻 (List<String>)
		 * Word(equals 사용) : 단어가 같으면 같은 객체 */
		
		WordController c = new WordController();
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			System.out.println
            ("\n1) 단어 등록 | 2) 단어 검색 | 3) 단어장 출력"
           + "\n4) 단어 수정 | 5) 단어 삭제 | 6) 텍스트 파일 생성 | 7) 종료");
			System.out.print("menu > ");
            menu = scan.nextInt();
            System.out.println();
            
            switch(menu) {
            	case 1 : c.addWord(scan); break;
            	case 2 : c.searchWord(scan); break;
            	case 3 : c.printWordNote(); ; break;
            	case 4 : c.modifyWord(scan); break;
            	case 5 : c.deleteWord(scan); break;
            	case 6 : c.createFile(); break;
            	case 7 : System.out.println("단어장을 종료합니다."); break;
	            default : System.out.println("잘못된 메뉴입니다.");
            }
		} while(menu != 7);
		
		scan.close();
	}
}
