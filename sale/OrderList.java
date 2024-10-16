package sale;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
	private int orderNum;
	private List<Order> order = new ArrayList<>();
	
	
	public OrderList(int orderNum) {
		this.orderNum = orderNum;
	}
	
	public void addOrder(Order order) {
		this.order.add(order);
	}
	
	@Override
	public String toString() {
		return orderNum + ") " + order;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
}
