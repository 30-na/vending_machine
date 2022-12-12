import java.util.ArrayList;

public class DataFile {
	//load data from file
    DataFile myData = new DataFile("./Directory/directory1.txt", "./Input/input.txt");
    
    String DfileName;
    String IfileName;
 
    // constructor
 	public DataFile(String DfileName, String IfileName) {
 		this.DfileName = DfileName;
 		this.IfileName = IfileName;
 	}
    
	
	ArrayList <String> loadDirectory(){
		ArrayList <String> a = new ArrayList <String>();
		return a;
	}
	
	ArrayList <Integer> loadSampleInput(){
		ArrayList <Integer> productList = new ArrayList<Integer>();
		return productList;
	}

}
