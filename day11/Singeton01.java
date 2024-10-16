package day11;

public class Singeton01 {

	public static void main(String[] args) {
		/* 디자인 패턴 : 개발자들이 개발 과정에서 하나의 패턴으로 묶어놓은 코드 조합
		 * http://refactoring.guru/ko/design-patterns
		 * 디자인 패턴 중 하나
		 * 싱글톤 : 단 1개만 존재해야하는 객체를 생성하여 공유하고자 할 때 사용 */
		
		// Singeton 객체 생성
		// static 메서드 / 멤버변수는 클래스명으로부터 바로 접근
		Singeton s = Singeton.getInstance();
		Singeton s1 = Singeton.getInstance();
		
		// 하나의 객체를 공유(주소가 같음)
		System.out.println(s); // day11.Singeton@3ac3fd8b
		System.out.println(s1);
	}
}

class Singeton {
	// 단 1개만 존재하기 위해 객체의 인스턴스 생성(공유)
	private static Singeton instance;
	// 생성자를 통해 객체 생성을 막기 위해 생성자를 private 설정
	private Singeton() {}
	
	// getInstance() 메서드를 사용하여 instance 를 생성, 리턴
	// instance가 있으면 기존 instance 를 리턴
	// instance가 없으면 새로 생성해서 리턴
	public static Singeton getInstance() {
		if(instance == null) {
			instance = new Singeton();
		}
		return instance;
	}
}