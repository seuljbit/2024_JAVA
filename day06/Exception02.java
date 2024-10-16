package day06;

import java.text.ParseException;

public class Exception02 {
	/* 두 수를 입력받고 연산자를 입력받아 사칙연산의 결과를 리턴하는 메서드
	 * 매개변수 : int num1, int num2, char op
	 * return double
	 * 예외 발생시키기 : throw new 발생시킬 수 있음
	 * 예외를 발생시키게 되면 메서드 선언부 끝에 throws 를 적고, 발생시킨 예외를 반드시 적어줘야 함 */
	
	public static void main(String[] args) throws ParseException {
		Exception02 calc = new Exception02();
		
		System.out.println(calc.calc(5, 0, '/'));
	}
	
	public String calc(int num1, int num2, char op) {
		double result = 0;

		try {
			switch(op) {
				case '+' : result = num1 + num2; break;
				case '-' : result = num1 - num2; break;
				case '*' : result = num1 * num2; break;
				case '/' :
					if (num2 == 0) {
						throw new ArithmeticException("0으로 나눌 수 없습니다.");
					} else {
						result = num1 / num2;;
					} break;
				case '%' :
					if (num2 == 0) {
						throw new ArithmeticException("0으로 나머지 연산을 할 수 없습니다.");
					} else {
						result = num1 % num2;;
					} break;
				default : throw new RuntimeException("< " + op + " >는 산술연산자가 아닙니다.");
			}
		} catch (ArithmeticException e) {
			System.out.println("예외 발생! " + e.getMessage());
		}
		return "결과 : " + result;
	}
}

