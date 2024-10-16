package day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MapEx01 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 5개를 입력받아 콘솔에 출력하는 기능
		 * ---- 단어장 -----
		 * hello : 안녕
		 * apple : 사과
		 * orange : 오렌지
		 * map 저장 후 출력 */
		
		Scanner scan = new Scanner(System.in);
		int size = 5;
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < size; i++) {
			// 공백 허용 scan.naxtLine(); 
			// enter 콘솔 입력 시 완료
			// naxtLine() : enter값으로 인지하는 케이스는
			// 다른 입력값 -> naxtLine() 이 오는 케이스
			
			System.out.print("단어를 입력하세요 : ");
            String word = scan.nextLine();
            System.out.print("단어의 뜻을 입력하세요: ");
            String meaning = scan.next();
            scan.nextLine(); // 완료의 enter 처리할 수 있는 값
            //System.out.print("test : ");
            //String test = scan.nextLine();
            
            map.put(word, meaning);
        }

        System.out.println("---- 단어장 ----");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	System.out.println(key + " : " + map.get(key));
        }
        
        scan.close();
        
        System.out.println(map.entrySet());
	}

}
