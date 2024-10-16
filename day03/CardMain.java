package day03;

public class CardMain {

    public static void main(String[] args) {
        CardPack cp = new CardPack(); // 카드 팩 생성

        // 카드 섞기
        cp.cardMix(); // 카드를 섞는 메서드 호출
        System.out.println("카드를 섞었습니다.");
        
        // 섞인 카드 모두 출력
        System.out.println("섞인 카드 출력:");
        int cnt = 0;
        for (int i = 0; i < 4; i++) { // 모양별로 카드 출력
            for (int j = 0; j < 13; j++) {
                cp.getPack(cnt++).print(); // 섞인 카드 출력
            }
            System.out.println(); // 모양이 끝날 때마다 줄바꿈
        }

        System.out.println("------------------");
        System.out.println("딜러가 카드를 나누고 있습니다.");

        // 플레이어들에게 카드를 나누는 코드
        Card player1 = cp.cardPick();
        Card player2 = cp.cardPick();
        Card player3 = cp.cardPick();
        Card player4 = cp.cardPick();
        Card player5 = cp.cardPick();
        
        System.out.println("카드를 모두 나누었습니다.");
        System.out.println();

        // 각 플레이어의 카드 출력
        System.out.print("Player 1 : ");
        player1.print();
        System.out.println();
        
        System.out.print("Player 2 : ");
        player2.print();
        System.out.println();
        
        System.out.print("Player 3 : ");
        player3.print();
        System.out.println();
        
        System.out.print("Player 4 : ");
        player4.print();
        System.out.println();
        
        System.out.print("Player 5 : ");
        player5.print();
        System.out.println();
        System.out.println();

        // 카드 팩 초기화
        cp.cardReset();

        // 초기화된 카드 다시 출력
        System.out.println("초기화된 카드 출력:");
        cnt = 0; // 다시 0으로 초기화
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cp.getPack(cnt++).print(); // 초기화된 카드 출력
            }
            System.out.println();
        }
    }
}
