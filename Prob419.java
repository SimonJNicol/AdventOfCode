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

        boolean adjdig = false;
        boolean ascend = false;
        int count = 0;
        String[] dclist = listing[0].split("-"); //https://www.geeksforgeeks.org/split-string-java-examples/
        int[] range = {Integer.parseInt(dclist[0]), Integer.parseInt(dclist[1])};

        for (int i = range[0]; i < range[1]; i++) {
            if (dclist[0].charAt(0) == dclist[0].charAt(1) || dclist[0].charAt(1) == dclist[0].charAt(2) || 
            dclist[0].charAt(2) == dclist[0].charAt(3) || dclist[0].charAt(3) == dclist[0].charAt(4) || 
            dclist[0].charAt(4) == dclist[0].charAt(5)) {
                adjdig = true;
                System.out.println("adjdig");
            }
            if (Character.getNumericValue(dclist[0].charAt(0)) > Character.getNumericValue(dclist[0].charAt(1)) || 
            Character.getNumericValue(dclist[0].charAt(1)) > Character.getNumericValue(dclist[0].charAt(2)) || 
            Character.getNumericValue(dclist[0].charAt(2)) > Character.getNumericValue(dclist[0].charAt(3)) || 
            Character.getNumericValue(dclist[0].charAt(3)) > Character.getNumericValue(dclist[0].charAt(4)) || 
            Character.getNumericValue(dclist[0].charAt(4)) > Character.getNumericValue(dclist[0].charAt(1))) {
                ascend = true;
            } 
            if (ascend && adjdig) {
                count++;
            }
            adjdig = false;
            ascend = false;
        }
        return count;
    }
}