package day05;

public class Product {
    private static int index;  // 모든 객체가 공유하는 static index
    private int num;  // 각 객체의 고유 번호
    private String name;
    private int price;

    // 생성자
    public Product() {} // 기본생성자
    
    public Product(String name, int price) {
        this.num = ++index;  // 상품이 추가될 때 index를 증가시키고 num에 저장
        this.name = name;
        this.price = price;
    }

    // toString 오버라이드
    @Override
    public String toString() {
        return num + ". " + name + " : " + price + "원";
    }

    // getter, setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}