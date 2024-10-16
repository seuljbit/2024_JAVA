package day02;

public class Lotto {
	/* 로또 프로그램
	 * - menu -
	   1. 사용자 로또 번호 생성(수동) : 사용자가 직접 번호 입력
	   2. 사용자 로또 번호 생성(자동) : Random
	   3. 당첨 번호 입력(수동, 자동) : 사용자가 직접 입력
	   4. 당첨 확인 : 가장 마지막에 발행한 당첨번호로 확인
	   5. 역대 당첨번호 목록 확인
	   6. 종료
	   
	 * 로또는 상속을 하여 사용
	 * Lotto class => 사용자의 번호를 저장하는 클래스
	  - 회차 : 첫 발행부터 자동 증가 1회차 ex) 1회차 1 2 3 4 5 6
	  - 6자리 배열을 넣는 클래스(중복 x), 출력 
	 * LottoExtend class => Lotto를 상속 + 보너스 번호
	  - 회차 : 첫 발행부터 자동 증가 1회차 ex) 1회차 1 2 3 4 5 6 [7]
	 * LottoController => 처리  */
	
    public static void main(String[] args) {
        // 로또 번호 생성
        int lottoArr[] = new int[7]; // 당첨 번호 (6개 + 보너스 번호)
        int userArr[] = new int[6]; // 사용자 로또 번호

        Lotto lotto = new Lotto();

        lotto.generateNumbers(lottoArr);
        lotto.generateNumbers(userArr);

        System.out.print("당첨 번호: ");
        lotto.printNumber(lottoArr, true);

        System.out.print("유저 번호: ");
        lotto.printNumber(userArr, false);

        lotto.lottoRank(lottoArr, userArr);
    }

    /* 배열을 매개변수로 받아 1~45까지의 랜덤수를 채워 생성
     * 조건 : 중복 x, 당첨번호 마지막 자리 bouns 번호
     * 리턴 x, main에 있는 배열 채우기 */
    public void generateNumbers(int[] array) {
        int i = 0;  // 배열 인덱스를 위한 변수
        while (i < array.length) {
            int lottoNum = (int) (Math.random() * 45) + 1; 
            if (!contains(array, lottoNum)) { 
                array[i] = lottoNum;
                i++;  
            }
        }
    }

    /* 배열과 값을 주고 같은지 아닌지 확인하는 메서드
     * 배열에 값이 있으면 true / 없으면 false */
    public boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        } 
        return false;
    }

    /* 배열(매개변수)의 값을 출력하는 메서드
     * 당첨 번호 : 1 2 3 4 5 6 [7] 당첨번호 출력 방식
     * 유저 번호 : 1 2 3 4 5 6 */
    public void printNumber(int[] array, boolean isLotto) {
        for (int i = 0; i < array.length; i++) {
            if (isLotto && i == array.length - 1) { // 보너스 번호 괄호 넣기
                System.out.print("[" + array[i] + "] ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    /* 등수 매기기 */
    public void lottoRank(int[] lotto, int[] user) {
        int count = 0;
        StringBuilder matchNum = new StringBuilder(); 
        boolean bonus = false;

        for (int i = 0; i < user.length; i++) {
            if (contains(lotto, user[i])) {
                count++;
                matchNum.append(user[i]).append(" "); 
            }
        }

        bonus = contains(user, lotto[6]);  // 보너스 번호 확인

        switch (count) {
            case 6 : System.out.println("1등 당첨!"); break;
            case 5 :
                if (bonus) {
                    System.out.println("2등 당첨!");
                } else {
                    System.out.println("3등 당첨!");
                } break;
            case 4 : System.out.println("4등 당첨!"); break;
            case 3 : System.out.println("5등 당첨!"); break;
            default : System.out.println("꽝!"); break;
        }
        System.out.println("일치한 번호: " + matchNum.toString() + "(" + count + "개 일치)");
    }
}