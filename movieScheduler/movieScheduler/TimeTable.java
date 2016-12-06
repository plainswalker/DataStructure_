package movieScheduler;
import java.util.*;

public class TimeTable {
	private ArrayList<Movie> listMovie;
	private int theaterRunningTime;
	final private int numScreen;
	private ArrayList< ArrayList<Integer> > listMovieIdx; //2DimArr[numScreen][theaterRunningTime]	
	private ArrayList< ArrayList<String> >tableStringList;
	private boolean tableModified;
	
	final static private int startHour = 8;
	final static private int endHour = 26;
	final static private int defaultTheaterRunningTime = (TimeTable.endHour - TimeTable.startHour) * 60;
	final static private int defaultNumScreen = 6;
	
	public TimeTable(){
		this.listMovie = new ArrayList<Movie>();
		this.theaterRunningTime = TimeTable.defaultTheaterRunningTime;
		this.numScreen = TimeTable.defaultNumScreen;
		this.listMovieIdx = new ArrayList< ArrayList<Integer> >(this.numScreen);
		for(int i = 0; i < this.numScreen; i++){
			this.listMovieIdx.add(new ArrayList<Integer>(this.theaterRunningTime));
		}
		this.tableStringList = null;
		this.tableModified = false;
	}
	
	public TimeTable(ArrayList<Movie> listMovie){
		this.listMovie = new ArrayList<Movie>(listMovie);
		this.theaterRunningTime = TimeTable.defaultTheaterRunningTime;
		this.numScreen = TimeTable.defaultNumScreen;
		this.listMovieIdx = new ArrayList< ArrayList<Integer> >(this.numScreen);
		for(int i = 0; i < this.numScreen; i++){
			this.listMovieIdx.add(new ArrayList<Integer>(this.theaterRunningTime));
			for(int j = 0; j < this.theaterRunningTime; j++){
				this.listMovieIdx.get(i).add(0);
			}
		}
		this.tableStringList = null;
		this.tableModified = false;
	}
	
	public void writeTable(int screen, int time, int idxMovie){		
		this.listMovieIdx.get(screen).set(time, idxMovie);
		this.tableModified = true;
	}
	
	//getter
	 public ArrayList< ArrayList<String> > getTableStringList(){
		 if(this.tableStringList == null){
			 this.tableStringList = new ArrayList< ArrayList<String> >(this.listMovie.size());
		}
		if(this.tableModified){
			this.tableStringList.clear();
			ArrayList<String> tmpStrLst = new ArrayList<String>();			
			for(int i = 0; i < this.listMovie.size(); i++){								
				for(int j = 0; j < this.numScreen; j++){					
					int k = 0;
					for(;k < this.theaterRunningTime;k++){
						
						while(this.listMovieIdx.get(j).get(k) == i){							
							try{
								if(this.listMovieIdx.get(j).get(k + this.listMovie.get(i).getTime()) == i){
									StringBuilder tmpStrBuilder = new StringBuilder();
									int movieStartTime = TimeTable.startHour*60 + k;
									tmpStrBuilder.append(movieStartTime/(int)60).append(" : ");
									if(movieStartTime%60 < 10){
										tmpStrBuilder.append("0").append(movieStartTime%60);
									}
									else{
										tmpStrBuilder.append(movieStartTime%60);
									}
									tmpStrBuilder.append(" Screen ").append(j+1);							
									tmpStrLst.add(tmpStrBuilder.toString());
									k += this.listMovie.get(i).getTime();
								}
								else
								{
									k++;
									break;
								}
							}
							catch(IndexOutOfBoundsException e){
								k++;
								break;
							}
					//		if((this.theaterRunningTime - k) < this.listMovie.get(i).getTime())
				//			{
				//				k++;
				//				break;
				//			}							
						}						
					}
					
					if(!tmpStrLst.isEmpty())
					{
						tmpStrLst.add(this.listMovie.get(i).getName());
						this.tableStringList.add(new ArrayList<String>(tmpStrLst));
						tmpStrLst.clear();
					}
				}
				
			}
			this.tableModified = false;
		}
		return this.tableStringList;		 
	 }
	public ArrayList<String> getTableStringList(int idxMovie){
		return this.getTableStringList().get(idxMovie);
	}
	public ArrayList<String> getTableStringList(String Moviename){
		int i = 0;
		while(this.listMovie.get(i).getName().equals(Moviename)){
			i++;	
		};
		return this.getTableStringList(i);
	}
	 
	@Override
	public String toString(){
		return this.listMovieIdx.toString();
	}
}
