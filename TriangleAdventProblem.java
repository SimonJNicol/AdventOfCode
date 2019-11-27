// I have been having trouble getting JDK to run properly on my machine, so I'm not sure if this will compile, but I think it does.
// I chose not to use subroutines because we never have to use a loop or action more than once, which makes subroutines pointless in 
// this instance.
public class Day3 {
	public static void main (String [] args) {
		// it would probably be better to use a different scanner that doesn't rely on my machine's file pathing. 
		Scanner s = new Scanner(new File(C:\cygwin64\home\code\input.txt));
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
		while (w < 16384) {
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


		
		
