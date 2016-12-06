package movieScheduler;

import java.util.*;

public class TimeTableManager {
	private ArrayList<Movie> listMovie;
//	private int settingTime;
	final private int theaterRunningTime;
	final private int numScreen;
//	final static private int defaultSettingTime = 20;
	final static private int defaultTheaterRunningTime = (26 - 8) * 60;
	final static private int defaultNumScreen = 6;

	public TimeTableManager() {
		this.listMovie = new ArrayList<Movie>();
	//	this.settingTime = TimeTableManager.defaultSettingTime;
		this.numScreen = TimeTableManager.defaultNumScreen;
		this.theaterRunningTime = TimeTableManager.defaultTheaterRunningTime;
	}

	public TimeTableManager(ArrayList<Movie> listMovie) {
		this.listMovie = new ArrayList<Movie>(listMovie);
//		this.settingTime = TimeTableManager.defaultSettingTime;
		this.numScreen = TimeTableManager.defaultNumScreen;
		this.theaterRunningTime = TimeTableManager.defaultTheaterRunningTime;
	}
	
	public TimeTable makeTable(){
		TimeTable timeTable = new TimeTable(this.listMovie);
		ArrayList<Double> valList = MovieManager.getValueList(this.listMovie);
		ArrayList<Integer> ScreenRunTime = new ArrayList<Integer>();
		
		for(int i = 0; i < this.numScreen; i++){
			ScreenRunTime.add(this.theaterRunningTime);
		}
		
		for (int i = 0; i < valList.size(); i++) {
			int inputTime = (int)(valList.get(i) * (double)(this.numScreen * this.theaterRunningTime));
			for (int j = 0; j < this.numScreen; j++) {
				int restTime = ScreenRunTime.get(j);
				if (inputTime > restTime) {
					for (int k = 0; k < restTime; k++) {
						ScreenRunTime.set(j,ScreenRunTime.get(j) - 1);
						timeTable.writeTable(j, k, i);
					}
					inputTime -= restTime;
				} 
				else {
					for (int k = 0; k < inputTime; k++) {
						ScreenRunTime.set(j,ScreenRunTime.get(j) - 1);
						timeTable.writeTable(j, k, i);
					}
					break;
				}
			}
		}
		
		return timeTable;
	}
/*	public void setSettingTime(int time){
//		this.settingTime = time;
}*/
}