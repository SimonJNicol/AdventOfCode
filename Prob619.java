import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Prob619 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
        int size = listing.length;
        int count = 0;
        String line = "";
		for (int i = 0; i < listing.length; i++) {
			line = line.concat(listing[i]);
            line = line.concat(")");
        }
		
        String[] splitList = line.split("\\)");

//      https://stackoverflow.com/questions/16956720/how-to-create-an-2d-arraylist-in-java
       
        List<List<String>> planets = new ArrayList<List<String>>(size); 

        for(int i = 0; i < size*2; i += 2) {
            planets.add(new ArrayList<String>());
            planets.get(i/2).add(splitList[i]);
            planets.get(i/2).add(splitList[i+1]);

        }

        for(int i = 0; i < planets.size(); i++) {
            count += orbits(planets, i, 0);
        }

        System.out.println(count);
	}
	
    public static int orbits (List<List<String>> planets, int i, int subcount) {
        subcount += 1;
        
        for(int c = 0; c < planets.size(); c++) {
            if (planets.get(i).get(0).equals(planets.get(c).get(1))) {
                subcount += 1;
                i = c; //might be a problem with using the proper index
                System.out.print(planets.get(i).get(0) + " is connected to " + planets.get(c).get(1) + " ");
                break;
            }
            else if (c == planets.size()-1) {
                System.out.println("---");
                return subcount;
            }
        }
        return orbits(planets, i, subcount);
    }
		// minus a couple changes, the reader class is copied from Ian's github.

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