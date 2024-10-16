package day11;

public class Thread03 {

	public static void main(String[] args) {
		JoinTest thread1 = new JoinTest(1, 50);
		JoinTest thread2 = new JoinTest(51, 100);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = thread1.total + thread2.total;
		System.out.println("총합 : " + total);
	}
}

class JoinTest extends Thread {
	int start;
	int end;
	int total;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			System.out.println(i);
			this.total += i;
		}
	}
}