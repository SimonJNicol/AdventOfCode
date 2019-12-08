import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Prob619p2 {
	
 	public static void main (String[] args) throws IOException {
		
		String[] listing = reader(); //each line of the input file
        int count = 0; //count will store the current number of orbit connections
        List<List<String>> planets = formatter(listing); //formats the input file into a 2d array of each set of orbitting planets.
        List<List<String>> paths = new ArrayList<List<String>>(3);
        paths.add(new ArrayList<String>());
        paths.add(new ArrayList<String>()); //2d arrays need to be instantiated in java, see comment in formatter method

        for(int i = 0; i < planets.size(); i++)
            count += orbits(planets, paths, i, 0, -1) + 1; //the orbits method recursively checks for if there are any indirect connections and totals them.
        
        System.out.println("The number of direct and indirect orbitals is: " + count); //Part 1's answer
        count = 0;
        System.out.println("Santa's Path: " + paths.get(0));
        System.out.println("Our Path: " + paths.get(1));
        paths.add(intersections(paths.get(0), paths.get(1)));
        System.out.println("Common elements between paths: " + paths.get(2));
        System.out.println("Number of orbitals between YOU and SAN: " + connector(paths)); //Part 2's answer
	}
	
    public static int orbits (List<List<String>> planets, List<List<String>> paths, int i, int subcount, int tracker) {
        //i = current planet we are checking for indirect orbits; c = current planet we are checking planet i against.
        for(int c = 0; c < planets.size(); c++) {

            if (planets.get(i).get(1).equals("SAN")) 
                tracker = 0;
            else if (planets.get(i).get(1).equals("YOU"))
                tracker = 1;
            if (planets.get(i).get(0).equals(planets.get(c).get(1))) { //https://stackoverflow.com/questions/658953/if-statement-with-string-comparison-fails
                System.out.print(planets.get(i).get(0) + " is connected to " + planets.get(c).get(0) + " ");
                subcount += 1;
                i = c; 
                if (tracker != -1)
                    paths.get(tracker).add(planets.get(c).get(0));
                break;
            }
            else if (c == planets.size()-1) {
                System.out.println("---");
                return subcount;
            }
        }
        return orbits(planets, paths, i, subcount, tracker);
    }
    
    public static List<List<String>> formatter (String [] listing) {

        String[] splitList = splitter(listing);
        List<List<String>> planets = new ArrayList<List<String>>(listing.length); //https://stackoverflow.com/questions/16956720/how-to-create-an-2d-arraylist-in-java

        for(int i = 0; i < listing.length * 2; i += 2) {
            planets.add(new ArrayList<String>());
            planets.get(i/2).add(splitList[i]);
            planets.get(i/2).add(splitList[i+1]);

        }
        return planets;
    }

    public static String[] splitter (String [] listing) {
        
        String line = "";
		for (int i = 0; i < listing.length; i++) {
			line = line.concat(listing[i]);
            line = line.concat(")");
        }
		
        String[] splitList = line.split("\\)"); //https://stackoverflow.com/questions/15236108/groovy-java-split-string-on-parentheses
        return splitList;
    }

    public static int connector (List<List<String>> paths) {
        int count = 0;
        for(int i = 0; i < paths.get(0).size(); i++) {
            if(paths.get(0).get(i).equals(paths.get(2).get(0)))
                count += i;
            if(paths.get(1).get(i).equals(paths.get(2).get(0)))
                count += i;
        }
        return count + 2; //the first two orbitals which SAN and YOU are connected to are left out of the list, so I add two here.
    }

    public static List<String> intersections (List<String> a, List<String> b) {       
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < a.size(); i++) {
            for(int c = 0; c < b.size(); c++) {
                if (a.get(i).equals(b.get(c))) {
                    temp.add(b.get(c));
//                    System.out.println("Paths intersect at " + b.get(c));
//                    System.out.println(temp);
                }
            }
        }
        return temp;
    }

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
}