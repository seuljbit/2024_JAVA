package day04;
/* 추상 클래스 : 미완성 클래스, 추상메서드를 포함하는 클래스
 * 추상 클래스 요소 : 멤버변수 + 상수(final) + 일반메서드 + 추상메서드
 * 추상 클래스 : 객체 생성 x, 반드시 추상메서드를 구현하여 완성해야 객체 생성
 * 추상 메서드 : 메서드의 선언부만 있고, 구현이 없는 메서드
 * 추상 키워드 : abstract
 * abstract class Animal {}
 * abstract public void howl(); // 추상메서드
  - 추상클래스에 abstract 키워드는 반드시 포함해야 함
  - 인터페이스는 추상메서드를 포함해도 abstract 키워드 생략 가능
  - 추상클래스는 상속을 하기 위한 부모클래스를 생성할 때 사용
  - 상속받은 클래스에 추상메서드가 있다면 반드시 구현 */

abstract class Animal1 { // 추상클래스
	protected String name;
	protected String category;
	public Object setName;

	public void printInfo() { // 일반 메서드
		System.out.println(name + "(" + category + ")");
	}
	
	abstract public void howl();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}


class Dog1 extends Animal1 {
	private String eat; // 먹이종류
	
	public Dog1(String name, String category) {
		// protected 라서 바로 구현 가능
		super.name = name;
		super.category = category;
	}
	
	@Override
	public void howl() {
		System.out.println("울음소리 > 멍멍!");
	}
	
	public void eating(String eat) {
		this.eat = eat;
		System.out.println(name + "가 좋아하는 음식 : " + eat);
	}

	@Override
	public void printInfo() {
		super.printInfo();
	}

	public String getEat() {
		return eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
	}
}

public class Abstract01 {
	public static void main(String[] args) {
		Dog1 dog = new Dog1("멍멍이", "개과");
		
		dog.printInfo();
		dog.howl();
		dog.eating("뼈다귀");
	}
}
