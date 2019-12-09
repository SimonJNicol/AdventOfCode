import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob819p2 {
	
 	public static void main (String[] args) throws IOException {

        String[] listing = reader();
        System.out.println(verifier(listing));
        for (int i = 0; i < 6; i++)
            System.out.println(render(listing, i));

    }

    public static String render (String[] listing, int i) {
        return listing[i];
    }

    public static int verifier (String[] listing) {

        int currentN0 = 0;
        int n1 = 0;
        int n2 = 0;
        int lowestN0 = 0;
        int count = 0;

        for(int i = 0; i < listing.length; i++) { 
            
            for(int k = 0; k < listing[i].length(); k++) {
                if(listing[i].charAt(k) == '0') {
                    currentN0++;
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
            
            if (i % 6 == 5) {
                if (currentN0 < lowestN0 || lowestN0 == 0) {
                    lowestN0 = currentN0;
                    count = n1 * n2;
                }
                currentN0 = 0;
                n1 = 0;
                n2 = 0;
            }
        }
        
        return count;
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