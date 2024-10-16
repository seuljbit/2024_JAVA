package day11;

public class Thread01 {

	public static void main(String[] args) {
		/* Thread(쓰레드) : 실제 작업을 수행하는 단위
		  - 실제 cpu가 작업을 처리하는 단위
		  - 프로그램에 실행되면 OS로부터 메모리를 할당 받아 process의 상태됨
		  - 하나의 process는 하나 이상의 Thread를 가지게 됨
		  - multi-thread : 여래 개의 thread가 동시에 수행되는 프로그램
		  - CPU는 시간을 잘게 쪼개서 thread를 번갈아 수행(시분할 처리)
		  - 사용자들은 동시에 처리되는 듯한 효과를 가지게 됨
		  - 각자 자신만의 작업공간을 가짐(context)
		  - 여러 thread가 공유하는 자원을 사용하려고 경쟁이 발생
		  - 경쟁이 발생하는 구역 critical section(임계영역)
		  - 임계 영역에서 교착상태(deadlock)가 발생하지 않도록 동기화(순사적 수행) 구현하여 오류를 막음
		  
		* Thread를 구현하는 2가지 방법
		 1. Thread 클래스를 상속하여 만들기
		 2. Runnable 인터페이스 구현하여 만들기
		 -> 자바는 다중상속을 허용하지 않기 때문에 다른 클래스를 상속 중이라면 2번으로 구현  */
		
		// 현재 실행 중인 스레드
		System.out.println(Thread.currentThread().getName());
		
		MyThread th = new MyThread();
		th.start();
		
		MyThread th2 = new MyThread();
		th2.start();

		System.out.println("thread end!");
	}

}

class MyThread extends Thread {
	
	// 반드시 run()이라는 메서드를 구현해야 함
	@Override
	public void run() {
		for(int i=0; i<=500; i++) {
			System.out.println(i + "번째 thread > " + getName());
		}
	}
}
