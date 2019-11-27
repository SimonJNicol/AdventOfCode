// I have been having trouble getting JDK to run properly on my machine, so I'm not sure if this will compile, but I think it does.
// I chose not to use subroutines because we never have to use a loop or action more than once, which makes subroutines pointless in 
// this instance.
public class Day3 {
	public static void main (String [] args) {
		Scanner s = new Scanner(new File("input.txt"));
 		int i = 0;
		int [] tris = new int [16384];
		while(s.hasNextInt()) {
			tris[i] = scanner.nextInt();
			i++;
		}
		int count = 0;
		int a = 0;
		int b = 1;
		int c = 2;
		while (w < 16384) {
		if ( i[a] < i[b] + i[c] && i[b] < i[a] + i[c] && i[c] < i[a] + i[b]) {
		count++;
		}
		a += 3;
		b += 3;
		c += 3;
		w++;
		}
		System.out.println(count);
	}
}


		
		
