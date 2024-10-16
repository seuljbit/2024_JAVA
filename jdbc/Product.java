package jdbc;

public class Product {
	private int pno; // 자동생성
	private String pname;
	private int price;
	private String regdate;
	private String madeby;
	
	public Product() {}
	
	// 상품 등록 : pname, price, madeby
	public Product(String pname, int price, String madeby) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}
	
	// 상품 리스트 : pno, panme, price
	public Product(int pno, String pname, int price) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}
	
	// 상품 상세보기 : 전부 다
	public Product(int pno, String pname, int price, String regdate, String madeby) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.regdate = regdate;
		this.madeby = madeby;
	}
	
	// 상품 수정 : pname, price, madeby, pno(식별자)
	public Product(String pname, int price, String madeby, int pno) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "<" + pno + "> " + pname + "(" + price + "원) / " + "[" + madeby + "] " + regdate;
	}
	
	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}
}
