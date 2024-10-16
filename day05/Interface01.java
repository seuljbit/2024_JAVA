package day05;
/* 인터페이스 
- 추상메서드와 상수(final)로만 이루어진 것
- 구현해야 할 기능(메서드)을 선언만 해두는 역할
* 추상메서드 : 메서드의 선언부(이름과 매개변수)만 있고, 구현부가 없는 메서드
* 추상메서드가 포함되어있는 추상클래스 / 인터페이스 => 반드시 구현해야 객체 생성 가능
* 일종의 "계약" 같은 역할을 하며, 이 인터페이스를 구현하는 클래스는 계약된 메서드를 반드시 구현
* 인터페이스 키워드 : interface 
 ex) interface MyInterface {
	    void myMethod();  // 추상 메서드 (선언만 있고 구현은 없음)
	   }

* 추상클래스 : 대부분 상속을 하기 위해 사용
* 인터페이스 : 메뉴얼화 / 상속을 하기 위해 사용, '기능요약서'라고도 함.
* 상속 키워드 : extends, 구현 키워드 : implements
* 인터페이스는 메버변수를 포함하지 않기 때문에, 이 부분을 염두에 두고 메서드 정리

* 상속 : 다중 상속 불가능
* 구현 : 다중 구현 가능
* 상속 + 구현 동시에 가능 */

interface Power {
	void trunOn();
	void trunOff();
}

interface Remocon {
	void volUp();
	void volDown();
	void chUp();
	void chDown();
}
/* 상속 + 구현
 * class Tv extends A implements B {} */

class Tv implements Power, Remocon {
	private int vol;
	private int ch;

	@Override
	public void trunOn() {
		System.out.println("화면이 켜졌습니다.");
	}

	@Override
	public void trunOff() {
		System.out.println("화면이 꺼졌습니다.");
	}
	
	@Override
	public void volUp() {
		vol++;
		System.out.println("vol : " + vol);
	}
	
	@Override
	public void volDown() {
		vol--;
		System.out.println("vol : " + vol);
	}
	
	@Override
	public void chUp() {
		ch++;
		System.out.println("ch : " + ch + "번");
	}
	
	@Override
	public void chDown() {
		ch--;
		System.out.println("ch : " + ch + "번");
	}
}

public class Interface01 {
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		
		tv.trunOn();
		tv.chUp();
		tv.volUp();
		tv.volDown();
		tv.trunOff();
	}

}
