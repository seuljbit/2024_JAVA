package day03;

public class CardPack {
	/* ♠ 1~13, ♥ 1~13, ♣ 1~13, ◆ 1~13 -> 52장의 카드로 구성
	 * 52장의 카드를 담을 수 있는 배열(카드 한 묶음 배열) - 멤버변수
	  
	 * 생성자 - 52장의 카드를 순서대로 생성되게 만들기
	 * 메서드 : 
	   - 카드 출력 기능 : Card class -> print() 사용
	   - 카드 초기화 기능
	   - 카드 한 장을 나눠주는 기능
	   - 카드를 섞는 기능 */
	
    private Card[] pack = new Card[52]; // 카드 52장을 저장할 배열
    private int cnt = 0; 

    public CardPack() {
        String[] shapes = {"◆", "♥", "♠", "♣"};
        
        for (int i = 0; i < shapes.length; i++) {
            for (int num = 1; num <= 13; num++) { 
                pack[cnt++] = new Card(shapes[i], num); 
            }
        }
        cnt = 0;
    }

	public Card cardPick() { // 카드 한 장을 나눠주는 기능
        if (cnt < pack.length) {
            return pack[cnt++];
        } else {
            System.out.println("더 이상 카드가 없습니다.");
            return null; 
        }
    }
    
	// 랜덤번지를 하나 뽑아서 순서대로 0번지부터 서로 교환
    public void cardMix() {
        for (int i = 0; i < pack.length; i++) {
            int randomIndex = (int)(Math.random() * pack.length);
            Card temp = pack[i];
            pack[i] = pack[randomIndex];
            pack[randomIndex] = temp;
        }
        System.out.println("카드가 섞였습니다.");
    }
    
    public void printAllCards() {
        for (int i = 0; i < pack.length; i++) {
            pack[i].print();
        } System.out.println();
    }
    
    public void cardReset() {
        cnt = 0;
        System.out.println("카드가 초기화되었습니다.");
    }

    
    public Card getPack(int index) { 
        if (index < pack.length) {
            return pack[index];
        } else {
            return null;
        }
    }


	public void setPack(Card[] pack) {
		this.pack = pack;
	}
}
