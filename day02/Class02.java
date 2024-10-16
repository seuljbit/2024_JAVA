package day02;

public class Class02 {
	/* 생성자 : 객체를 생성하기 위해 객체의 초기화를 담당
	 * Car car1 = new Car();	=> 클래스 객체명 = new 생성자();
	 * 생성자는 여러 개 만들 수 있음(생성자 오버로딩)
	 * 생성자명은 클래스명과 동일
	 * 생성자가 하나도 없는 경우는 기본 생성자를 자동으로 생성	
	 * 생성자를 하나라도 생성하면 기본 생성자는 주지 않음
	 * 생성자를 사용자 지정으로 생성하려면 기본 생성자도 같이 생성해야 함
	 * 생성자 오버로딩 조건(매개변수 개수가 달라야 함 || 매개변수 타입이 달라야 함)
	 * 생성자 호출 가능. (생성자 내에서만)
	 * this : 내 클래스의 요소라는 것을 나타내는 키워드		
	  
	 * 추가 설명:
	 * - 생성자는 객체가 생성될 때 자동으로 호출되며, 필수적으로 객체의 초기화를 수행해야 함
	 * - "this" 키워드는 해당 객체 자신의 인스턴스를 참조하는 데 사용되며, 특히 매개변수 이름과 멤버변수 이름이 동일할 때 주로 사용됨
	 * - 생성자 오버로딩을 통해 다양한 방식으로 객체를 초기화할 수 있으며, 생성자마다 서로 다른 매개변수를 받을 수 있음		*/
	
	public static void main(String[] args) {
		Car car1 = new Car(); // 기본 생성자로 객체 생성
		car1.setName("Porsche"); // 이름 설정
		car1.setColor("yellow"); // 색상 설정
		car1.setYear("2023"); // 제조년도 설정
		car1.carInfo(); // 자동차 정보 출력
		
		// 시동 관련 메서드 호출
		car1.power(); // 시동이 켜졌습니다.
		car1.power(); // 시동이 꺼졌습니다.
		car1.power(); // 시동이 켜졌습니다.
		
		// 속도 관련 메서드 호출
		car1.speedDown(); // 속도를 내릴 수 없습니다.
		car1.speedUp(); // 속도 증가
		car1.speedUp(); // 속도 증가
		car1.speedDown(); // 속도 감소
		car1.speedUp(); // 속도 증가
		car1.speedUp(); // 속도 증가
		car1.speedDown(); // 속도 감소
		car1.speedDown(); // 속도 감소
		
		// 주행 중 시동 끄기 시도
		car1.power(); // 주행 중입니다.
		car1.speedDown(); // 속도 감소
		car1.speedDown(); // 속도 감소
		
		// 속도가 0이 된 후 시동 끄기
		car1.power(); // 시동이 꺼졌습니다.
		car1.speedDown(); // 시동이 꺼져있습니다.
		
		Car car2 = new Car("BMW");
		car2.carInfo();
		
		Car car3 = new Car("Ferrari", "gray");
		car3.carInfo();
		
		Car car4 = new Car("Lamborghini", "red", "2023");
		car4.carInfo();
	}
}


// Car 클래스
// 멤버변수 : name, color, year, power, speed => private 선언 (getter / setter 생성)
// sonata(black/2024) => 출력 메서드
// power : 시동 상태 나타내는 메서드(true / false)
// spped(10씩 증가,감소) : 속도 up(200이면 올릴 수 없음) / down 메서드(0이 되면 내릴 수 없음)

class Car {
	private String name; // 필수: 자동차의 이름을 나타냄
	private String color; // 선택: 자동차의 색상
	private String year; // 선택: 제조 연도
	
	private boolean power = false; // 시동 상태 (true = 켜짐, false = 꺼짐)
	private int speed; // 현재 속도
	
	// 멤버변수 -> 생성자 -> 메서드 -> getter / setter
	// 생성자 위치
	// 객체를 생성할 때 초기값 지정
	// 생성자의 접근제한자는 반드시 public이어야 함
	// 생성자명은 반드시 클래스명과 같아야 함
	// 생성자는 메서드와 달리 return 타입이 없음
	
	// 생성자 호출은 단 한 번 객체 생성시만 가능
	public Car() { // 기본 생성자
		// 추가 설명: 기본 생성자는 매개변수가 없고, 따로 초기화를 하지 않음.
	}

	public Car(String name) { // 이름만 넣는 생성자
		this.name = name;
	}
	public Car(String name, String color) { // 이름, 제조일을 넣는 생성자
		this.name = name;
		this.color = color;
	}
	
	// 생성자 호출 : 생성자 내에 다른 생성자의 값과 완전히 동일한 값이 있을 경우 사용 가능
	public Car(String name, String color, String year) { 
		this.name = name;
		this.color = color;
		this.year = year;
	}
	
	public Car(String name, String color, String year, boolean power, int speed) { // 모든 매개변수를 가지는 생성자
		this(name, color, year); // 생성자 호출 : 반드시 첫 줄에 작성해야 함
//		this.color = color;
//		this.year = year;
		this.power = power;
		this.speed = speed;
	}

	// carInfo(): 자동차 정보를 출력하는 메서드
	public void carInfo() {
		System.out.println("< 자동차 정보 >");
		System.out.println("차종 : " + this.name);
		System.out.println("색상 : " + this.color);
		System.out.println("제조일 : " + this.year);
		System.out.println();
	}
	
	// power(): 시동을 켜거나 끄는 메서드, 속도가 0이 아니면 시동을 끌 수 없음
	public void power() { 
		if(this.speed!=0) {
			System.out.println("주행 중입니다."); // 추가 설명: 주행 중일 때는 시동을 끌 수 없음을 알림
		} else {
			this.power =! this.power; // 시동 상태 변경
			if(this.power == false) {
				System.out.println("시동이 꺼졌습니다."); // 시동이 꺼진 상태
			} else {
				System.out.println("시동이 켜졌습니다."); // 시동이 켜진 상태
			}
		}
	}
	
	// speedUp(): 속도를 증가시키는 메서드, 최대 속도는 200km
	public void speedUp() {
	    if (power == true) { // 시동이 켜져 있어야 속도를 올릴 수 있음
	        if (this.speed >= 200) {
	            System.out.println("허용 속도 범위를 초과하였습니다.");
	        } else {
	            this.speed += 10;
	            if (this.speed > 200) {
	                this.speed = 200; // 최대 속도는 200으로 제한
	            }
	            System.out.println("속도 UP! 현재 속도 : " + this.speed + "km");
	        }
	    } else {
	        System.out.println("시동이 꺼져있습니다.");
	    }
	}
	
	// speedDown(): 속도를 감소시키는 메서드, 속도가 0이면 더 이상 내릴 수 없음
	public void speedDown() {
	    if (power == true) { // 시동이 켜져 있어야 속도를 줄일 수 있음
	        if (this.speed == 0) {
	            System.out.println("속도를 내릴 수 없습니다.");
	        } else {
	            this.speed -= 10; 
	            if (this.speed < 0) {
	                this.speed = 0; // 최소 속도는 0으로 제한
	            }
	            System.out.println("속도 DOWN! 현재 속도 : " + this.speed + "km");
	        }
	    } else {
	        System.out.println("시동이 꺼져있습니다.");
	    }
	}
	
	// getter와 setter 메서드들: 멤버변수에 접근하기 위한 메서드들

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}