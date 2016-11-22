package movieScheduler;

public class Movie implements Comparable<Movie>{
	//members
	private String name;
	private int time;
	private int value; //name can be changed	
	//...
	
	//constructors
	Movie(){
		this.name = null;
		this.time = 0;
		this.value = 0;
	}
	public Movie(String name, int time, int value){
		this.name = name;
		this.time = time;
		this.value = value;
	}	
	public Movie(StringBuilder name, int time, int value){
		this.name = name.toString();
		this.time = time;
		this.value = value;
	}	
	public Movie(char[] name, int time, int value){
		this.name = new String(name);
		this.time = time;
		this.value = value;
	}
	//...
	
	//getters
	public int getTime(){
		return this.time;
	}	
	public double getHour(){
		int hour = this.time/(int)60;
		return (double)hour + (double)(this.time - (hour * 60)) / 60;
	}	
	public int getValue(){ //public if needed
		return value;
	}	
	public String getName(){
		return this.name.toString();
	}	
	public StringBuilder getNameBuilder(){
		return new StringBuilder(this.name);
	}
	//...
	
	
	
	@Override
	public int compareTo(Movie target){
		return this.value - target.value;
	}
}