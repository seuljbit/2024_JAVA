package day01;

public class Test02 {

	public static void main(String[] args) {
		/* 국어, 영어, 수학 세 점수의 합계와 평균을 출력 
		 * if문 이용하여 평균 80점 이상이면 pass /fail */
		
		int kor = 77;
		int eng = 62;
		int math = 85;
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		String result;
		
		if(avg >= 80) {
			result = "pass";
		} else {
			result = "fail";
		}
		
		System.out.println("합계 : " + sum + ", 평균 : " + avg + ", 결과 : " + result);
	}

}
