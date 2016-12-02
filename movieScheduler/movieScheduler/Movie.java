package movieScheduler;

public class Movie implements Comparable<Movie>{
	//members
	private String name;
	private int time; // represent minutes
	private double value; //name can be changed	
	//...
	
	//constructors
	public Movie(){
		this.name = "no_name";
		this.time = 0;
		this.value = 0.0;
	}
	public Movie(String name, int time, double value){
		this.name = name;
		this.time = time;
		this.value = value;
	}	
	public Movie(StringBuilder name, int time, double value){
		this.name = name.toString();
		this.time = time;
		this.value = value;
	}	
	public Movie(char[] name, int time, double value){
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
	public double getValue(){ //public if needed
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
		double tmp = this.value - target.value;
		if(tmp > 0){
			return 1;
		}
		else if(tmp == 0){
			return 0;
		}
		else{// if(tmp < 0)
			return -1;
		}
		
	}
}