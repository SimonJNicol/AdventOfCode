import java.io.*;
import java.lang.String;
import java.lang.Character;
import java.util.Arrays;

public class Prob419 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
		int answer = checker(listing);
		System.out.println(answer); 

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

    public static int checker (String[] listing) {

        String temp = ""; //stores the current number as a string for manipulation
        int count = 0; //current number of applicable passwords
        String[] dclist = listing[0].split("-"); //https://www.geeksforgeeks.org/split-string-java-examples/
        int[] range = {Integer.parseInt(dclist[0]), Integer.parseInt(dclist[1])};

        for (int i = range[0]; i < range[1]; i++) {
            
            temp = Integer.toString(i);
            //https://www.geeksforgeeks.org/different-ways-for-integer-to-string-conversions-in-java/

            if (adjcheck(temp) && asscheck(temp)) {
                count++;
            }
        }
        return count;
    }

    public static boolean adjcheck (String temp) {
      
        boolean adjdig = false;
       
        if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || //don't judge me
            temp.charAt(2) == temp.charAt(3) || temp.charAt(3) == temp.charAt(4) || 
            temp.charAt(4) == temp.charAt(5)) {
                adjdig = true; //this bool keeps track of whether the current number follows the adjacent digit rule 
            }
       
        return adjdig;
    }
    
    public static boolean asscheck (String temp) {
      
        boolean ascend = false;
        
        //https://www.javatpoint.com/java-char-to-int       
        if (Character.getNumericValue(temp.charAt(0)) <= Character.getNumericValue(temp.charAt(1)) && //seriously, no judging
            Character.getNumericValue(temp.charAt(1)) <= Character.getNumericValue(temp.charAt(2)) &&
            Character.getNumericValue(temp.charAt(2)) <= Character.getNumericValue(temp.charAt(3)) &&
            Character.getNumericValue(temp.charAt(3)) <= Character.getNumericValue(temp.charAt(4)) && 
            Character.getNumericValue(temp.charAt(4)) <= Character.getNumericValue(temp.charAt(5))) {
                ascend = true; //this bool keeps track of whether the current number follows the ascending rule
            } 
        
        return ascend;
    }
}