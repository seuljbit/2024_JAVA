package day03;

public class Card {
    private String shape;
    private int num;

    // 기본 생성자
    public Card() {
        this.shape = "♥";
        this.num = 1;
    }

    // 오버로딩된 생성자
    public Card(String shape, int num) {
        setShape(shape);  // setter 사용
        setNum(num);      // setter 사용
    }

    // 카드를 출력하는 메서드
    public void print() {
        String numStr = ""; 

        switch (this.num) {
            case 1: numStr = "A"; break;
            case 11: numStr = "J"; break;
            case 12: numStr = "Q"; break;
            case 13: numStr = "K"; break;
            default: numStr = String.valueOf(this.num);
        }
        System.out.print(this.shape + " " + numStr);
    }

    // shape getter
    public String getShape() {
        return shape;
    }

    // shape setter
    public void setShape(String shape) {
        if (!shape.equals("♠") && !shape.equals("♥") && !shape.equals("♣") && !shape.equals("◆")) {
            System.out.println("잘못된 모양입니다. 기본값으로 설정됩니다.");
            this.shape = "♥";
        } else {
            this.shape = shape;
        }
    }

    // num getter
    public int getNum() {
        return num;
    }

    // num setter
    public void setNum(int num) {
        if (num >= 1 && num <= 13) { // 1 ~ 13까지만 가능
            this.num = num;
        } else {
            System.out.println("잘못된 숫자입니다.");
            this.num = 1;
        }
    }
}