import java.io.*;
import java.lang.String;
import java.util.Arrays;

public class Prob1219 {

    public static void main (String [] args) throws CloneNotSupportedException, IOException {
        
//        String[] listing = reader();
        Planet Io = new Planet();
        Planet Callisto = (Planet) Io.clone();
        Planet Ganymede = (Planet) Io.clone();
        Planet Europa = (Planet) Io.clone();
        int[] count = new int[4];
        Io.initPlanet(13,-13,-2);
        Callisto.initPlanet(16,2,-15);
        Ganymede.initPlanet(7,-18,-12);
        Europa.initPlanet(-3,-8,-8);
            
        for (int i = 0; i < 1000; i++) {

            Io.updateVelocity(Callisto, Ganymede, Europa);
            Callisto.updateVelocity(Ganymede, Europa, Io);
            Ganymede.updateVelocity(Callisto, Io, Europa);
            Europa.updateVelocity(Callisto, Ganymede, Io);

            Io.updatePosition(Io);
            Callisto.updatePosition(Callisto);
            Ganymede.updatePosition(Ganymede);
            Europa.updatePosition(Europa);

            System.out.println("Step: " + i);
            Io.print();
            Callisto.print();
            Ganymede.print();
            Europa.print();

        }
    count[0] = Io.getEnergy();
    count[1] = Callisto.getEnergy();
    count[2] = Ganymede.getEnergy();
    count[3] = Europa.getEnergy();
    System.out.println(count[0]+count[1]+count[2]+count[3]);
    }



/*	public static String[] reader() throws IOException {
   		String[] temp = new String[4];
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

	} */
}
class Planet implements Cloneable{ //https://stackoverflow.com/questions/46724212/change-values-in-object-java
    int px, py, pz, vx, vy, vz;
    
    public Planet () {
        this.px = 0;
        this.py = 0;
        this.pz = 0;
        this.vx = 0;
        this.vy = 0;
        this.vz = 0;
    }
    public void initPlanet (int px, int py, int pz) {
        this.px = px;
        this.py = py;
        this.pz = pz;
    }
    public void updatePosition (Planet a) {
        this.px += this.vx;
        this.py += this.vy;
        this.pz += this.vz;
    }

    public void updateVelocity (Planet a, Planet b, Planet c) {
        int[] xCords = new int[3];
        int[] yCords = new int[3];
        int[] zCords = new int[3];
        xCords[0] = a.px;
        yCords[0] = a.py;
        zCords[0] = a.pz;
        xCords[1] = b.px;
        yCords[1] = b.py;
        zCords[1] = b.pz;
        xCords[2] = c.px;
        yCords[2] = c.py;
        zCords[2] = c.pz;
        for (int i = 0; i < 3; i++) {
            if (this.px > xCords[i])
                this.vx -= 1;
            else if (this.px < xCords[i])
                this.vx += 1;
            if (this.py > yCords[i])
                this.vy -= 1;
            else if (this.py < yCords[i])
                this.vy += 1;
            if (this.pz > zCords[i])
                this.vz -= 1;
            else if (this.pz < zCords[i])
                this.vz += 1;
        }
    }
    
    public int getEnergy () {
        return (Math.abs(this.vx) + Math.abs(this.vy) + Math.abs(this.vz)) * (Math.abs(this.px) + Math.abs(this.py) + Math.abs(this.pz));
    }

    public void print () {
        System.out.print("Pos: <x = " + this.px + "> <y = " + this.py + "> <z = " + this.pz + ">   ");
        System.out.println("Vel: <x = " + this.vx + "> <y = " + this.vy + "> <z = " + this.vz + ">");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException { //https://stackoverflow.com/questions/46724212/change-values-in-object-java
        // TODO Auto-generated method stub
        return (Planet)super.clone();  
    }
}