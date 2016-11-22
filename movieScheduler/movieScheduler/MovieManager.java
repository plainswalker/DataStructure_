package movieScheduler;

import java.lang.*;
import java.util.*;

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
	public ArrayList<Movie> getMovieList(){
		PriorityQueue<Movie> tmpMovieList = new PriorityQueue<Movie>(this.movieList);
		ArrayList<Movie> listMovie = new ArrayList<Movie>(tmpMovieList.size());
		while(!tmpMovieList.isEmpty()){
			listMovie.add(tmpMovieList.poll());
		}
		return listMovie;
	}
	
	public static ArrayList<Double> getMovieDistribution(ArrayList<Movie> list){//the list of rate is not sorted.		
		ArrayList<Double> listValueRate = new ArrayList<Double>(list.size());
		double sumValue = 0;
		for(int i = 0; i < list.size(); i++){
			sumValue += list.get(i).getValue();
		}
		for(int i = 0; i < list.size(); i++){
			listValueRate.add(new Double(list.get(i).getValue() / sumValue));
		}		
		return listValueRate;
	}
	public ArrayList<Double> getMovieDistribution(){		
		return MovieManager.getMovieDistribution(this.getMovieList());
	}
	
	
	
	//getter for reverse order if needed	
	//...
	
	
}

