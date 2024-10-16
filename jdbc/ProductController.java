package jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	// Controller -> Service -> DAO -> DB
	// Controller 모든 메뉴 분기 처리
	
	private Scanner scan;
	private Service svc; // interface
	private boolean flag; // 종료 변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); // service interface 구현체(service) 연결
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--< 상품 관리 프로그램 >--");
			System.out.println
			("1. 상품 등록 | 2. 상품 목록 | 3. 상품 검색(상세 보기)\r\n"
		   + "4. 상품 수정 | 5. 상품 삭제 | 6. 종료");
			System.out.print("menu > ");
			
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1 : register(); break;
			case 2 : list(); break;
			case 3 : search(); break;
			case 4 : modify(); break;
			case 5 : delete(); break;
			case 6 : flag = false; System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못된 메뉴입니다."); break;
			}
		}
	}

	private void register() { // 상품 등록
		System.out.print("상품 이름 : ");
		String name = scan.next();
		scan.nextLine();
		System.out.print("상품 가격 : ");
		int price = scan.nextInt();
		scan.nextLine();
		System.out.print("상품 상세내역 : ");
		String madeby = scan.nextLine();
		
		Product p = new Product(name, price, madeby);
		// service 에게 p 객체 등록 요청 (메서드 작성
		// 1 row(s) affected 0.016 sec
		// isOk = 1(DB에 성공적으로 들어감) / isOk = 0(실패)
		
		int isOk = svc.insert(p);
		System.out.println("상품 등록 > " + (isOk > 0 ? "등록이 성공했습니다." : "등록이 실패했습니다."));
	}

	private void list() { // 상품 리스트
		// 매개변수는 없고, list 리턴
		List<Product> list = svc.getList();
		
		// 출력
		for(Product p : list) {
			System.out.println(p);
		}
	}

	private void search() { // 상품 검색
		// 특정 상품 검색 (세부내용 madeby / regdate)
		// pno가 필요
		// select * from product where pno = ?
		// pno 값을 입력 받아 매개변수로 전달, Product 객체 리턴
		System.out.print("검색할 번호 입력 > ");
		int pno = scan.nextInt();
		Product p = svc.getProduct(pno);
		System.out.println(p);
	}

	private void modify() { // 상품 수정
	    System.out.print("수정할 번호 입력 > ");
	    int pno = scan.nextInt();
	    scan.nextLine();
	    
	    System.out.print("수정할 상품 이름 > ");
	    String name = scan.nextLine();
	    
	    System.out.print("수정할 상품 가격 > ");
	    int price = scan.nextInt();
	    scan.nextLine();
	    
	    System.out.print("수정할 상품 상세 내역 > ");
	    String madeby = scan.nextLine();
	    
	    // pno를 이용해 수정할 상품 정보를 담은 객체 생성
	    Product p = new Product(name, price, madeby, pno);
	    
	    // svc.update() 호출하여 DB에 상품 정보 업데이트 시도
	    int isOk = svc.update(p);
	    System.out.println("상품 수정 > " + (isOk > 0 ? "수정 성공!" : "수정 실패"));
	}

	private void delete() { // 상품 삭제
	    System.out.print("삭제할 상품 번호 입력 > ");
	    int pno = scan.nextInt();
	    scan.nextLine(); 

	    int isOk = svc.delete(pno);

	    System.out.println("상품 삭제 > " + (isOk > 0 ? "삭제 성공!" : "삭제 실패"));
	}
}
