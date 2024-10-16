package day10;

import java.io.IOException;

public class File02 {

	public static void main(String[] args) {
		// System.in 을 이용하여 알파벳 받기
		// Enter 인식
		
		System.out.print("알파벳 입력 > ");
		
		try {
			int in;
			while((in = System.in.read()) != '\n') { // enter가 아니면 출력
				System.out.print((char)in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
