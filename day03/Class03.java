package day03;

public class Class03 {
	public static void main(String[] args) {
		Tv tv1 = new Tv("LG", "2024");
		tv1.tvInfo();
		
		tv1.power();
		tv1.chUp();
		tv1.chDown();
		tv1.chDown();
		tv1.chDown();
		tv1.chUp();
		tv1.chUp();
		tv1.chUp();
		tv1.chUp();
		
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volUp();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
		tv1.volDown();
	}
}

/* TV 클래스 생성
 * 멤버변수 : brand, power, ch, vol
 * 메서드 :
 * power()
 * chUp() / chDown : 1씩 증가, 최대 20까지 있음. 20이 넘어가면 다시 0번으로 돌아오는 순환구조
 * volUp() / volDown() : 1씩 증가, 최대 10, 10이 넘어가면 10, 0이면 음소거 출력 */

class Tv {
	private String brand;
	private String year;
	
	private boolean power = false;
	private int ch;
	

	private int vol;
	
	public Tv() {
	}
	
	public Tv(String brand, String year) {
		this.brand = brand;
		this.year = year;
	}
	
	public Tv(String brand, String year, boolean power, int ch, int vol) {
		this.brand = brand;
		this.year = year;
		this.power = power;
		this.ch = ch;
		this.vol = vol;
	}
	
	public void tvInfo() {
		System.out.println("< TV 정보 >");
		System.out.println("브랜드명 : " + this.brand);
		System.out.println("제조년도 : " + this.year);
		System.out.println();
	}
	
	public void power() {
		this.power =! this.power; 
		if(this.power == false) {
			System.out.println("TV 화면이 꺼졌습니다.");
		} else {
			System.out.println("TV 화면이 켜졌습니다.");
			tvInfo();
			System.out.println("채널 : " + this.ch + "번");
		}
	}
	
	public void chUp() {
		if (power == true) {
			if(this.ch == 20) {
				this.ch = -1;
			} else {
				this.ch++;
				System.out.println("채널 : " + this.ch + "번");
			}
		} else {
			System.out.println("TV 화면이 꺼져있습니다.");
		}
	}
	
	public void chDown() {
		if(power == true) {
			if(this.ch == 0) {
				this.ch = 20;
				System.out.println("채널 : " + this.ch + "번");
			} else {
				this.ch--;
				System.out.println("채널 : " + this.ch + "번");
			}
		} else {
			System.out.println("TV 화면이 꺼져있습니다.");
		} 
	}
	
	public void volUp() {
	    if(power == true) {
	        if(this.vol == 10) { 
	            System.out.println("최대 소리입니다.");
	        } else {
	            this.vol++;
	        } System.out.println("소리 : " + this.vol);
	    } else {
	        System.out.println("TV 화면이 꺼져있습니다.");
	    } 
	}

	public void volDown() {
	    if(power == true) {
	        if(this.vol == 0) {
	            System.out.println("음소거되었습니다.");
	        } else {
	            this.vol--;
	            System.out.println("소리 : " + this.vol);
	        }
	    } else {
	        System.out.println("TV 화면이 꺼져있습니다.");
	    }
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
}
