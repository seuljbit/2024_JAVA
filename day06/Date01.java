package day06;

import java.util.Calendar;

public class Date01 {
	public static void main(String[] args) {
		/* 날짜 / 시간 클래스
		 * Date 클래스 -> Deprecated(비권장, 죽었음...)
		 * Calendar -> Date 후속작, 추상 클래스(객체 생성 x)
		 * new 키워드로 객체 생성 불가능
		 * getInstance() 메서드를 이용하여 객체를 얻어와야 함 */
		Calendar c = Calendar.getInstance(); // 오늘 날짜
		System.out.println(c);
		
		// 연도 출력하는 방법 1)
		System.out.println(c.getWeekYear()); // 2024
		
		// 연도 출력하는 방법 2)
		int year = c.get(Calendar.YEAR);
		System.out.println(year); // 2024
		
		// month 0~11 +1 표현
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month); // 10
		
		int day = c.get(Calendar.DATE);
		System.out.println(day); // 7
		
		int day2 = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day2); // 7
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week); // 2 = 월요일
		
		String weekString = null;
		
		switch(week) {
			case 1 : weekString = "일"; break;
			case 2 : weekString = "월"; break;
			case 3 : weekString = "화"; break;
			case 4 : weekString = "수"; break;
			case 5 : weekString = "목"; break;
			case 6 : weekString = "금"; break;
			case 7 : weekString = "토"; break;
		}
		
		System.out.println(year + "-" + month + "-" + day);

		// 2024-10-07(월) 오후 03:51
		
		int amPm = c.get(Calendar.AM_PM);
		String a;
		
		if (amPm == Calendar.AM) {
            a = "오전";
        } else {
            a = "오후";
        }
		
		int hour = c.get(Calendar.HOUR);
		System.out.println(hour);
		
		int minute = c.get(Calendar.MINUTE);
		System.out.println(minute);
		
		System.out.println(year + "-" + month + "-" + day + "(" + weekString + ") " + a + " "+ hour + ":" + minute);
		System.out.println(String.format("%04d-%02d-%02d(%s) %s %02d:%02d", year, month, day, weekString, a, hour, minute));

	}

}
