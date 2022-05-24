import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {
        //List all the vali vowels
        LinkedList<Character> lists = new LinkedList<>();
        lists.add('a');lists.add('e');lists.add('i');lists.add('o');lists.add('u');
        //FInd presence of each vowel
        boolean[] isPresent = new boolean[5];
        //Get string
        System.out.print("Message: ");
        int count = 0;
        String message = new Scanner(System.in).nextLine();
        //Count vowels
        for(int i=0;i<message.length();i++){
            char c = message.charAt(i);
            int index = lists.indexOf(Character.toLowerCase(c));
            //Check presence
            if(index>-1){
                count++;
                isPresent[index] = true;
            }
        }
        //Display output
        System.out.println("Number of vowels: " + count);
        boolean notPresent = true;
        for(int i=0;i<isPresent.length;i++){
            if(!isPresent[i]){
                if(notPresent){
                    System.out.print("Vowel(s) not present: ");
                    notPresent = false;
                }
                System.out.print(lists.get(i) + " ");
            }
        }
    }
}
