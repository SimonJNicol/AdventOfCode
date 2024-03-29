import java.io.*;
import java.lang.String;
import java.lang.Character;
import java.util.Arrays;

public class Prob419p2 {
	
 	public static void main (String[] args) throws IOException {
		
		String line = reader();
		int answer = checker(line);
		System.out.println(answer); 

	}
						
	public static String reader () throws IOException {
        
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
     		String line = br.readLine();
		return line;
        	//since input was the only line i opted for this reader class to save space and runtime.
		//only grabs one line of file per call
	}

    public static int checker (String line) {

        String temp = ""; //stores the current number as a string for manipulation
        int count = 0; //current number of applicable passwords
        String[] dclist = line.split("-"); //https://www.geeksforgeeks.org/split-string-java-examples/
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
       
        if (temp.charAt(0) == temp.charAt(1) && temp.charAt(2) != temp.charAt(1) || //don't judge my conditionals
            temp.charAt(1) == temp.charAt(2) && temp.charAt(0) != temp.charAt(1) && temp.charAt(3) != temp.charAt(2) ||
            temp.charAt(2) == temp.charAt(3) && temp.charAt(1) != temp.charAt(2) && temp.charAt(4) != temp.charAt(3) || 
            temp.charAt(3) == temp.charAt(4) && temp.charAt(2) != temp.charAt(3) && temp.charAt(5) != temp.charAt(4) || 
            temp.charAt(4) == temp.charAt(5) && temp.charAt(3) != temp.charAt(4)) {
                return true; //this bool keeps track of whether the current number follows the adjacent digit rule 
            }
       
        return false;
    }

    public static boolean asscheck (String temp) {
 
        //https://www.javatpoint.com/java-char-to-int       
        if (Character.getNumericValue(temp.charAt(0)) <= Character.getNumericValue(temp.charAt(1)) && //seriously, no judging
            Character.getNumericValue(temp.charAt(1)) <= Character.getNumericValue(temp.charAt(2)) &&
            Character.getNumericValue(temp.charAt(2)) <= Character.getNumericValue(temp.charAt(3)) &&
            Character.getNumericValue(temp.charAt(3)) <= Character.getNumericValue(temp.charAt(4)) && 
            Character.getNumericValue(temp.charAt(4)) <= Character.getNumericValue(temp.charAt(5))) {
                return true; //this bool keeps track of whether the current number follows the ascending rule
            } 
        
        return false;
    }
}
