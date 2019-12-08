import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob819 {
	
 	public static void main (String[] args) throws IOException {

        String[] listing = reader();
        System.out.println(verifier(listing));
    
    }

    public static int verifier (String[] listing) {

        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        int nLayer = 0;
        int count0 = 0;
        int count12 = 0;

        for(int i = 0; i < listing.length; i++) { 
            for(int k = 0; k < 25; k++) {
                if(listing[i].charAt(k) == '0') {
                    n0++;
                }
                else if(listing[i].charAt(k) == '1') {
                    n1++;
                }
                else if(listing[i].charAt(k) == '2') {
                    n2++;
                }
                else {
                    System.out.println("Unknown pixel encountered. ###ERROR###");
                }
            }

            if (i % 6 == 0) {
                
                if (n0 < count0 || count0 == 0) {
                    count0 = n0;
                    nLayer = i/6;
                    count12 = n1 * n2;
                }

            }
        }

        return count12;
    }

    public static String[] reader () throws IOException {
		
		int max_lines = 16384;
   		String[] temp = new String[max_lines];
   		int i = 0;
        int k = 0;
        String listing = "";
        

	   // https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
		
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
     			for(String line; (line = br.readLine()) != null; ) {
     				listing = listing.concat(line);
       				i++;
			}
		}
        i = 0;
        
        String[] formattedList = new String[listing.length()/25];
        for (int c = 0; c < formattedList.length; c++)
            formattedList[c] = ""; //must initialize each string to avoid null pointer exception
        for(int c = 0; c < listing.length(); c++) { //creates lines of 25 character length for each row of the screen
            if(i > 24) {
                i = 0;
                k++;
            }
            formattedList[k] = formattedList[k].concat(String.valueOf(listing.charAt(c))); 
            i++;
        }
		
		return formattedList;
	}
}