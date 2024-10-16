package day09;

public class Sale<K, V> {
	// 멤버변수 : id, menu, price
	private K id;
	private V menu;
	private int price;
	
	public Sale() {}
	
	public Sale(K id, V menu, int price) {
		this.id = id;
		this.menu = menu;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return id + ". " + menu + "(" + price + "원)";
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public V getMenu() {
		return menu;
	}

	public void setMenu(V menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
