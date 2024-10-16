package day01;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// 배열 : 같은 타입, 같은 의미를 가지는 변수들의 집합(참조 변수)
		// 타입 배열명[] = new int[개수];
		// 지역 변수는 초기값 x (안 정해주면 error)
		// 참조변수는 고기값이 있음(숫자=0, 문자 null)
		
		String s = new String("가나다라");
		// String 워낙 자주 사용하는 참조 변수 => 일반 지역변수처럼 사용
		
		String s1 = "akqkt";
		System.out.println(s1);
		System.out.println(s);
		
		int arr[] = new int[5];
//		arr[0] += 1;
//		System.out.println(arr[0]);
		
		// int num;
		// num += 1; -> 초기값이 없어서 Exception 발생
		// arr 배열에 숫자를 1, 2, 3, 4, 5로 채우고 출력
		// arr.length = 총길이 -1번지를 가지기 때문. 5개 0 1 2 3 4
		
		for(int i=0; i<arr.length; i++) {
			arr[i] += i+1;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		/* 숫자 5자리를 입력 받아서 각 자리의 합을 출력
		 * 예 ) 입력값 -> 12345 출력 -> 1+2+3+4+5 = ?? */
		Scanner scan = new Scanner(System.in);

        System.out.print("숫자 5자리를 입력하세요: ");
        String num = scan.nextLine();  

        String number[] = num.split(""); // 개수 상관이 입력한 숫자가 배열로 리턴
        
        int sum = 0;
        
        for(int i=0; i<number.length-1; i++) {
        	System.out.print(number[i] + " + ");
        	// String => int 변환 Integer.parseInt(변환 가능한 문자)
        	sum += Integer.parseInt(number[i]);
        }
        
        sum += Integer.parseInt(number[number.length-1]);
        System.out.print(number[number.length-1] + " = " + sum);
        System.out.println();
        
        for(int i=number.length-1; i>0; i--) {
        	System.out.print(number[i] + " + ");
        }
        System.out.println(number[0] + " = " + sum);
        scan.close();
	}

}
