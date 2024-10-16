package day04;

class Animal {
	// 동물의 이름과 종류를 나타내는 클래스
	// 메서드 : 이름과 종류를 출력하는 메서드, 동물의 울음소리를 출력하는 메서드
	
	private String name;
	private String category;

	public Animal() {} // 기본생성자

	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	// 출력 메서드
	public void printInfo() {
		System.out.println("이름 : " + name + " | 종류 : " + category);
	}
	
	// 울음소리 출력 메서드
	public void howl() {
		System.out.print(name + "(" + category + ")의 울음 소리 : ");
		// 자식이 구현
	}
	
	
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

// Dog, Cat Animal 클래스를 상속받아 생성
// printInfo() / howl() : 오버라이딩 후 본인의 울음소리를 추가해서 출력

class Dog extends Animal {
	private String dogHowl = "멍멍!";
	
	@Override
	public void printInfo() {
		super.printInfo();
		super.howl();
		System.out.println(dogHowl);
	}

	public String getDogHowl() {
		return dogHowl;
	}

	public void setDogHowl(String dogHowl) {
		this.dogHowl = dogHowl;
	}
}

class Cat extends Animal {
	private String catHowl = "야옹~";
	
	@Override
	public void printInfo() {
		super.printInfo();
		super.howl();
		System.out.println(catHowl);
	}

	public String getCatHowl() {
		return catHowl;
	}

	public void setCatHowl(String catHowl) {
		this.catHowl = catHowl;
	}
}

class Tiger extends Animal {
	public Tiger(String name, String category) {
		super(name, category); // 부모생성자 호출
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println("어흥~!");
	}
}

public class Extends02 {
	public static void main(String[] args) {
	/* 오버라이딩 : 부모 클래스의 메서드를 재정의하여 사용하는 것
		- 부모클래스의 메서드와 선언부가 일치해야 함 { 구현만 재정의 가능 }
		- 접근제한자는 더 넓은 범위만 가능, 축소는 X 		*/
		
		Dog dog = new Dog();
		dog.setName("코코");
		dog.setCategory("강아지과");
		dog.printInfo();
		System.out.println();
		
		Cat cat = new Cat();
		cat.setName("나비");
		cat.setCategory("고양이과");
		cat.printInfo();
		System.out.println();
		
		Tiger tiger = new Tiger("랑이", "고양이과");
		tiger.printInfo();
		tiger.howl();

	}
}
