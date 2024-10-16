package sale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleController {
	private int orderNum;
	private int menuId;
	private int orderListindex;
	
	private List<Menu> menu = new ArrayList<>();
//	private List<Order> order = new ArrayList<>();
	private List<OrderList> orderList = new ArrayList<>();
	
	public void addMenu() { // 기본 메뉴 추가 메서드
		menu.add(new Menu(++menuId, "김치찌개", 9000));
		menu.add(new Menu(++menuId, "된장찌개", 9000));
		menu.add(new Menu(++menuId, "순두부찌개", 9000));
		menu.add(new Menu(++menuId, "제육볶음", 10000));
		menu.add(new Menu(++menuId, "오징어볶음", 10000));
	}
	
	public void add(Scanner scan) { // 메뉴추가
		this.menuId++;
		
		System.out.println("메뉴명 / 가격 >");
		String menu = scan.next();
		int price = scan.nextInt();
		this.menu.add(new Menu(menuId, menu, price));
		System.out.println("추가 완료!!");
	}
	
	public void delete(Scanner scan) {
		// 메뉴삭제 : remove(index), 
		// remove(object) : 하나의 객체 요소로 그 객체가 전체 일치라고 볼 수 없음. 
		// equals 명령어 자체를 수정하면 가능.
		System.out.println("삭제할 메뉴 번호 >");
		int delMenu = scan.nextInt();
		
		boolean ok = menu.remove(new Menu(delMenu));
		if(ok) {
			System.out.println("메뉴가 삭제되었습니다.");
		} else {
			System.out.println("해당하는 번호의 메뉴가 없습니다.");
		}
		
//		for(int i=0; i<menu.size(); i++) {
//			if(menu.get(i).getMenuId() == delMenu) {
//				menu.remove(i); //index로 삭제
//				//menu.remove(menu.get(i)); //object로 지우기
//				System.out.println("삭제 완료");
//				return;
//			}
//		}
//		System.out.println("찾는 메뉴가 없습니다.");
	}
	
	public void update(Scanner scan) { // 메뉴 수정 : remove => add / set(index, object)
		System.out.print("수정할 메뉴 번호 >");
		int modMenu = scan.nextInt();
		
		System.out.print("수정 가격 > ");
		int modPrice = scan.nextInt();
		
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getMenuId() == modMenu) {
//				Menu modObject = menu.get(i);
//				modObject.setPrice(modPrice);
//				menu.set(i, modObject);
				menu.get(i).setPrice(modPrice); //해당 객체의 가격만 수정
				System.out.println("수정 완료!");
				return;
			}
		}
		System.out.println("찾는 메뉴가 없습니다.");
	}
	
	public void printMenu() { // 전체 메뉴 출력 메서드
		System.out.println("--- menu ---");
		for(Menu m : menu) {
			System.out.println(m);
		}
		System.out.println("-------------");
	}
	
	public void orderPick(Scanner scan) { // 주문
		// 메뉴번호와 수량을 입력받아 / order 객체를 생성 후 / orderLsit 추가
		// order 객체를 생성 필요한 메뉴명, 가격 menuList 찾아와야 함
		
		this.orderList.add(new OrderList((orderListindex+1))); //가장 마지막에 
		int or = -1;
		
		do { 
			System.out.println("주문메뉴번호 >");
			int pickMenu = scan.nextInt();
			System.out.println("수량 >");
			int count = scan.nextInt();
			
			Menu pick = null;
			
			for(int i=0; i<menu.size(); i++) {
				if(menu.get(i).getMenuId() == pickMenu) {
					pick = menu.get(i); break; // 주문한 메뉴명과 가격을 리턴
				}
			}
		
			if(pick == null) {
				System.out.println("주문번호가 없습니다."); return;
			}
			this.orderNum++;
			
			Order order = new Order(pickMenu, pick.getMenuName(), pick.getPrice(), count, orderNum);
			this.orderList.get(orderListindex).addOrder(order);
			
			System.out.println("주문여부(1/0) >");
			or = scan.nextInt();
		} while(or == 1);
				
		orderListindex++;
		System.out.println("주문 완료~!!");
	}
	
	public void orderPrint(Scanner scan) { // 주문 출력
		int sum = 0;
		System.out.println("--- 주문 내역 ---");
		
		for(Order o : orderList.get(orderListindex-1).getOrder()) {
			sum+= o.getTotalPrice();
			o.orderPrint();
		}

		System.out.println("총 지불 금액 : " + sum);
		System.out.println("--------------");
	}
	
	public void totalOrderPrint() {
		System.out.println("준비 중입니다...");
		for(OrderList o : orderList) {
			System.out.println(o);
		}
	}
}