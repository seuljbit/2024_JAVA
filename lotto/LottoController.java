package lotto;
import java.util.Scanner;

public class LottoController {
    private LottoExtend[] lottoHistory = new LottoExtend[100]; 
    private int historyIndex = 0;  

    // 사용자 로또 번호 수동 입력
    public void inputUserLotto(Lotto userLotto, Scanner scan) {
        System.out.println("로또 번호 6개를 입력하세요 (1~45, 중복 x)");

        int[] userNumbers = new int[6];  // 임시 배열에 사용자 번호 저장
        int num; // 사용자가 입력할 번호

        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.print((i + 1) + "번째 번호 : ");
                num = scan.nextInt();

                if (num < 1 || num > 45) {
                    System.out.println("1에서 45 사이의 숫자를 입력해 주세요.");
                } else if (contains(userNumbers, num, i)) { 
                    System.out.println("중복된 숫자입니다. 다시 입력해 주세요.");
                } else { break; }
            }
            userNumbers[i] = num; 
        }
        userLotto.setNumbers(userNumbers);  
        
        System.out.println("사용자 로또 번호(수동)가 생성되었습니다. ");
        System.out.print("사용자 로또 번호 : ");
        userLotto.printNumbers(); 
        System.out.println();
    }

    private boolean contains(int[] array, int value, int limit) {
        for (int i = 0; i < limit; i++) {
            if (array[i] == value) {
                return true;  
            }
        } return false;
    }

    // 로또 당첨 번호 자동 생성 및 보너스 번호 설정
    public void generateLotto() {
        LottoExtend prizeLotto = new LottoExtend();
        prizeLotto.generateNumbers();
        prizeLotto.generateBonusNumber();
        lottoHistory[historyIndex++] = prizeLotto;
        
        System.out.println("당첨 번호가 생성되었습니다.");
    }

    // 마지막 당첨 번호 확인
    public void printLastLotto() {
        if (historyIndex == 0) {
            System.out.println("아직 당첨 번호가 생성되지 않았습니다.");
        } else {
            lottoHistory[historyIndex - 1].printNumbers();
        }
    }

    // 역대 당첨 번호 목록 출력
    public void printLottoHistory() {
        if (historyIndex == 0) {
            System.out.println("아직 기록된 당첨 번호가 없습니다.");
        } else {
            for (int i = 0; i < historyIndex; i++) {
                lottoHistory[i].printNumbers();
            }
        }
    }

    // 당첨 확인
    public void checkLottoResult(Lotto userLotto) {
        if (historyIndex == 0) {
            System.out.println("당첨 번호가 없습니다.");
            return;
        }

        LottoExtend lastLotto = lottoHistory[historyIndex - 1];
    	int[] userArr = userLotto.getNumbers(); 
        int matchCount = 0;
        boolean bonusMatch = false;
        StringBuilder matchNums = new StringBuilder(); 


        // 사용자 로또 번호와 당첨 번호 비교
        for (int i = 0; i <  userArr.length; i++) {
            int Usernum = userArr[i];
            if (lastLotto.contains(Usernum)) {
                matchCount++;
                matchNums.append(Usernum).append(" ");  // 맞춘 번호 추가
            }
        }

        // 보너스 번호 일치 여부 확인
        if (userArr[userArr.length - 1]
        		== lastLotto.getBonusNumber()) {
            bonusMatch = true;
        }

        System.out.print("결과 : ");
        switch (matchCount) {
            case 6 : System.out.println("1등 당첨!"); break;
            case 5:
                if (bonusMatch) {
                    System.out.println("2등 당첨!");
                } else {
                    System.out.println("3등 당첨!");
                } break;
            case 4: System.out.println("4등 당첨!"); break;
            case 3: System.out.println("5등 당첨!"); break;
            default: System.out.println("꽝!"); break;
        }
        

        // 사용자 번호 출력
        System.out.print("사용자 번호 : ");
        userLotto.printNumbers();
        System.out.println();

        // 당첨 번호 출력
        System.out.print("로또 당첨 번호 : ");
        lastLotto.printNumbers();
        System.out.println("일치한 번호: " + matchNums.toString() + "(" + matchCount + "개)");
    }
}