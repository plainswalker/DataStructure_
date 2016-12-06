//package ds.swing;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import movieScheduler.*;



public class uitest {
    public static void main(String[] args) {
    	MovieManager test_mm = new MovieManager();
    	test_mm.addToList(new Movie("4th",118,0.17));
    	test_mm.addToList(new Movie("2nd",100,0.24));
    	test_mm.addToList(new Movie("1st",110,0.36));    	
    	test_mm.addToList(new Movie("3rd",132,0.21));
    	
    	
    	TimeTableManager test_ttm = new TimeTableManager(test_mm.getMovieList());
    	System.out.println(test_ttm.makeTable().getTableStringList());
    	
        Runnable r = new Runnable() {
        
            @Override
            public void run() {
                CustomModel model = new CustomModel(test_ttm.makeTable());
                JTable table = new JTable();
                table.setModel(model);

                JFrame frame = new JFrame();
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);             
            }
        };

        EventQueue.invokeLater(r);
    }

}



class CustomModel extends AbstractTableModel {

//    List<Movie> data;
	ArrayList< ArrayList <String> > data;
   private String[] columnNames;// = {"MovieName ", " "," "," "," ","Move TimeTable "," "," "," "," "," "};

 //   @SuppressWarnings(value = { "unused" }) 
    private CustomModel() {
    	
 //       data = new ArrayList<Movie>();
/*
        data.add(new Movie("미씽","08:00 Screen1","10:00 Screen1","12:00 Screen1","14:00 Screen1","16:00 Screen1","18:00 Screen1","20:00 Screen1","22:00 Screen1","24:00 Screen1","26:00 Screen1"));
        data.add(new Movie("형","08:00 Screen1","10:10 Screen1","12:10 Screen1","14:10 Screen1","16:10 Screen1","18:10 Screen1","20:10 Screen1","22:10 Screen1","24:10 Screen1","26:10 Screen1"));
        data.add(new Movie("신비한동물사전","08:00 Screen1","11:00 Screen1","14:00 Screen1","17:00 Screen1","20:00 Screen1","23:00 Screen1","26:00 Screen1"," "," "," "));
        data.add(new Movie("잭 리처 : 네버고백","08:00 Screen1","10:20 Screen1","12:20 Screen1","14:20 Screen1","16:20 Screen1","18:20 Screen1","20:20 Screen1","22:20 Screen1","24:20 Screen1"," "));
*/

    }
    public CustomModel(TimeTable table){
    	this.data = table.getTableStringList();   
    	int max = data.get(0).size();
    	for(int i = 1; i < data.size(); i++){
    		max = (data.get(i).size() > data.get(i-1).size())?(data.get(i).size()):(data.get(i-1).size());
    	}
    	this.columnNames = new String[max];
    	this.columnNames[0] = new String("MovieName");
    	for(int i = 1; i < max; i++){
    		this.columnNames[i] = new String(" ");
    	}    	
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {    	
        return this.data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	try{
    		return this.data.get(rowIndex).get(columnIndex);
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		return null;
    	}
        //Movie movie = data.get(rowIndex);
 /*       switch (columnIndex) {
        case 0:
            return movie.getmovieName();
        case 1:
            return movie.getmovieTimeTableValue1();
        case 2:
            return movie.getmovieTimeTableValue2();
        case 3:
            return movie.getmovieTimeTableValue3();
        case 4:
            return movie.getmovieTimeTableValue4();
        case 5:
            return movie.getmovieTimeTableValue5();
        case 6:
            return movie.getmovieTimeTableValue6();
        case 7:
            return movie.getmovieTimeTableValue7();
        case 8:
            return movie.getmovieTimeTableValue8();
        case 9:
            return movie.getmovieTimeTableValue9();
        case 10:
            return movie.getmovieTimeTableValue10();
        default:
            return null;
        }*/
    }
}
/*
class Movie {
    private String movieName;
    private String movieTimeTableValue1;
    private String movieTimeTableValue2;
    private String movieTimeTableValue3;
    private String movieTimeTableValue4;
    private String movieTimeTableValue5;
    private String movieTimeTableValue6;
    private String movieTimeTableValue7;
    private String movieTimeTableValue8;
    private String movieTimeTableValue9;
    private String movieTimeTableValue10;
    


    public Movie(String movieName,String movieTimeTableValue1, String movieTimeTableValue2, 
    		String movieTimeTableValue3, String movieTimeTableValue4,
    		String movieTimeTableValue5,String movieTimeTableValue6,
    		String movieTimeTableValue7,String movieTimeTableValue8,
    		String movieTimeTableValue9,String movieTimeTableValue10) 
    {
        this.movieName = movieName;
        this.movieTimeTableValue1 = movieTimeTableValue1;
        this.movieTimeTableValue2 = movieTimeTableValue2;
        this.movieTimeTableValue3 = movieTimeTableValue3;
        this.movieTimeTableValue4 = movieTimeTableValue4;
        this.movieTimeTableValue5 = movieTimeTableValue5;
        this.movieTimeTableValue6 = movieTimeTableValue6;
        this.movieTimeTableValue7 = movieTimeTableValue7;
        this.movieTimeTableValue8 = movieTimeTableValue8;
        this.movieTimeTableValue9 = movieTimeTableValue9;
        this.movieTimeTableValue10 = movieTimeTableValue10;
        

    }
    public String getmovieName() {
        return movieName;
    }
    public void setName(String name) {
        this.movieName = movieName;
    }
    //=======================================
    public String getmovieTimeTableValue1() {
        return movieTimeTableValue1;
    }
    public void setmovieTimeTableValue1(String movieTimeTableValue1) {
        this.movieTimeTableValue1 = movieTimeTableValue1;
    }
    //=======================================
    public String getmovieTimeTableValue2() {
        return movieTimeTableValue2;
    }
    public void setmovieTimeTableValue2(String movieTimeTableValue2) {
        this.movieTimeTableValue2 = movieTimeTableValue2;
    }
    //=======================================
    public String getmovieTimeTableValue3() {
        return movieTimeTableValue3;
    }
    public void setmovieTimeTableValue3(String movieTimeTableValue3) {
        this.movieTimeTableValue3 = movieTimeTableValue3;
    }
    //=======================================
    public String getmovieTimeTableValue4() {
        return movieTimeTableValue4;
    }
    public void setmovieTimeTableValue4(String movieTimeTableValue4) {
        this.movieTimeTableValue4 = movieTimeTableValue4;
    }
    //=======================================
    public String getmovieTimeTableValue5() {
        return movieTimeTableValue5;
    }
    public void setmovieTimeTableValue5(String movieTimeTableValue5) {
        this.movieTimeTableValue5 = movieTimeTableValue5;
    }
  //=======================================
    public String getmovieTimeTableValue6() {
        return movieTimeTableValue6;
    }
    public void setmovieTimeTableValue6(String movieTimeTableValue6) {
        this.movieTimeTableValue6 = movieTimeTableValue6;
    }
  //=======================================
    public String getmovieTimeTableValue7() {
        return movieTimeTableValue7;
    }
    public void setmovieTimeTableValue7(String movieTimeTableValue7) {
        this.movieTimeTableValue7 = movieTimeTableValue7;
    }
  //=======================================
    public String getmovieTimeTableValue8() {
        return movieTimeTableValue8;
    }
    public void setmovieTimeTableValue8(String movieTimeTableValue8) {
        this.movieTimeTableValue8 = movieTimeTableValue8;
    }
  //=======================================
    public String getmovieTimeTableValue9() {
        return movieTimeTableValue9;
    }
    public void setmovieTimeTableValue9(String movieTimeTableValue9) {
        this.movieTimeTableValue9 = movieTimeTableValue9;
    }
  //=======================================
    public String getmovieTimeTableValue10() {
        return movieTimeTableValue10;
    }
    public void setmovieTimeTableValue10(String movieTimeTableValue10) {
        this.movieTimeTableValue10 = movieTimeTableValue10;
    }
    
  
    
    
    
}*/