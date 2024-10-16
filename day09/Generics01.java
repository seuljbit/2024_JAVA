package day09;

import java.util.ArrayList;
import java.util.List;

public class Generics01 {
	public static void main(String[] args) {
		/* 제네릭(Generics) : 데이터의 타입을 나중에 확정하는 기법
		 * 클래스나 메서드를 선언할 때 어떤 데이터가 올 지 확인이 없다면 제네릭 타입으로 구현
		   -> 나중에 객체 생성 시 타입을 확정하여 구현
		 * 객체의 타입을 컴파일할 때 체크할 수 있어서 안정성을 해치지 않는 선에서 형변환이 가능한 기법
		   -> 안정성? 의도하지 않은 타입의 객체 저장을 막는 것 */
		
		// 객체 구현 시 타입을 적어서 처리
		List<Sale<Integer, String>> list = new ArrayList<>();
		
		int id = 1;
		String name = "햄버거";
		int price = 5000;
		
		Sale sale = new Sale(id, name, price);
		list.add(sale);
		list.add(new Sale(2, "콜라", 1500));
		
		int sum = 0;
		int idSum = 0;
		
		for(Sale s : list) {
			idSum += (int)s.getId();
			sum += s.getPrice();
			System.out.println(s);
		}
		
		System.out.println(list); // [Sale [id=1, menu=햄버거, price=5000], Sale [id=2, menu=콜라, price=1500]]
		System.out.println("id 합계 : " + idSum); // id합계 : 3
		System.out.println("합계 : " + sum); // 합계 : 6500
	}
}
