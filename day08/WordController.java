package day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordController {
	Map<String, String> map = new HashMap<>();
	
	public WordController() {
        map.put("사과", "apple");
        map.put("바나나", "banana");
        map.put("오렌지", "orange");
        map.put("개", "dog");
        map.put("고양이", "cat");
    }

	public void printWordNote() {
		System.out.println("---- 단어장 ----");
		for(String key : map.keySet()) {
			System.out.println("<" + key + "> : " + map.get(key));
		}
        System.out.println("-----------------");
	}
	
	public void addWord(Scanner scan) {
		System.out.print("단어를 입력하세요 > ");
        String word = scan.next();
        System.out.print("단어의 뜻을 입력하세요 > ");
        String mean = scan.next();
        
        map.put(word, mean);
        System.out.println("<" + word + ">가 추가되었습니다.");
	}
	
	public void searchWord(Scanner scan) {
		System.out.print("검색할 단어를 입력하세요 > ");
	    String search = scan.next();
	    
	    if(map.containsKey(search)) {
	    	System.out.println("<" + search + ">의 뜻 : " + map.get(search));
	    	return;
	    }
	    
	    System.out.println("검색할 단어가 없습니다.");
	}
	
	public void modifyWord(Scanner scan) {
		// 단어 수정 : 키 중복 안 됨, add -> 덮어씀
		// 삭제 후 다시 추가
		System.out.print("수정할 단어를 입력하세요 > ");
	    String word = scan.next();
	    
	    if (map.containsKey(word)) {
            System.out.print("수정할 단어의 뜻을 입력하세요 > ");
            String mean = scan.next();
            
            System.out.println("<" + word + ">의 의미가 수정되었습니다.");
            
            System.out.print("변경 전 > ");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            
            map.replace(word, mean);
            
            System.out.print("변경 후 > ");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } else {
            System.out.println("<" + word + ">는 등록되지 않은 단어입니다.");
        }
	}
	
	public void deleteWord(Scanner scan) {
		System.out.println("삭제할 단어를 입력하세요 > ");
	    String word = scan.next();
	    String mean = map.remove(word);
	    
	    if(mean == null) {
	    	System.out.println("삭제할 단어가 없습니다.");
	    	return;
	    }
	    
	    System.out.println("<" + word + "> 가 삭제되었습니다.");
	}
}
