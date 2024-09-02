package application;

public class statsCollection {
	
	private static final statsCollection instance = new statsCollection();
	
	private int played;
	private int percent;
	private int current;
	private int max;
	private int win;
	private int attempts1;
	private int attempts2;
	private int attempts3;
	private int attempts4;
	private int attempts5;
	private int attempts6;
	private String answer;
	
	private statsCollection () {}
	
	public static statsCollection getInstance() {
		return instance;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public int getPlayed() {
		return played;
	}
	
	public void setPlayed(int played) {
		this.played = played;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public int getPercent() {
		return percent;
	}
	
	public void setWin(int win) {
		this.win = win;
	}
	
	public int getWin() {
		return win;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	public int getAttempts1() {
		return attempts1;
	}
	
	public void setAttempts1(int attempts1) {
		this.attempts1 = attempts1;
	}
	
	public int getAttempts2() {
		return attempts2;
	}
	
	public void setAttempts2(int attempts2) {
		this.attempts2 = attempts2;
	}
	
	public int getAttempts3() {
		return attempts3;
	}
	
	public void setAttempts3(int attempts3) {
		this.attempts3 = attempts3;
	}
	public int getAttempts4() {
		return attempts4;
	}
	
	public void setAttempts4(int attempts4) {
		this.attempts4 = attempts4;
	}
	
	public int getAttempts5() {
		return attempts5;
	}
	
	public void setAttempts5(int attempts5) {
		this.attempts5 = attempts5;
	}
	
	public int getAttempts6() {
		return attempts6;
	}
	
	public void setAttempts6(int attempts6) {
		this.attempts6 = attempts6;
	}
}
