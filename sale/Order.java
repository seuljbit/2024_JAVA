package sale;

public class Order extends Menu{
	private int orderNum;
	private int cnt;
	private int totalPrice;
	
	public Order(int pickMenu, String string, int i, int count, int orderNum2) {}
	
	public Order(int id, String name, int price, int cnt) {
		super(id, name, price);
		this.cnt = cnt;
		this.totalPrice = cnt * price;
	}
	
	public void orderPrint() { //출력메서드, super.toString();  // 부모의 toString 호출
		System.out.print(super.toString()+"/");
		System.out.println(cnt+"개 주문 => 금액 : "+totalPrice);
	}
	
	@Override
	public String toString() {
		return orderNum + "> " + cnt + "개 주문, 총 " + totalPrice + "원)";
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}