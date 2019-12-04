import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Prob319 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader();
        String[] dclist = decrypter(listing, 0);
        String[] dclist2 = decrypter(listing, 1);
		int answer = distance(dclist, dclist2);
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
    
    public static int distance (String[] dclist, String[] dclist2) {

        int temp = 0; //use temp to iterate through the x and y arrays
        int xc = 0;
        int yc = 0;
        int xc2 = 0;
        int yc2 = 0;
//        int cordsize = 0;
        int count = 0;
        int count2 = 0;
        int[] location = {0,0};
//        cordsize = asize(dclist, dclist2);

//        int[] x = new int[cordsize];
//        int[] y = new int[cordsize];
//        int[] x2 = new int[cordsize];
//        int[] y2 = new int[cordsize];
//        String x = "";
//        String y = "";
//        String x2 = "";
//        String y2 = "";
        // thought about using StringBuilder to store the arrays with dynamic sizing, but found a better option
        //https://www.geeksforgeeks.org/list-interface-java-examples/

        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        List<Integer> x2 = new ArrayList<Integer>();
        List<Integer> y2 = new ArrayList<Integer>();

        for (int i = 0; i < dclist.length; i++) {
            switch (dclist[i].charAt(0)) {
                case 'R':
//                    while (xc < xc + Integer.parseInt(dclist[i].substring(1, dclist[i].length()))) {
//                        x[xc] = xc;
//                        xc++;
                    for (int c = 0; c < Integer.parseInt(dclist[i].substring(1, dclist[i].length())); c++) {
                        x.add(count, xc);
                        y.add(count, yc);
                        xc++;
                        count++;
                    }
                    break;
                case 'L': 
//                    while (xc < xc + Integer.parseInt(dclist[i].substring(1, dclist[i].length()))) {
//                        x[xc] = xc;
//                        xc--;
                    for (int c = 0; c < Integer.parseInt(dclist[i].substring(1, dclist[i].length())); c++) {
                        x.add(count, xc);
                        y.add(count, yc);
                        xc--;
                        count++;
                    }
                    break;
                case 'U': 
//                    while (yc < yc + Integer.parseInt(dclist[i].substring(1, dclist[i].length()))) {
//                        y[yc] = yc;
//                        yc++;
                    for (int c = 0; c < Integer.parseInt(dclist[i].substring(1, dclist[i].length())); c++) {
                        x.add(count, xc);
                        y.add(count, yc);
                        yc++;
                        count++;
                    }
                case 'D': 
//                    while (yc < yc + Integer.parseInt(dclist[i].substring(1, dclist[i].length()))) {
//                        y[yc] = yc;
//                        yc--;
                    for (int c = 0; c < Integer.parseInt(dclist[i].substring(1, dclist[i].length())); c++) {
                        x.add(count, xc);
                        y.add(count, yc);
                        yc--;
                        count++;
                    }
                    break;
            }
        }

        for (int i = 0; i < dclist2.length; i++) {
            switch (dclist2[i].charAt(0)) {
                case 'R': 
//                    while (xc2 < xc2 + Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()))) {
//                        x[xc2] = xc2;
//                        xc2++;
                    for (int c = 0; c < Integer.parseInt(dclist2[i].substring(1, dclist2[i].length())); c++) {
                        x2.add(count2, xc2);
                        y2.add(count2, yc2);
                        xc2++;
                        count2++;
                    }
                    break;
                case 'L': 
//                    while (xc2 < xc2 + Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()))) {
//                        x[xc2] = xc2;
//                        xc2--;
                    for (int c = 0; c < Integer.parseInt(dclist2[i].substring(1, dclist2[i].length())); c++) {
                        x2.add(count2, xc2);
                        y2.add(count2, yc2);
                        xc2--;
                        count2++;
                    }
                    break;
                case 'U': 
//                    while (yc2 < yc2 + Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()))) {
//                        y[yc2] = yc2;
//                        yc2++;
                    for (int c = 0; c < Integer.parseInt(dclist2[i].substring(1, dclist2[i].length())); c++) {
                        x2.add(count2, xc2);
                        y2.add(count2, yc2);
                        yc2++;
                        count2++;
                    }
                case 'D': 
//                    while (yc2 < yc2 + Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()))) {
//                        y[yc2] = yc2;
//                        yc2--;
                    for (int c = 0; c < Integer.parseInt(dclist2[i].substring(1, dclist2[i].length())); c++) {
                        x2.add(count2, xc2);
                        y2.add(count2, yc2);
                        yc2--;
                        count2++;
                        System.out.println("[" + x2.get(c) + "," + y2.get(c) + "]" + " " + count2);
                    }
            }
        }
        // iF yoU'rE rEaDinG thIs PlEASe HelP
        for (int i = 0; i < x.size(); i++) {
            for (int k = 0; k < x.size(); k++) {
                if (x.get(k) == x2.get(i) && y.get(k) == y2.get(i) && location[0] == 0 && location[1] == 0) {
                    location[0] = x.get(k); 
                    location[1] = y.get(k);
                    System.out.println("POP " + location[0] + " " + location[1]);
                }
                else if (x.get(k) == x2.get(i) && y.get(k) == y2.get(i) && Math.abs(x.get(k) + y.get(k)) < Math.abs(location[0] + location[1])) {
                    location[0] = x.get(k);
                    location[1] = y.get(k);
                    System.out.println("Hit");
                }
            }
        }
        return location[0] + location[1];
    }

    public static String[] decrypter (String[] listing, int wire) {
        String[] dclist = listing[wire].split(","); //https://www.geeksforgeeks.org/split-string-java-examples/
        return dclist;
    }

/*    public static int asize (String[] dclist, String[] dclist2) {
        int count = 0;
        for (int i = 0; i < dclist.length; i++) {
            switch(dclist[i].charAt(0)) {
                case 'R':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'L':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'U':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'D':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
            }
        }
        for (int i = 0; i < dclist.length; i++) {
            switch(dclist2[i].charAt(0)) {
                case 'R':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'L':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'U':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
                case 'D':
                    count += Integer.parseInt(dclist2[i].substring(1, dclist2[i].length()));
            }
        }
    System.out.println(count);
    return count;
    } */
}
