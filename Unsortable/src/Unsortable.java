import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Unsortable {
    public static void main(String[] args) {
        Unsortable unsortable = new Unsortable();
        unsortable.sortIt(new Object []{4, 1, 3});
        unsortable.sortIt(new Object []{new int []{4}, new int []{1}, new int []{3}});
        unsortable.sortIt(new Object []{4,new int []{1}, 3});
        unsortable.sortIt(new Object []{new int []{4}, 1,new int []{3}});
        unsortable.sortIt(new Object []{new int []{3}, 4,new int []{2}, new int []{5}, 1, 6});
    }
    //This allows for both single element arrays and integers to be stored in the same array
    public void sortIt(Object [] x){
        LinkedList<Integer> array = new LinkedList<>();
        //This creates a new array to store the numbers
        int [] nums = new int [x.length];
        for(int i=0;i<x.length;i++){
            //This considers whether the array element is an integer or a single item array
            if(x[i] instanceof Integer){
                nums[i] =(int) x[i];
            }else{
                int [] temp = (int [])x[i];
                nums[i] = temp[0];
                array.add(temp[0]);
            }
        }
        //This sorts the array in the best possible time as provided by the java api
        Arrays.sort(nums);
        //This displays the output
        System.out.print("[");
        for(int i=0;i<x.length;i++){
            //This differentiates between an integer value and a single element array
            if(!array.contains(nums[i])){
                System.out.print(nums[i]);
            }else{
                System.out.print("["+nums[i] + "]");
            }
            if(i== x.length-1){
                System.out.println("]");
            }else{
                System.out.print(", ");
            }
        }
    }
}
