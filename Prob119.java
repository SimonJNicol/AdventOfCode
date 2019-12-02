import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob119 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader(); // reader class reads the input.txt file and stores each line in the string array listing
		int answer = checker(listing); // checker applies the rules of the problem to the input file and returns the answer
		System.out.println(answer); // Now that's a sexy main class

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

	public static int checker(String[] listing) {
	
		int count = 0;
		int[] temp2 = new int[listing.length]; // this would have helped a lot for previous problems, keep in mind in future

		for (int i = 0; i<listing.length; i++) {
			
			temp2[i] = Integer.parseInt(listing[i]) / 3 - 2; // rounding will be automatically done by the type int
			count += temp2[i];
			
		}
		
		return count; 

	}
}