import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Prob619 {
	
 	public static void main (String[] args) throws IOException {
		
	String[] listing = reader(); //each line of the input file
        int count = 0; //count will store the current number of orbit connections
        List<List<String>> planets = formatter(listing); //formats the input file into a 2d array of each set of orbitting planets.

        for(int i = 0; i < planets.size(); i++) {
        	count += orbits(planets, i, 0) + 1; //the orbits method recursively checks for if there are any indirect connections and totals them.
        }
		
        System.out.println(count); //the answer
		
	}
	
    public static int orbits (List<List<String>> planets, int i, int subcount) {
        //i = current planet we are checking for indirect orbits; c = current planet we are checking planet i against.
        for(int c = 0; c < planets.size(); c++) {
            if (planets.get(i).get(0).equals(planets.get(c).get(1))) { //https://stackoverflow.com/questions/658953/if-statement-with-string-comparison-fails
                subcount += 1;
                i = c; 
                break;
            }
            else if (c == planets.size()-1) 
                return subcount;
		
        }
        return orbits(planets, i, subcount);
    }
    
    public static List<List<String>> formatter (String [] listing) {

        String[] splitList = splitter(listing);
        List<List<String>> planets = new ArrayList<List<String>>(listing.length); //https://stackoverflow.com/questions/16956720/how-to-create-an-2d-arraylist-in-java

        for(int i = 0; i < listing.length * 2; i += 2) {
        	planets.add(new ArrayList<String>());
        	planets.get(i/2).add(splitList[i]);
         	planets.get(i/2).add(splitList[i+1]);
        }
        return planets;
    }

    public static String[] splitter (String [] listing) {
        
        String line = "";
		for (int i = 0; i < listing.length; i++) {
			line = line.concat(listing[i]);
            line = line.concat(")");
        }
		
        String[] splitList = line.split("\\)"); //https://stackoverflow.com/questions/15236108/groovy-java-split-string-on-parentheses
        return splitList;
    }

	public static String[] reader () throws IOException {
		
		int max_lines = 16384;
   		String[] temp = new String[max_lines];
   		int i=0;

	   // https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
		
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
     		for(String line; (line = br.readLine()) != null; ) {
     			temp[i] = line;
       			i++;
			}
		}

   		String[] listing = new String[i];
   		for ( i=0; i<listing.length; i++ ) {
   			listing[i] = temp[i];
   		}
		
		return listing;
	}
}
