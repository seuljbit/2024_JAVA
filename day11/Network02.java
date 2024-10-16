package day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Network02 {

	public static void main(String[] args) {
		// https://la-room.kr/
		URL url = null;
		String addr = "https://la-room.kr/";
		BufferedReader input = null;
		String line = "";
		
		try {
			url = new URL(addr);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
