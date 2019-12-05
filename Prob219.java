import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob219 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
		String line = "";
		for (int i = 0; i < listing.length; i++)
			line = line.concat(listing[i]);
		listing = line.split(",");
		for (int i = 0; i < listing.length; i += 4) {
			switch (Integer.parseInt(listing[i])) {
				case 1:
					listing = opOne(listing, i);
				break;
				case 2:
					listing = opTwo(listing, i);
				break;
				case 99:
					i = listing.length;
				break;
				default:
					System.out.println("Error, unknown opcode present.");
				break;
			}
		}
        for (int i = 0; i < listing.length; i++) {
            if (i == listing.length-1)
                System.out.print(listing[i]);
            else
                System.out.print(listing[i]+","); 
        }
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

	public static String[] opOne(String[] listing, int i) {
		
		int a = Integer.parseInt(listing[Integer.parseInt(listing[i+1])]);
		int b = Integer.parseInt(listing[Integer.parseInt(listing[i+2])]);
		int c = Integer.parseInt(listing[i+3]);
		listing[c] = Integer.toString(a + b);
		return listing;
	}

	public static String[] opTwo(String[] listing, int i) {
		
		int a = Integer.parseInt(listing[Integer.parseInt(listing[i+1])]);
        int b = Integer.parseInt(listing[Integer.parseInt(listing[i+2])]);
		int c = Integer.parseInt(listing[i+3]);
		listing[c] = Integer.toString(a * b);
		return listing;
	}
}