package day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* 과목과 점수를 입력받아(Scanner) map에 저장 후 출력
		 * 합계(sum), 평균(avg) 출력
		 * 종료 키워드가 나올 때까지 반복 (1=계속, 0=종료)
		 ex) 과목/점수 입력 > 국어 78
		     1= 계속, 0=종료 > 1
		     영어 98
		     .... 반복 */
		
		Scanner scan = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;  
        int exit = 1; 

        while (exit != 0) {
            System.out.print("과목/점수 입력 > ");
            String subject = scan.next();
            int score = scan.nextInt();

            map.put(subject, score);
            sum += score;
            count++; 

            System.out.print("1=계속, 0=종료 > ");
            exit = scan.nextInt();
        }

        System.out.println("입력한 과목/점수: " + map);

        System.out.println("합계 : " + sum);
        System.out.printf("평균: %.2f\n", (double) sum / count);

        scan.close();
	}
}
