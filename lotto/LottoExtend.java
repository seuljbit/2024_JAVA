package lotto;
/* LottoExtend class => Lotto를 상속 + 보너스 번호
	- 회차 : 첫 발행부터 자동 증가 1회차 ex) 1회차 1 2 3 4 5 6 [7] */

public class LottoExtend extends Lotto {
    private int bonusNumber;  // 보너스 번호
    private static int roundCounter = 1; // 회차 자동 증가
	private int round;  // 현재 회차
	
    public LottoExtend() {
        this.round = roundCounter++;
    }

    public void generateBonusNumber() {
        do {
            bonusNumber = (int) (Math.random() * 45) + 1;
        } while (contains(bonusNumber));
    }

    @Override
    public void printNumbers() {
    	System.out.print("<" + round + "회차> ");
        super.printNumbers(); // 기본 로또 번호 출력
        System.out.println("[" + bonusNumber + "]");
    }

    
	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public static int getRoundCounter() {
		return roundCounter;
	}

	public static void setRoundCounter(int roundCounter) {
		LottoExtend.roundCounter = roundCounter;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
}