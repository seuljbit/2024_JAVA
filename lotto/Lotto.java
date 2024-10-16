package lotto;
import java.util.Random;
import java.util.Arrays;
/* Lotto class => 사용자의 번호를 저장하는 클래스
   - 회차 : 첫 발행부터 자동 증가 1회차 
     ex) 1회차 1 2 3 4 5 6
   - 6자리 배열을 넣는 클래스(중복 x), 출력  */

public class Lotto {
    private int[] numbers = new int[6];  // 로또 6자리 번호 저장
    public Lotto() {}

    // 로또 번호 생성 (중복되지 않도록)
    public void generateNumbers() {
        int i = 0;
        while (i < numbers.length) {
            int num = new Random().nextInt(45)+1;
            if (!contains(num)) {
                numbers[i++] = num;
            }
        }
        Arrays.sort(numbers);  // 번호를 오름차순으로 정렬
    }

    // 배열 안에 값이 있는지 확인하는 메서드
    public boolean contains(int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return true;  // 배열 안에 값이 있으면 true 반환
            }
        }
        return false;  // 배열 안에 값이 없으면 false 반환
    }

    // 번호 출력
    public void printNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}