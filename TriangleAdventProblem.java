// I chose not to use subroutines because we never have to use a loop or action more than once, which makes subroutines pointless in 
// this instance.
import java.util.Scanner;
import java.util.*;
public class TriangleAdventProblem {
	public static void main (String [] args) {
		Scanner s = new Scanner("input.txt");
 		int i = 0; 
		int [] tris = new int [16384];
		while(s.hasNextInt()) {
			tris[i] = scanner.nextInt(); //this loop scans the input folder and stores integers in the array tris[]
			i++;
		}
		int count = 0;
		int a = 0; // ints abc keep track of our place within the tris[] array.
		int b = 1;
		int c = 2;
		int w = 0; // this is a bit of a copout to just run the loop 16384 times, but it works for this case.
		while (w < 16383) {
		if ( tris[a] < tris[b] + tris[c] && tris[b] < tris[a] + tris[c] && tris[c] < tris[a] + tris[b]) {
		count++; // this loop counts the number of triangles
		}
		a += 3;
		b += 3;
		c += 3;
		w++;
		}
		System.out.println(count);
	}
}


		
		
