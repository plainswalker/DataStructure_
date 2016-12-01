package movieScheduler;

import java.util.*;

public class TimeTableManager {
	private ArrayList<Movie> listMovie;
	private int settingTime;
	final private int theaterRunningTime;
	final private int numScreen;
	final static private int defaultSettingTime = 20;
	final static private int defaultTheaterRunningTime = (24 - 8) * 60;
	final static private int defaultNumScreen = 6;

	TimeTableManager() {
		this.listMovie = new ArrayList<Movie>();
		this.settingTime = TimeTableManager.defaultSettingTime;
		this.numScreen = TimeTableManager.defaultSettingTime;
		this.theaterRunningTime = TimeTableManager.defaultTheaterRunningTime;
	}

	TimeTableManager(ArrayList<Movie> listMovie) {
		this.listMovie = new ArrayList<Movie>(listMovie);
		this.settingTime = TimeTableManager.defaultSettingTime;
		this.numScreen = TimeTableManager.defaultNumScreen;
		this.theaterRunningTime = TimeTableManager.defaultTheaterRunningTime;
	}
	
	TimeTable makeTable(){
		TimeTable timeTable = new TimeTable(this.listMovie);
		ArrayList<Double> valList = MovieManager.getMovieDistribution(this.listMovie);
		ArrayList<Integer> ScreenRunTime = new ArrayList<Integer>();
		for(int i = 0; i < this.numScreen; i++){
			ScreenRunTime.set(i,this.theaterRunningTime);
		}
		
		for (int i = 0; i < valList.size(); i++) {
			double inputTime = valList.get(i) * (this.numScreen * this.theaterRunningTime);
			for (int j = 0; j < this.numScreen; j++) {
				int restTime = ScreenRunTime.get(j);
				if (inputTime > restTime) {
					for (int k = 0; k < restTime; k++) {
						ScreenRunTime.set(j,j-1);
						timeTable.addMovie(j, k, i);
					}
					inputTime -= restTime;
				} 
				else {
					for (int k = 0; k < inputTime; k++) {
						ScreenRunTime.set(j,j-1);
						timeTable.addMovie(j, k, i);
					}
					break;
				}
			}
		}

		
		return timeTable;
	}

	public void setSettingTime(int time){
		this.settingTime = time;
	}
	 

}

// package structure;
// import java.util.ArrayList;
class ____main {
	static ArrayList<Double> star = new ArrayList<Double>();
	// 영화간 갯수
	static int THEATHER = 5;
	// 일일 상용 가능 횟수
	static int TIME = 10;
	// 예상 일수
	static int DATE = 7;

	public static void ________main(String[] args) {
		// 영화모음
		ArrayList<Double> movie = new ArrayList<Double>();
		// 실제 들어갈 값
		ArrayList<Double> num = new ArrayList<Double>();
		// 주어진 자료들
		star.add(60.0);
		star.add(30.0);
		star.add(5.0);
		star.add(3.0);
		star.add(2.0);

		// 1자형으로 나열형태
		num.add(((star.get(0)) / 100) * (THEATHER * TIME));
		for (int i = 1; i < star.size(); i++) {
			num.add(((star.get(i)) / 100) * (THEATHER * TIME) + num.get(i - 1));
		}
		// 출력
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}
		// 클래스 활용으로 극장별 나눈형태
		ArrayList<Theater> eachTheater = new ArrayList<Theater>();
		for (int i = 0; i < THEATHER; i++) {
			eachTheater.add(new Theater(i));
		}
		// 실제 들어가야될 타임으로 환산하기
		for (int i = 0; i < num.size(); i++) {
			star.set(i, ((star.get(i)) / 100) * (THEATHER * TIME));
		}
		// 각 영화관마다 쪼개서 넣기
		// 이때, 소수점들 즉, 한개의 타임을 온전히 못채울 경우 점유율이 큰 순서대로 올림
		for (int i = 0; i < star.size(); i++) {
			double inputTime = star.get(i);
			for (int j = 0; j < eachTheater.size(); j++) {
				int restTime = ((Theater) eachTheater.get(j)).getRestTime();
				if (inputTime > restTime) {
					for (int k = 0; k < restTime; k++) {
						((Theater) eachTheater.get(j)).addTime(i);
					}
					inputTime -= restTime;
				} 
				else {
					for (int k = 0; k < inputTime; k++) {
						((Theater) eachTheater.get(j)).addTime(i);
					}
					break;
				}
			}
		}
		for (int i = 0; i < eachTheater.size(); i++) {

			eachTheater.get(i).showMovie();

			System.out.println("");

		}
	}

	static class Theater {
		int time = 10;
		ArrayList<Integer> movie;
		int name;

		public Theater(int name) {
			this.name = name;
			movie = new ArrayList<Integer>();
		}

		int getRestTime() {
			return this.time;
		}

		void addTime(Integer movie) {
			this.time--;
			this.movie.add(movie);
		}

		void showMovie() {
			for (int i = 0; i < movie.size(); i++) {
				System.out.print(movie.get(i) + ",");
			}
		}

	}

}
