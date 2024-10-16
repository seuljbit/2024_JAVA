package day06;

public class Exception03 {

	public static void main(String[] args) {
		/* 자주 발생하는 예외 코드들
		 * ArithmeticException : 0으로 나누었을 때 발생
		 * ArrayIndexOutOfBoundsException : 배열의 index 가 범위를 벗어났을 때 발생
		 * NullPointerException : 객체의 값이 null 일 경우, 혹은 객체 자체가 없을 경우
		 * ClassCastException : 다운캐스팅이 잘못되었을 경우(형변환) */
		
		int[] arr = null;
		for (int i = 0; i <= arr.length; i++) {
			System.out.println(arr[i]); // java.lang.NullPointerException
		}
		
		int[] arr1 = new int[5];
		for (int i = 0; i <= arr1.length; i++) {
			System.out.println(arr1[i]); // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
		}

	}
}
