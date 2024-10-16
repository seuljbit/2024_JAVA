package day02;
import java.util.Scanner;

public class MethodEx01 {
    public static void main(String[] args) {
    	/* 계산기 만들기
		 * 1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료
		 * 메뉴 선택 : 1
		 * 숫자 입력 : 1 5
		 * 결과 : 1 + 5 = 6
		 * (더하기 메서드를 호출하여 연산 결과를 출력)
		 * (4번, 5번은 두 번째 숫자가 0이면 0으로 나눌 수 없습니다.)
		 * (6번 누를 떄까지 반복) */
    	
        Scanner sc = new Scanner(System.in);
        MethodEx01 m = new MethodEx01();
        int menu;
        
        do {
            System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료");
            System.out.print("메뉴 선택: ");
            menu = sc.nextInt();

            if(menu >= 1 && menu <= 5) {
                System.out.print("숫자 입력: ");
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                switch(menu) {
                    case 1: System.out.println("결과 : " + num1 + " + " + num2 + " = " + m.sum(num1, num2)); break;
                    case 2: System.out.println("결과 : " + num1 + " - " + num2 + " = " + m.sub(num1, num2)); break;
                    case 3: System.out.println("결과 : " + num1 + " * " + num2 + " = " + m.mul(num1, num2)); break;
                    case 4: 
                    	if(num2 != 0) {
                    		System.out.println("결과: " + num1 + " / " + num2 + " = " + m.div(num1, num2)); break;
                    	} else {
                    		System.out.println("0으로 나눌 수 없습니다."); break;
                    	}
                    case 5: 
                    	if(num2 != 0) {
                    		System.out.println("결과: " + num1 + " % " + num2 + " = " + m.mod(num1, num2)); break;
                    	} else {
                    		System.out.println("0으로 나눌 수 없습니다."); break;
                    	}
                }
            } else if (menu == 6) {
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        } while (menu != 6);
        sc.close();
    }
    
    
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
    
    public int sub(int num1, int num2) {
        return num1 - num2;
    }
    
    public int mul(int num1, int num2) {
        return num1 * num2;
    }
    
    public double div(int num1, int num2) {
        return num1 / (double) num2;
    }
    
    public double mod(int num1, int num2) {
        return num1 % num2;
    }
}