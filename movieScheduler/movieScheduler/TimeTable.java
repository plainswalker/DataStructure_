package movieScheduler;
import java.util.*;

public class TimeTable {
	private ArrayList<Movie> listMovie;
	private int theaterRunningTime;
	final private int numScreen;
	private ArrayList< ArrayList<Integer> > listMovieIdx; //2dimarr[numScreen][theaterRunningTime]
	
	final static private int defaultTheaterRunningTime = (24 - 8) * 60;
	final static private int defaultNumScreen = 6;
	
	public TimeTable(){
		this.listMovie = new ArrayList<Movie>();
		this.theaterRunningTime = TimeTable.defaultTheaterRunningTime;
		this.numScreen = TimeTable.defaultNumScreen;
		this.listMovieIdx = new ArrayList< ArrayList<Integer> >(this.numScreen);
		for(int i = 0; i < this.numScreen; i++){
			this.listMovieIdx.set(i, new ArrayList<Integer>(this.theaterRunningTime));
		}
	}
	public TimeTable(ArrayList<Movie> listMovie){
		this.listMovie = new ArrayList<Movie>(listMovie);
		this.theaterRunningTime = TimeTable.defaultTheaterRunningTime;
		this.numScreen = TimeTable.defaultNumScreen;
		this.listMovieIdx = new ArrayList< ArrayList<Integer> >(this.numScreen);
		for(int i = 0; i < this.numScreen; i++){
			this.listMovieIdx.set(i, new ArrayList<Integer>(this.theaterRunningTime));
		}
	}
	
	public void addMovie(int screen, int time, int idxMovie){
		this.listMovieIdx.get(screen).set(time, idxMovie);
	}
	
	 
	
	@Override
	public String toString(){
		return null;
	}
}

class Screen{
	
	
}