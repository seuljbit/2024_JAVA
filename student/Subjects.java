package student;

public class Subjects {
	/* Subject class : 과목 정보
	  - 과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장 */

	private String subName;
	private String subCode;
	private double score;
	private int hours;
	private String profName;
	private String classTime;
	private String classRoom;

	public Subjects() {}

	public Subjects(String subName, String subCode, double score, int hours, String profName, String classTime, String classRoom) {
		this.subName = subName;
		this.subCode = subCode;
		this.score = score;
		this.hours = hours;
		this.profName = profName;
		this.classTime = classTime;
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return subName + "(" + subCode + ", " + profName + ") - "
			   + classTime + "(" + classRoom + "), " + hours + ", " + score;
	}

	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
}