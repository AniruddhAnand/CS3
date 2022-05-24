import java.io.*;
import java.util.*;
public class Runner {
   public static void main(String[] args) throws IOException{
       Scanner fileReader = new Scanner(new File("players.txt"));
       int k = fileReader.nextInt();
       Team knights = new Team(k);
       initializePlayers(fileReader, knights, k);
       printData(knights);
   }
   public static void initializePlayers(Scanner fileReader, Team knights, int k) {    
        String name;
        int number;
        int atBats;
        int hits;
        for (int i = 0; i < k; i++) {
            name = fileReader.next();
            number = fileReader.nextInt();
            atBats = fileReader.nextInt();
            hits = fileReader.nextInt();
            Player p = new Player(name, number, atBats, hits);
            knights.addPlayer(p, i);
        }
    }
    public static void printData(Team knights) {
        knights.printTeamStats();
    }   
}