package day06;

/* 객체지향 프로그램 4가지의 특징
  - 프로그램을 독립된 단위(객체)의 객체들을 모아서 관계를 맺어 처리하는 형태
  - 각각의 객체는 메시지를 주고 받으면서 데이처를 처리 
  - 메시지를 받을 경우(매개변수를 통해) / 메시지를 주는 경우 (return)
  - 추상화, 캡슐화(정보은닉), 상속, 다형성
  
 * 추상화(Abstraction) - 핵심적인(공통적인) 코드만 보여주기. 
  - 구현된 부분과 구현되지 않은 부분으로 분리
  - 개인(자식)이 구현해야 할 부분은 분리하여 처리
  
 * 캡슐화(Encapsulation) - 데이터 보호(정보은닉)
  - 멤버변수(private)를 숨기는 형태, 메서드로 접근
  - 멤버변수와 메서드를 하나로 묶어 처리하는 형태
  - 은닉화 : 객체의 내부의 정보를 숨겨 외부로 드러나지 않게 보호 하는 것
 
 * 상속(Inheritance) - 코드 재사용(확장)
  - 클래스를 상속받아 수정하면 중복 코드를 줄일 수 있음. 
  - 유지보수가 편함
  
 * 다형성(Polymorphism) - 객체 변환이 용이함.
  - 하나의 코드가 어러 객체의 형태로 구현되어 실행되는 것
  - 코드는 같은데 들어오는 객체에 따라 다른 실행결과를 얻을 수 있음.
  - 다형성을 잘 활용하면 유연하고, 확장성있는, 유지보수가 편리한 프로그램을 만들 수 있음. */

class Animal{ //공통적인 속성
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal{
	@Override
	public void move() {
		System.out.println("사람은 두발로 걷습니다.");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 네발로 어슬렁거립니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아다닙니다.");
	}
	public void flying() {
		System.out.println("독수리가 날카로운 눈으로 날아다니며 사냥합니다.");
	}
}

class Dog{
	public void move() {
		System.out.println("강아지가 아장아장 걷습니다.");
	}
}


public class Polymorphism01 {
	public static void main(String[] args) {
		// Human, Tiger, Eagle 객체 생성
		
		Human human = new Human();
		human.move();
		human.readBook();
		System.out.println("-------------");
		Tiger tiger = new Tiger();
		tiger.move();
		tiger.hunting();
		System.out.println("-------------");
		Eagle eagle = new Eagle();
		eagle.move();
		eagle.flying();
		
		System.out.println("--조상의 객체로 자식의 객체를 생성--");
		// 조상의 클래스로 자식의 객체를 생성 가능.
		// 조상에게 상속받은 메서드만 실행가능.
		
		//자식객체로 부모객체의 생성은 불가능
//		Human h = new Animal(); // 불가능.
		
		Animal hAnimal = new Human();
		hAnimal.move();
//		hAnimal.readBook(); //사용불가능.
		Animal tAnimal = new Tiger();
		tAnimal.move();
		Animal eAnimal = new Eagle();
		eAnimal.move();
		
		System.out.println();
		System.out.println("--다형성 메서드 예시--");
		Polymorphism01 ex01 = new Polymorphism01();
		
		// 부모의 객체로 생성이 되었기 때문에 당연히 가능.
		ex01.moveAnimal(eAnimal);
		ex01.moveAnimal(tAnimal);
		ex01.moveAnimal(hAnimal);
		
		// 자신의 객체로 생성되었다 하더라도 자동 형변환이 이루어져 출력가능.
		ex01.moveAnimal(eagle);
		ex01.moveAnimal(tiger);
		ex01.moveAnimal(human);
		
		Dog dog = new Dog();
		dog.move();
		//animal 클래스를 상속받고 있지 않기 때문에 불가능.
		//ex01.moveAnimal(dog); 
		System.out.println();
		System.out.println("--Animal 배열 생성 예시--");
		int cnt=0;
		Animal[] aniList = new Animal[5];
		
		aniList[cnt] = hAnimal;
		cnt++;
		aniList[cnt] = tAnimal;
		cnt++;
		aniList[cnt] = eAnimal;
		cnt++;
		
		for(int i=0; i<cnt; i++) {
			aniList[i].move();
		}
		
		System.out.println();
		System.out.println("--다운 케스팅 예시--");
		// Human클래스 객체에 Animal을 상속받은 Human 클래스 객체를 다운 케스팅한 예시
		Human h = (Human) hAnimal;
		h.readBook();
		
		//Human h1 = (Human)eAnimal;
		//h1.readBook(); //casting 오류
		//instanceof 연산자로 확인하여 실행
		
		System.out.println("--instanceof 연산자--");
		//instanceof : 객체가 해당 클래스의 형이 맞는지 확인
		System.out.println(tAnimal instanceof Human);
		System.out.println(tAnimal instanceof Tiger);
		System.out.println(tAnimal instanceof Eagle);
		
		Animal downCasingTest = eAnimal;
		if(downCasingTest instanceof Human) {
//			((Human) downCasingTest).readBook();
			Human testHuman = (Human)downCasingTest;
			testHuman.readBook();
		}else if(downCasingTest instanceof Tiger) {
			((Tiger) downCasingTest).hunting();
		}else if(downCasingTest instanceof Eagle) {
			((Eagle) downCasingTest).flying();
		}else {
			System.out.println("error");
		}

	}
	
	//다형성 예시 메서드(업케스팅 : 자동형변환 가능)
	public void moveAnimal(Animal animal) {
		animal.move();
		if(animal instanceof Human) {
			((Human) animal).readBook();
		}else if(animal instanceof Tiger) {
			((Tiger) animal).hunting();
		}else if(animal instanceof Eagle) {
			((Eagle) animal).flying();
		}else {
			System.out.println("error");
		}
	}
}