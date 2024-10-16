package day01;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		/* Scanner 클래스 : 콘솔에서 값을 입력받을 때 사용 (int)(Math.random() * 개수) + 시작할 숫자 : 시작값부터
		 * 개수만큼 정수형 랜덤값 생성 값을 입력받으려면 Scanner scan = new Scanner(System.in);
		 */

		// 주사위값 랜덤 발생
		int random = (int) (Math.random() * 6) + 1;
		System.out.println(random);

		/*
		 * 랜덤으로 주사위를 굴려 총 30칸을 이동하시오 주사위를 던진 횟수를 출력
		 * 
		 * < 주사위 게임 > 주사위는 enter를 치면 던져짐 주사위 : 3 3칸 전진 => 27칸 남음 주사위 : 5 5칸 전진 => 22칸 남음
		 * ......... 도착! 총 던진 횟수 : ?
		 */

		Scanner scan = new Scanner(System.in);
		int position = 0;
		int target = 30;
		int count = 0;

		System.out.println("주사위 GAME!");

		while (position < target) {
			System.out.print("Enter를 눌러 주사위를 던지세요.");
			scan.nextLine();

			int dice = (int) (Math.random() * 6) + 1;
			count++;

			position += dice;
			if (position > target) {
				position = target;
			}

			System.out.println("주사위: " + dice);
			System.out.println(dice + "칸 전진 => " + (target - position) + "칸 남았습니다.");
		}

		System.out.println("도착! 총 던진 횟수: " + count);
		// ctrl + shift + f : 들여쓰기 자동정렬
		scan.close();
	}
}
