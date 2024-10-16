package day06;

public class CustomerMain {
    public static void main(String[] args) {
    	// 업캐스팅 : 부모의 객체 배열에 자식 객체의 값을 넣을 수 있는 것은 업캐스팅이 가능해서..
    	// 업캐스팅은 자동 형변환
        Customer[] customerList = new Customer[10];
        
        Customer customer1 = new Customer(111, "홍길동");
        Customer customer2 = new GoldCustomer(222, "이순신");
        Customer customer3 = new VIPCustomer(333, "강감찬", 1111);
        Customer customer4 = new VIPCustomer(4444, "유관순", 4444);
        Customer customer5 = new VIPCustomer(5555, "을지문덕", 4444);
        
        int cnt = 0;
        
        customerList[cnt] = customer1;
        cnt++;
        customerList[cnt] = customer2;
        cnt++;
        customerList[cnt] = customer3;
        cnt++;
        customerList[cnt] = customer4;
        cnt++;
        customerList[cnt] = customer5;
        cnt++;
        
        System.out.println("< 할인율과 포인트 계산 > \n");
        int price = 100000;
        
        // 모든 손님 대상
        // 홍길동 님의 지불금액은 100000원 / 포인트는 1000점 입니다.
        for (int i = 0; i < cnt; i++) {
            int salePrice = customerList[i].calcPrice(price); // 할인율 계산 + 보너스 포인트 적립
            System.out.println(customerList[i].getCustomerName() + "님의 지불 금액 : " 
                + salePrice + "원 / 포인트 : " + customerList[i].bonusPoint + "점 입니다.");
            System.out.println("---------------------------------------------");
        }
        
        // 고객 정보 출력
        System.out.println();
        for (int i = 0; i < cnt; i++) {
        	customerList[i].customerInfo();
            System.out.println("---------------------------------------------");
        }
        
        // 다운캐스팅 : 부모의 공유되는 멤버변수나 메서드가 아닌 자식 고유의 멤버변수나 메서드를 호출하고자 할 경우 사용
        // 다운캐스팅 시 반드시 명시적으로 형변환 해야함
        
        // agentID = 1111 -> 3333 로 변경
        for(int i = 0; i < cnt; i++) {
        	Customer c = customerList[i];
        	if (c instanceof VIPCustomer) {
        		VIPCustomer vip = (VIPCustomer)c;
        		if(vip.getAgentID() == 1111) {
        			vip.setAgentID(3333);
        		}
            }
        }
        
        // 고객 정보 출력
        System.out.println();
        for (int i = 0; i < cnt; i++) {
        	customerList[i].customerInfo();
            System.out.println("---------------------------------------------");
        }
    }
}