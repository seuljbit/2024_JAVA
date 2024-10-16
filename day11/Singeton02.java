package day11;

class Counter {
	private int count;
	private static Counter instance; // 내 객체를 저장하는 메버변수(static)

	// 생성자 private
	private Counter() { count = 0; }

	// 싱글톤 인스턴스(1개)를 반환하는 메서드
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}

	// count 가 하나 올라가는 메서드 생성(countMethod())
	public int countMethod() {
		count++;
		return this.count;
	}
}

public class Singeton02 {
	public static void main(String[] args) {
		// Counter 객체를 2개 생성하여 각각 countMenthod() 호출
		// 1개의 객체가 공유되기 때문에 1개의 변수만 변화
		
		// Counter 객체를 2개 생성하려고 하지만 실제로는 하나의 인스턴스만 공유됨
		Counter counter1 = Counter.getInstance();
		Counter counter2 = Counter.getInstance();

		// 각 객체에서 countMethod 호출 (실제로는 하나의 객체가 공유됨)
		System.out.println("c1 > " + counter1.countMethod()); // Count: 1
		System.out.println("c1 > " + counter1.countMethod()); // Count: 2
		System.out.println("c1 > " + counter1.countMethod()); // Count: 3
		System.out.println("c1 > " + counter1.countMethod()); // Count: 4
		System.out.println("c2 > " + counter2.countMethod()); // Count: 5
		System.out.println("c2 > " + counter2.countMethod()); // Count: 6
		System.out.println("c2 > " + counter2.countMethod()); // Count: 7
	}
}
