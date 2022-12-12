import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class DataFile {
    String DfileName;
    String IfileName;
    
    //setter and getter
    public String getDfileName() {
		return DfileName;
	}

	public void setDfileName(String dfileName) {
		DfileName = dfileName;
	}

	public String getIfileName() {
		return IfileName;
	}

	public void setIfileName(String ifileName) {
		IfileName = ifileName;
	}
    
    // constructor
 	public DataFile(String DfileName, String IfileName) {
 		this.DfileName = DfileName;
 		this.IfileName = IfileName;
 	}
    
	
	ArrayList <String> loadDirectory(){
		Scanner infile = null;
		try { infile = new Scanner(new FileReader(getDfileName())); }
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
			System.exit(0);
		}
		ArrayList <String> lineList = new ArrayList <String>();
		while(infile.hasNextLine())
		{	
			String line = infile.nextLine();
			lineList.add(line);	
		}
		infile.close();
		return lineList;
		
	}
	
	ArrayList <Integer> loadSampleInput(){
		Scanner infile = null;
		try { infile = new Scanner(new FileReader(getIfileName())); }
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
			System.exit(0);
		}
		ArrayList <Integer> productList = new ArrayList<Integer>();
		while(infile.hasNextLine())
		{	
			int digit = Integer.parseInt(infile.nextLine());
			productList.add(digit);	
		}
		infile.close();
		return productList;
	}
	

}
