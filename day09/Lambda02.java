package day09;

import java.util.HashMap;

public class Lambda02 {
	public static void main(String[] args) {
		// map을 forEach로 출력
		HashMap<String, Integer> map = new HashMap<>();
		map.put("김민지", 78);
		map.put("팜하니", 53);
		map.put("강혜린", 98);
		map.put("다니엘", 85);
		map.put("이혜인", 66);
		map.put("유지민", 91);
		map.put("김민정", 45);
		map.put("이현서", 30);

		// Consumer : 값이 1개 / BiConsumer : 값이 2개
		map.forEach((x, y) -> {
			System.out.println(x + ") " + y);
		});
		
		Number sum = (a, b) -> { // 함수 구현
			return a + b;
		};
		
		int total = sum.add(50, 30);
		System.out.println(total);
	}
}

// 함수형 인터페이스 생성
// 메서드가 1개여야만 함
@FunctionalInterface
interface Number {
	int add(int a, int b);
//	int sub(int a, int b); // 메서드가 2개면 error
}
