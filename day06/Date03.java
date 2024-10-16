package day06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date03 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date); // 현재 시스템 날짜와 시간 출력

		// Date 형식의 날짜를 포맷에 맞춰 문자열로 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		System.out.println(sdf.format(date)); // 2024-10-07(월) 04:46:48, String 형식으로 변경
		
		// 날짜 모양의 문자열을 -> 실제 Date 로 변경 (패턴 수정 필요)
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 24시간 형식 패턴
		String dateStr = "2024-10-07 04:49:08"; // 요일 없이 24시간 형식
		
		try {
			Date date2 = sdf2.parse(dateStr); // 올바른 패턴으로 파싱
			System.out.println(date2); // 파싱된 Date 객체 출력
		} catch (ParseException e) {
			e.printStackTrace(); // 파싱 예외 처리
		}
	}

}