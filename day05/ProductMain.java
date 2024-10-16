package day05;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        // 키오스크 생성
        // 1. 전체 상품 리스트 | 2. 상품 등록 | 3. 상품 삭제 | 4. 상품 수정 | 5. 종료
        
        ProductController productController = new ProductController();
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        
        do {
            System.out.println
            ("\n1) 전체 상품 리스트 | 2) 상품 등록 | 3) 상품 삭제 | 4) 상품 수정 | 5) 종료");
            System.out.print("menu > ");
            menu = scan.nextInt();
            
            switch(menu) {
                case 1 : productController.printProduct(); break;
                case 2 : productController.insertProduct(scan); break;
                case 3 : productController.deleteProduct(scan); break;
                case 4 : productController.modifyProduct(scan); break;
                case 5 :  System.out.println("키오스크 종료!!");  break;
                default : System.out.println("잘못된 메뉴입니다.");
            }
        } while(menu != 5);
        
        scan.close();
        
        System.out.println("-----");
        int[] array = {1, 2, 3, 4, 5};
        int indexToDelete = 2;  // 3을 삭제하고 나머지를 앞으로 이동

        System.arraycopy(array, indexToDelete + 1, array, indexToDelete, array.length - indexToDelete - 1);
        // (array, indexToDelete + 1 (원본 배열의 3번째)(복사된 값 array = {4, 5}),
        //  array, indexToDelete(복사될 배열의 2번째 자리, 시작할 값 = 3), array.length - indexToDelete - 1 (2));
        
        
        // array[3]부터 array[2]로 복사, 2개의 요소 복사

        // 결과: array = {1, 2, 4, 5, 5}

    }
}