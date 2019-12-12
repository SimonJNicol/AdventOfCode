public class Prob1219 {

    public static void main (String [] args) {
        
        String[] listing = reader();

    }
	public static String[] reader() throws IOException {
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
class Planet{
    int px, py, pz, vx, vy, vz;
    public Planet (int px, int py, int pz) {
        this.px = px;
        this.py = py;
        this.pz = pz;
        this.vx = 0;
        this.vy = 0;
        this.vz = 0;
    }
    public void updateVelocity (Planet a) {

    }
    public void updatePosition (Planet io, Planet europa, Planet callisto, Planet ganymede) {

    }
    public int getKinetic (Planet a) {

    }
    public int getPotential(Planet a) {

    }
}