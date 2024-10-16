package day01;
import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
    	/* ex) 검색어를 입력 받아 fileName 배열에 검색어가 존재하면 해당 파일 이름을 출력
		 * 검색어 : java
		 * 출력 : spring.java, String.java
		 
		 * 검색어 : s
		 * 출력 : spring.java, css.css, String.java
		  
		 * 검색어 : 가나다
		 * 출력 : 검색 결과가 없습니다. */
    	
        String[] fileName = {
            "spring.java", "python.py", "react.jsx", "css.css", "String.java", "component.jsx", "text.txt"
        };

        Scanner scan = new Scanner(System.in);
        System.out.print("검색어를 입력하세요: ");
        String search = scan.nextLine();

        System.out.println("검색어 \"" + search + "\"가 포함된 파일들:");
        
        boolean found = false;

        for (int i = 0; i < fileName.length; i++) { 
            if (fileName[i].toLowerCase().contains(search.toLowerCase())) {
                System.out.println(fileName[i]);
                found = true; 
            }
        }

        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }

        scan.close();
    }
}
