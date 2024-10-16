package day09;

public class Student {
	String name;
	int score;
	
	public Student () {}
	
	public Student (String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return name + " : " + score + "점";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
