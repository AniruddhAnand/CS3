import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cemetery {
    private ArrayList<Tombstone> tombstones;
    public Cemetery(String filename) throws IOException {
        tombstones = new ArrayList<>();
        Scanner console = new Scanner(new File(filename));
        while(console.hasNext()){
            Scanner line = new Scanner(console.nextLine());
            String name = "";
            while(!line.hasNextInt()){
                name+=line.next() + " ";
            }
            String burialDate = line.next() + " " +  line.next() + " " +  line.next();
            int age = parseAge(line.next());
            String address = "";
            while(line.hasNext()){
                address += line.next() + " ";
            }
            tombstones.add(new Tombstone(name,burialDate,age,address));
        }
    }
    public int getNumTombs(){
        return tombstones.size();
    }
    public Tombstone getTombstone(int index){
        if(index<0||index>getNumTombs()){
            return null;
        }
        return tombstones.get(index);
    }
    public static int parseAge(String ageString) {
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;

        boolean done = true;

        try {
            result = Integer.parseInt(ageString);
        } //is the String a whole number of years?

        catch (NumberFormatException n) {
            done = false;
        }

        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years

        double ageDouble = 0;

        done = true;

        try {
            ageDouble = Double.parseDouble(ageString);
        } //is the String a floating point number of years?

        catch (NumberFormatException n) {
            done = false;
        }

        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int) (ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }

        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }

        return 0;
    }
}
