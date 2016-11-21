package movieScheduler;

import java.lang.*;
import java.util.*;

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
	Movie(String name, int time, int value){
		this.name = name;
		this.time = time;
		this.value = value;
	}	
	Movie(StringBuilder name, int time, int value){
		this.name = name.toString();
		this.time = time;
		this.value = value;
	}	
	Movie(char[] name, int time, int value){
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
	int getValue(){ //public if needed
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
	int compareTo(Movie target){
		return this.value - target.value;
	}
}


public class MovieManager {
	//members
	private PriorityQueue<Movie> movieList;
	//...
	
	//constructors
	public MovieManager()
	{
		this.movieList = new PriorityQueue<Movie>();
		//...
	}
	public MovieManager(Movie[] arrMovie){
		this.movieList = new PriorityQueue<Movie>(arrMovie.length);
		for(int i = 0; i < arrMovie.length; i++){
			this.movieList.add(arrMovie[i]);
		}
		//...
	}
	public MovieManager(ArrayList<Movie> listMovie){
		this.movieList = new PriorityQueue<Movie>(listMovie.size());
		for(int i = 0; i < listMovie.size(); i++){
			this.movieList.add(listMovie.get(i));
		}
		//...
	}
	//...
	
	//setters
	public boolean addToList(Movie m){
		return this.movieList.add(m);
	}
	//...
	//getters
	public getMovieList(){
		PriorityQueue<Movie> tmpMovieList = new PriorityQueue<Movie>(this.movieList);
		ArrayList listMovie = new ArrayList<Movie>(this.movieList.size());
		while(!this.movieList.isEmpty()){
			listMovie.add(this.movieList.poll());
		}
		return listMovie;
	}
	//getter for reverse order if needed	
	//...
	
	
}

