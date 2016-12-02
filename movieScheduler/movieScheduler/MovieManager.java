package movieScheduler;

import java.lang.*;
import java.util.*;


public class MovieManager {
	//members
	private PriorityQueue<Movie> movieList;
	//constructors
	public MovieManager()
	{
		this.movieList = new PriorityQueue<Movie>();
	}
	public MovieManager(Movie[] arrMovie){
		this.movieList = new PriorityQueue<Movie>(arrMovie.length);
		for(int i = 0; i < arrMovie.length; i++){
			this.movieList.add(arrMovie[i]);
		}
	}
	public MovieManager(ArrayList<Movie> listMovie){
		this.movieList = new PriorityQueue<Movie>(listMovie.size());
		for(int i = 0; i < listMovie.size(); i++){
			this.movieList.add(listMovie.get(i));
		}
	}
	
	//setters
	public boolean addToList(Movie m){
		return this.movieList.add(m);
	}

	//getters
	public ArrayList<Movie> getMovieList(){
		PriorityQueue<Movie> tmpMovieList = new PriorityQueue<Movie>(this.movieList);
		ArrayList<Movie> listMovie = new ArrayList<Movie>(tmpMovieList.size());
		while(!tmpMovieList.isEmpty()){
			listMovie.add(tmpMovieList.poll());
		}
		return listMovie;
	}
	
	public ArrayList<Double> getValueList(){
		ArrayList<Movie> listMovie = this.getMovieList();
		ArrayList<Double> valueList = new ArrayList<Double>(listMovie.size());
		for(int i = 0; i < valueList.size(); i++){
			valueList.add(listMovie.get(i).getValue());
		}
		return valueList;
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
	
}

/*
class TestMain
{
	public static void main(){
		Movie[] arrm = {new Movie(), };
		MovieManager m = new MovieManager(arrm);
		m.addToList(new Movie("yes_name",0,0.0));
		ArrayList lstm = m.getMovieList();
		for(int i = 0; i < lstm.size(); i++){
			System.out.println(lstm.get(i));
		}
	}
}
*/
