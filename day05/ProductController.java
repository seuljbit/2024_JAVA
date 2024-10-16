package day05;

import java.util.Scanner;

public class ProductController {
    // Product 배열 생성
    private Product[] menu = new Product[10]; // 최대 10개의 상품
    private int cnt; // 현재 등록된 상품 개수, 인덱스 역할
    
    // 상품 리스트 출력
    public void printProduct() {
        if (cnt == 0) {
            System.out.println("등록된 상품이 없습니다.");
        } else {
            for (int i=0; i<cnt; i++) {
                System.out.println(i+1 + ". " + menu[i]);
            }
        }
    }
    
    // 상품 등록
    public void insertProduct(Scanner scan) {
//        if (cnt >= menu.length) {
//            System.out.println("더 이상 상품을 등록할 수 없습니다.");
//            return;
//        }
    	
    	if (cnt == menu.length) {
    		// 5개 더 많은 길이의 배열을 생성
    		Product[] tmp = new Product[menu.length+5];
    		
    		//배열 복사 : 기존 배열(menu)의 0번지부터 새배열(tmp)의 0번지부터 cnt 개수만큼 복사
    		System.arraycopy(menu, 0, tmp, 0, cnt);
    		menu = tmp;
    	}
        
        System.out.print("상품명 : ");
        String name = scan.next();
        
        System.out.print("가격 : ");
        int price = scan.nextInt();
        
        menu[cnt] = new Product(name, price);
        cnt++;
        
        System.out.println("상품이 등록되었습니다.");
    }
    
    // 상품 삭제
    public void deleteProduct(Scanner scan) {
        if (cnt == 0) {
            System.out.println("삭제할 상품이 없습니다.");
            return;
        }

        printProduct();
        System.out.print("삭제할 상품 번호 또는 상품명을 입력하세요: ");
        
        int index = -1;

        if (scan.hasNextInt()) { 
            index = scan.nextInt() - 1;
            
            if (index < 0 || index >= cnt) {
                System.out.println("해당 상품 번호가 없습니다.");
                return;
            }
            
        } else {  
            String deleteName = scan.next();
            
            for (int i = 0; i < cnt; i++) {
                if (menu[i].getName().equals(deleteName)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("찾는 상품이 없습니다.");
                return;
            }
        }
        
//      // 삭제 : 찾은 위치부터 뒷번지를 앞번지로 옮기는 작업
//      for(int i=index; i<cnt-1; i++) {
//      	menu[i] = menu[i+1]; // 덮어쓰기
//      }
      
        // arraycopy를 이용한 방법 -> 속도가 빠름(성능이 우수)
	    // 배열 복사 : 기존 배열(menu)의 n번지부터 새배열(tmp)의 n번지부터 cnt 개수만큼 복사
        // 배열에서 상품 삭제 (덮어쓰기)
        int copyCnt = cnt - index - 1;
        if (copyCnt > 0) {
            System.arraycopy(menu, index+1, menu, index, copyCnt);
        }
        menu[--cnt] = null;  // 마지막 자리 null 처리 및 상품 개수 감소
        System.out.println("상품이 삭제되었습니다.");
    }
    
    // 상품 수정
    public void modifyProduct(Scanner scan) {
        if (cnt == 0) {
            System.out.println("수정할 상품이 없습니다.");
            return;
        }
        
        printProduct();
        System.out.print("수정할 상품 번호 또는 상품명을 입력하세요: ");
        
        int index = -1;

        if (scan.hasNextInt()) { 
            index = scan.nextInt() - 1;
            
            if (index < 0 || index >= cnt) {
                System.out.println("해당 상품 번호가 없습니다.");
                return;
            }
            
        } else {  // 문자로 입력되면 상품명으로 수정
            String searchName = scan.next();
            
            for (int i = 0; i < cnt; i++) {
                if (menu[i].getName().equals(searchName)) {
                    index = i; break;
                }
            }
            
            if (index == -1) {
                System.out.println("해당 상품명이 없습니다."); return;
            }
        }
        
        System.out.print("수정할 상품명: ");
        String newName = scan.next();
        
        System.out.print("수정할 가격: ");
        int newPrice = scan.nextInt();
        
        menu[index].setName(newName);
        menu[index].setPrice(newPrice);
        System.out.println("상품이 수정되었습니다.");
    }

}