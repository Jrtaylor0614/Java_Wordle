package application;

import java.io.*;

public class gameSaves implements Serializable {
	
	private int currentStreak;
    private int maxStreak;
    private int gamesPlayed;
    private int winPercent;



	public gameSaves(int currentStreak, int maxStreak, int gamesPlayed, int winPercent) {

        this.currentStreak = currentStreak;
        this.maxStreak = maxStreak;
        this.gamesPlayed = gamesPlayed;
        this.winPercent = winPercent;
        
    }

    public int getcurrentStreak() {
        return currentStreak;
    }

    public int getmaxStreak() {
        return maxStreak;
    }
    
    public int getgamesPlayed() {
        return gamesPlayed;
    }

    public int getwinPercent() {
        return winPercent;
    }
}
