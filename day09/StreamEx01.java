package day09;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행 비용 : 15세 이상 -> 100만원, 미만은 50만원
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용 계산 -> 출력
		 * 2. 고객 명단 출력
		 * 고객 클래스 생성, ArrayList로 고객 관리
		 ex) 이름 : 신형만, 나이 : 40, 비용 : 100
		     이름 : 봉미선, 나이 : 38, 비용 : 100
		     이름 : 신짱구, 나이 : 10, 비용 : 50
		     이름 : 신짱아, 나이 : 5, 비용 : 50
		     총 여행 경비 : (sum)
		 * 20세 이상 고객 명단 => 이름 순으로 정렬 	*/

		ArrayList<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer("신형만", 31));
		customers.add(new Customer("봉미선", 29));
		customers.add(new Customer("신짱구", 5));
		customers.add(new Customer("신짱아", 3));
		customers.add(new Customer("흰둥이", 1));
		
		customers.stream().forEach(System.out::println);
		
		int sum = customers.stream()
				.mapToInt(n -> n.getPrice())
				.sum();
		System.out.println("총 여행 경비  | " + sum + "만원");
		System.out.println();
		
		// Comparator 구현이 없는 경우
		System.out.println("--- 20세 이상 고객 명단 ---");
		customers.stream()
		.filter(n -> n.getAge() >= 20)
		.sorted(new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(System.out::println);
		
//		Collections.sort(customers);
//		for(customer tmp)
	}
}
