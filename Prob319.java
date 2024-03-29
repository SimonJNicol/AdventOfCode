import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Prob319 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
		int answer = distance(decrypter(listing, 0), decrypter(listing, 1));
		System.out.println("The closest cross has a manhattan distance of: " + answer); 

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
    
    public static int distance (String[] dclist, String[] dclist2) {

        int xc = 0; //keeps track of x's value throughout each iteration of the loop
        int yc = 0; // "" y's value
        int xc2 = 0; // "" x2's value
        int yc2 = 0; //"" y2's value
        int instruction = 0; //stores the value of the current input direction
        int[] location = {0,0}; //stores the location of the nearest cross
        boolean horz = false; //identifies whether a line is horizontal or vertical
        boolean vert = false;

        List<Integer> x = new ArrayList<Integer>(); //stores the x coordinate after each step is completed (corners) for wire 1
        List<Integer> y = new ArrayList<Integer>(); // "" y coordinate "" for wire 1
        List<Integer> x2 = new ArrayList<Integer>();// "" x2 coordinate "" for wire 2
        List<Integer> y2 = new ArrayList<Integer>();// "" y2 coordinate "" for wire 2

        x.add(0,0);
        y.add(0,0);
        x2.add(0,0);
        y2.add(0,0);

        for (int i = 0; i < dclist.length; i++) {
            
            instruction = Integer.parseInt(dclist[i].substring(1, dclist[i].length()));
            
            switch (dclist[i].charAt(0)) {
                case 'R':
                    xc += instruction;
                    x.add(i+1, xc);
                    y.add(i+1, yc);
                break;
                case 'L': 
                    xc -= instruction;
                    x.add(i+1, xc);
                    y.add(i+1, yc);
                    break;
                case 'U': 
                    yc += instruction;
                    x.add(i+1, xc);
                    y.add(i+1, yc);
                break;
                case 'D': 
                    yc -= instruction;
                    x.add(i+1, xc);
                    y.add(i+1, yc);
                break;
            }
        }
        for (int i = 0; i < dclist2.length; i++) {
            
            instruction = Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
            
            switch (dclist2[i].charAt(0)) {
                case 'R':
                    xc2 += instruction;
                    x2.add(i+1, xc2);
                    y2.add(i+1, yc2);
                break;
                case 'L': 
                    xc2 -= instruction;
                    x2.add(i+1, xc2);
                    y2.add(i+1, yc2);
                    break;
                case 'U': 
                    yc2 += instruction;
                    x2.add(i+1, xc2);
                    y2.add(i+1, yc2);
                break;
                case 'D': 
                    yc2 -= instruction;
                    x2.add(i+1, xc2);
                    y2.add(i+1, yc2);
                break;
            }
        }
        for (int i = 0; i < x.size()-1; i++) {
            for (int c = 0; c < x.size()-1; c++) {
                if(between(x.get(c), x2.get(i+1), x2.get(i)) && between(y2.get(i), y.get(c+1), y.get(c))) {
                    System.out.print("Cross at ");
                    System.out.println("[ " + x.get(c) + " , " + y2.get(i) + " ]");
                    if (x.get(c) + y2.get(i) < Math.abs(location[0]) + Math.abs(location[1]) || location[0] + location[1] == 0) {
                        location[0] = x.get(c);
                        location[1] = y2.get(i);
                    }
                }
                else if(between(y.get(c), y2.get(i+1), y2.get(i)) && between(x2.get(i), x.get(c+1), x.get(c))) {
                    System.out.print("Cross at ");
                    System.out.println("[ " + x2.get(i) + " , " + y.get(c) + " ]");
                    if (y.get(c) + x2.get(i) < Math.abs(location[0]) + Math.abs(location[1]) || location[0] + location[1] == 0) {
                        location[0] = x2.get(i);
                        location[1] = y.get(c);
                    }
                }
            }
        }
        return location[0] + location[1];
    }

    public static String[] decrypter (String[] listing, int wire) {
        String[] dclist = listing[wire].split(","); //https://www.geeksforgeeks.org/split-string-java-examples/
        return dclist;
    }
    
    public static boolean between (int n, int max, int min) {
        if (n == 0 || max == 0 || min == 0) {
            n +=1;
            min+=1;
            max+=1;
        }
        if (n >= min && n <= max || n <= min && n >= max)
            return true;
        else 
            return false;
    }
}
