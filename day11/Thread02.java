package day11;

public class Thread02 {

	public static void main(String[] args) {
		// 2. runnable 구현 방법
		System.out.println(Thread.currentThread().getName());
	}

}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 500; i++) {
			System.out.println(i + "번째 thread > " + Thread.currentThread());
		}
	}
}