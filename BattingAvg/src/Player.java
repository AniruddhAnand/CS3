import java.io.*;
import java.util.*;
public class Player {

   String name;
   int number;
   int atBats;
   int hits;
   
   public Player(String pName, int pNum) {
   
      name = pName;
      number = pNum;
      atBats = 0;
      hits = 0;
   }
   
   public Player(String pName, int pNum, int atB, int pHit) {
   
      name = pName;
      number = pNum;
      atBats = atB;
      hits = pHit;
   }
   
   public double getBattingAverage() {
   
      return (double) hits / atBats;
   }
   
   public String getBattingAverageString() {
   
      return "" + Math.round(getBattingAverage() * 1000) + "";
   }
   
   //2 Riddle- A plant
}