import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PhotoShoot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = console.nextInt();
        LinkedList<Integer> x = new LinkedList<>();
        LinkedList<Integer> newX = new LinkedList<>();
        for(int i=0;i<num;i++){
            x.add(console.nextInt());
        }
        for(int i=0;i<num;i++){
            newX.add(console.nextInt());
        }
        int count = 0;
        for(int i=0;i<num;i++){
            int index = x.indexOf(newX.get(i));
            if(index!=i){
                count++;
                int num2 = x.remove(index);
                x.add(i,num2);
            }
        }
        System.out.println(count);
    }
}
