import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob819p2 {
	
 	public static void main (String[] args) throws IOException {
        
        String[] listing = reader();
        System.out.println(verifier(listing)); //part 1
        for (int i = 0; i < 6; i++) { //evaluates each row of pixels
            for(int c = 0; c < 25; c++) { //evaluates each column of pixels
                System.out.print(render(listing, i, c)); //returns first '0' or '1' found for each pixel.
            }
            System.out.println();
        }

    }

    public static char render (String[] listing, int i, int c) { //part 2 code
         
        switch(listing[i].charAt(c)) {
            case '0':
                return '0';
            case '1':
                return '1';
        }
        return render(listing, i+6, c); //i+6 searches the same row and column of pixel, but the next layer 
    }

    public static int verifier (String[] listing) { //part 1 code

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
            
            if (i % 6 == 5) { //seperates and resets each layer count
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

    public static String[] reader () throws IOException { //input code, formats input into 25 character long lines
		
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
        
        String[] formattedList = new String[listing.length()/25];
        for (int c = 0; c < formattedList.length; c++)
            formattedList[c] = ""; //must initialize each string to avoid null pointer exception
        for(int c = 0; c < listing.length(); c++) { //creates lines of 25 character length for each row of the screen
            formattedList[k] = formattedList[k].concat(String.valueOf(listing.charAt(c))); 
            if(c % 25 == 24) {
                k++;
            }
        }
		return formattedList;
	}
}