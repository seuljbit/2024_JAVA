package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today); //2024-10-07T16:20:23.685635500
		System.out.println(today.getYear()); // 204
		
		String t = today.toString();
		System.out.println(t); // 2024-10-07T16:20:23.685635500
		
		String date = t.substring(0, t.indexOf("T")); // 시:분:초 추출
		System.out.println(date); // 2024-10-07
		
		String time = t.substring(t.indexOf("T")+1, t.indexOf("."));
		System.out.println(time); // 16:40:48
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today)); // 2024/10/07 04:40:48
		
		LocalDateTime sDate = LocalDateTime.of(2009, 7, 30, 8, 30, 22);
		System.out.println(sDate); // 2009-07-30T08:30
		System.out.println(dtf.format(sDate)); // 2009/07/30 08:30:22
	}

}
