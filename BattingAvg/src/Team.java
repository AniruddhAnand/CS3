import java.io.*;
import java.util.*;
public class Team {

   Player[] players;
   
   public Team() {
      players = new Player[12];
   }
   
   public Team(int numPlayers) {
      players = new Player[numPlayers];
   }
   
   public void printTeamStats() {
      for (int i = 0; i < players.length; i++) {
         System.out.print(players[i].name + "\t");
         System.out.print("#" + players[i].number + "\t");
         System.out.println("Average >>> <" + players[i].getBattingAverageString() + ">");
      }
   }
}