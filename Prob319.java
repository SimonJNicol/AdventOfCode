import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob319 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
        String[] dclist = listing[0].split(",");
//		int answer = checker(listing);
		System.out.println(dclist[0]); 

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
    
//    public static int distance () {

//    }

//    public static String[] decrypter (String[] listing) {

//    }
    
}