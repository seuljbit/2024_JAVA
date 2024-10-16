package sale;

import java.util.Scanner;

public class SaleMain {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	SaleController sc = new SaleController();
        int menu;
        
        do {
            System.out.println
            ("\n1) 메뉴 추가     | 2) 메뉴 삭제 | 3) 가격 수정"
            + "\n4) 메뉴 보기     | 5) 주문하기  | 6) 영수증 출력"
            + "\n7) 전체 판매 내역 | 8) 종료");
            System.out.print("menu > ");
            menu = scan.nextInt();
            
            System.out.println();
            
            switch(menu) {
            case 1 : sc.add(scan); break;
            case 2 : sc.delete(scan); break;
            case 3 : sc.update(scan); break;
            case 4 : sc.printMenu(); break;
            case 5 : sc.orderPick(scan); break;
            case 6 : sc.orderPrint(scan); break;
            case 7 : sc.totalOrderPrint();break;        
            case 8 : System.out.println("키오스크를 종료합니다."); break;
            default : System.out.println("잘못된 메뉴입니다.");
            }
        } while(menu != 8);
    }
}