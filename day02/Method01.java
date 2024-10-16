package day02;

public class Method01 {

	public static void main(String[] args) {
		/* 메서드(Method) : function 기능(함수)
		 * 메서드 선언 및 구현
		  - 접근제한자(제어자), 리턴 타입 메서드명(매개변수) {
		  		기능 구현;
		    }
		  - 접근 제한자(제어자) : 접근할 수 있는 주체의 버무이
		  - 리턴 타입 : 리턴할 값의 타입(타입으로만 기재)
		  - 메서드명 : 소문자로 시작
		  - 매개변수 : 기능을 수행하기 위해 필요로 하는 값(외부에서 들어와야 하는 값)
		  - void : 리턴할 값이 없다는 의미
		  - 메서드의 선언 위치
		   1. 클래스 안, 다른 메서드 밖
		   2. 메서드의 선언 순서는 상관 x
		  - 메서드는 순서대로 실행되는 것 x  호출되어야 실행
		  - 메서드의 호출은 다른 메서드에서도 가능, 다른 클래스의 메서드에서가도 가능(접근권한맏 너ㅣ나
		  
		 - 접근 권한
		  1. public : 누구나 사용 가능(모두 가능)
		  2. protected : 나 + 패키지 + 지식클래스(상속을 위해서 사용)
		  3. default : 나 + 패키지
		  4. private : 다른 
		  
		 * */
		int result = sum(10,20);
		System.out.println(result);
		int result2 = sum2(10,20);
		System.out.println(result2);

	}
	
	// 다른 메서드의 위치 공간
	// 두 정수의 값을 매개변수로 주고, 투수의 합을 리턴하는 메서드
	// 리턴 타입 : 합 => int (정수)
	// 메서드명(sum)
	// 매개변수 : 두 정수
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int sum2(int num1, int num2) {
		return num1 + num2;
	}

}
