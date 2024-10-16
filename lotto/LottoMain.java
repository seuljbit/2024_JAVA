package lotto;
import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
		/* 로또 프로그램
		 * - menu -
		   1. 사용자 로또 번호 생성(수동) : 사용자가 직접 번호 입력
		   2. 사용자 로또 번호 생성(자동) : Random
		   3. 당첨 번호 입력(수동, 자동) : 사용자가 직접 입력
		   4. 당첨 확인 : 가장 마지막에 발행한 당첨번호로 확인
		   5. 역대 당첨번호 목록 확인
		   6. 종료
		   
		 * 로또는 상속을 하여 사용
		 * Lotto class => 사용자의 번호를 저장하는 클래스
		  - 회차 : 첫 발행부터 자동 증가 1회차 ex) 1회차 1 2 3 4 5 6
		  - 6자리 배열을 넣는 클래스(중복 x), 출력 
		 * LottoExtend class => Lotto를 상속 + 보너스 번호
		  - 회차 : 첫 발행부터 자동 증가 1회차 ex) 1회차 1 2 3 4 5 6 [7]
		 * LottoController => 처리  */
		
		 Scanner scan = new Scanner(System.in);
		 LottoController controller = new LottoController();
	     Lotto userLotto = new Lotto();
	     int menu;

	        do {
	        	System.out.println("\n메뉴를 선택하세요.");
	            System.out.println("1. 사용자 로또 번호 수동 생성 | 2. 사용자 로또 번호 자동 생성");
	            System.out.println("3. 당첨 번호 생성          | 4. 당첨 결과 확인");
	            System.out.println("5. 역대 당첨번호 목록 확인    | 6. 종료");
	            System.out.print("메뉴 선택 : ");
	            menu = scan.nextInt();
	            System.out.println();

	            switch (menu) {
	                case 1 : controller.inputUserLotto(userLotto, scan); break;
	                case 2 : userLotto.generateNumbers();
	                		 System.out.println("사용자 로또 번호(자동)가 생성되었습니다.");
	                		 System.out.print("사용자 로또 번호 : ");
	                    	 userLotto.printNumbers(); 
	                         System.out.println(); break;
	                case 3 : controller.generateLotto();
	                	 	 controller.printLastLotto(); break;
	                case 4 : controller.checkLottoResult(userLotto); break;
	                case 5 : controller.printLottoHistory(); break;
	                case 6 : System.out.println("프로그램을 종료합니다."); break;
	                default : System.out.println("잘못된 입력입니다."); break;
	            }
	        } while (menu != 6);
	        scan.close();
	}
}