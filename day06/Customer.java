package day06;
/* Silver 일반고객 / Gold 고객(할인) / VIP 고객(할인)
- Silver 일반고객 : 제품을 구매할 때 0% 할인, 1% 적립
- Gold 고객 : 제품 구매할 때 10% 할인, 2% 적립
- VIP 고객 : 제품 구매할 때 10% 할입, 5% 적립, 전담 상담사 O

* Customer / Gold Customer / VIP Customer 클래스 생성
* Gold Customer / VIP Customer -> Customer 클래스 상속

* 기본 멤버변수
 - CustomerID : 고객 ID
 - CustomerName : 고객 이름
 - CustomerGrade : 고객 등급
 - bonusPoint : 포인트
 - bonusRatio : 적립 비율 0.01 => 1%
 
 * 메서드
  1. 보너스 적립 계산 메서드
   - 구매 금액을 주고 적립 보너스를 계산하여 bonusPoint 누적
   - 보너스 적립, 할인여부 체크하여 구매 금액을 return
  2. 출력 메서드
   ex) 홍길동 님은 VIP 등급이며, 보너스 포인트는 5000점 입니다.
       전담 상담사 번호는 1111 입니다.(<- VIP만 추가, agentID)
 
 * 기본 CustomerGrade = Silver */

public class Customer {
	protected int customerID;
    protected String customerName;
    protected String customerGrade;
    protected int bonusPoint;
    protected double bonusRatio;

    public Customer() {}
    
    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
        customerGrade = "Silver";
        bonusRatio = 0.01;
    }
    
    // 가격 매개변수로 받아 -> 포인트 적립, 할인가격 리턴
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price;
    }
    
    public void customerInfo() {
    	System.out.println(customerName + " 님은 " + customerGrade + " 등급이며, 보너스 포인트는 " + bonusPoint + "점 입니다.");
    }

    
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
}
