package day07;

import java.util.Random;

public class ExceptionEx01 {

	public static void main(String[] args) {
		// 리턴 받은 배열을 출력
		int start = 1, count = 10, size = 0;
		int arr[] = null;
		
		ExceptionEx01 ex01 = new ExceptionEx01();

		try {
			int arr2[] = new int[size];
//			arr = ex01.createArr(size, start, count);
			ex01.createArr(arr2, start, count);
			for(int t : arr) {
				System.out.println(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public int random( int start, int count) throws RuntimeException {
//		int random = (int)(Math.random()*count)+start;
		if(count <= 0) {
			throw new RuntimeException("random의 범위가 0보다 작습니다.");
		}
		return new Random().nextInt(count)+start;
	}
	
	/* 매서드 생성
	 * 기능 : size를 입력받아(매개변수) size만큼의 길이를 가지는 배열을 생성하여
	 * 랜덤값을 채워 배열을 리턴
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - size가 0보다 작으면 예외발생
	 * - 랜덤값의 개수가 0이면 예외발생
	 * */
	public int[] createArr(int size, int start, int count) throws RuntimeException {
		if(size < 0) {
			throw new RuntimeException("배열의 길이가 0보다 작습니다.");
		}
		int arr[] = new int[size];
		for(int i=0; i<arr.length; i++) {
			// RuntimeException 이 아닌 Checked Exception 이였다면 이미 빨간밑줄.
			arr[i] = random(start, count);
		}
		return arr;
	}
	
	/* 매서드
	 * 기능 : 매개변수로 배열을 받아 랜덤값을 채우는 메서드
	 * 랜덤값은 범위를 매개변수를 받아 start(시작값), count(개수)
	 * - 랜덤값의 개수가 0이면 예외발생
	 * - 배열이 null이면 예외발생
	 * - 배열의 길이가 0보다 작으면 예외발생
	 * */
	public void createArr(int arr[], int start, int count) throws RuntimeException {
		if(arr == null) {
			throw new RuntimeException("배열이 null입니다.");
		}
		if(arr.length <= 0) {
			throw new RuntimeException("배열의 길이가 0보다 작습니다.");
		}
		
		for(int i=0; i<arr.length; i++) {
			// RuntimeException 이 아닌 Checked Exception 이였다면 이미 빨간밑줄.
			arr[i] = random(start, count);
		}
	}
	

}