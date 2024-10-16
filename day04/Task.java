package day04;

import java.util.Scanner;

/* Product 클래스 생성 : 상품을 등록하는 클래스
 * 멤버변수 : 상품명(name), 가격(price)
 * 메서드 : 상품을 추가하는 메서드, 상품을 출력하는 메서드(toString 이용)
   ex) 사탕 : 500원
   	   과자 : 2000원
       젤리 : 1000원 */

class Product {
	private String name;
	private String price;
	
	// 생성자
	public Product(String name, String price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " : " + price + "원";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}

public class Task {
	public static void main(String[] args) {
	/* 상품 10개를 등록할 수 있는 배열 생성
	 * 스캐너를 이용하여 상품 등록
	 * 등록한 상품 출력
	 * 상품을 등록하시겠습니까? (y/n)		*/	
		
		// 상품 10개를 등록할 수 있는 배열 생성
		Product products[] = new Product[10];
		Scanner scan = new Scanner(System.in);
		int count = 0;

		while (count < products.length) {
			System.out.print("상품을 등록하시겠습니까?(y/n): ");
			String answer = scan.nextLine();
			
			if (answer.equals("y")) {
				System.out.print("상품명: ");
				String productName = scan.nextLine();
				
				System.out.print("가격: ");
				String productPrice = scan.nextLine();

				products[count] = new Product(productName, productPrice);
				count++;
			} else if (answer.equals("n")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}

		System.out.println("전체 상품 목록:");
		for (int i=0; i<count; i++) {
			System.out.println((i+1) + ". " + products[i].toString());
		}

		scan.close();
	}
}