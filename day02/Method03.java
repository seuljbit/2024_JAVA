package day02;
import java.util.Scanner;

public class Method03 {

    public static void main(String[] args) {
        /* 정수 하나를 주면 해당 정수의 구구단을 출력하는 메서드(리턴 x)
         * 예) 입력 : 정수를 입력하시오 : 2
         * 출력 : 2x1=2
                2x2=4
                2x3=6
                .... */
                
        Scanner sc = new Scanner(System.in);
        Method03 m3 = new Method03();
        
        System.out.print("정수를 입력하시오: ");
        int dan = sc.nextInt();
        
        m3.gugudan(dan);
        
        sc.close();
    }

    
    public void gugudan(int num) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}