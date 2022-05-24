import java.time.LocalDateTime;
import java.util.*;

public class RecursiveProbs {
    public static void main(String[] args){
        RecursiveProbs probs = new RecursiveProbs();
        probs.printBinary(3);
        System.out.println();
        probs.climbStairs(4);
        probs.campsite(2,1);
        System.out.println(probs.getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));
        System.out.println(probs.makeChange(25));
        System.out.println(probs.longestCommonSub("ABCDEFG","BGCEHAF"));
    }
    public void printBinary(int n){
        printBinaryHelper(n,"");
    }
    public void printBinaryHelper(int n, String s){
        if(n==0){
            System.out.print(s + "\t");
            return;
        }
        printBinaryHelper(n-1,s+0);
        printBinaryHelper(n-1,s+1);
    }
    void climbStairs(int steps){
        //climbStairsHelper(new Stack<>(), steps);
        climbStairsHelper(steps,"");
    }
    void climbStairsHelper(int steps,String s){
        if(steps==0){
            System.out.println(s);
            return;
        }
        s+=1 + " ";
        climbStairsHelper(steps-1,s);
        s = s.substring(0,s.length()-2);
        if(steps>1){
            s+=2 + " ";
            climbStairsHelper(steps-2,s);
            s = s.substring(0,s.length()-2);
        }
    }
    void campsite(int x, int y){
        campsiteHelper(x,y,"");
    }
    void campsiteHelper(int x, int y, String s){
        if(x==0 && y==0){
            System.out.println(s);
            return;
        }
        if(x>0) {
            s+="E ";
            campsiteHelper(x-1,y,s);
            s = s.substring(0, s.length() - 2);
        }
        if(y>0) {
            s+="N ";
            campsiteHelper(x,y-1,s);
            s = s.substring(0, s.length() - 2);
        }
        if(x>0&&y>0) {
            s+="NE ";
            campsiteHelper(x-1,y-1,s);
            s = s.substring(0, s.length() - 3);
        }
    }
    //fix
    public int getMax(List<Integer> nums, int limit){
        return getMaxHelper(nums,limit,0,0);
    }
   public int getMaxHelper(List<Integer> nums,int limit, int index, int current){
       if(current>limit){
           return Integer.MIN_VALUE;
       }
       if(index>=nums.size()){
           return current;
       }
       return Math.max(getMaxHelper(nums,limit,index+1,current+nums.get(index)),getMaxHelper(nums,limit,index+1,current));
    }
    //fix
    public int makeChange(int amount){
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(1);coins.add(5);coins.add(10);coins.add(25);
        int [] vals = new int[4];
        System.out.println(" P  N  D  Q ");
        System.out.println("------------");
        printMakeChangeHelper(coins,0,0,amount,vals);
        return makeChangeHelper(coins,0,0,amount);
    }
    private int makeChangeHelper(List<Integer>coins, int i, int current, int amount){
        if(i>=coins.size()){
            return 0;
        }
        if(current==amount){
            return 1;
        }
        if(current>amount){
            return 0;
        }
        return makeChangeHelper(coins,i,current+coins.get(i),amount)+ makeChangeHelper(coins,i+1,current,amount);
    }
    private void printMakeChangeHelper(List<Integer>coins, int i, int current, int amount, int[] nums){
        if(i>=coins.size()){
            return;
        }
        if(current==amount){
            System.out.println(Arrays.toString(nums));
            return;
        }
        if(current>amount){
            return;
        }
        nums[i]++;
        printMakeChangeHelper(coins,i,current+coins.get(i),amount,nums);
        nums[i]--;
        printMakeChangeHelper(coins,i+1,current,amount,nums);
    }
    String longestCommonSub(String a, String b){
        if(a.length()==0||b.length()==0){
            return "";
        }
        if(a.charAt(0)==b.charAt(0)){
            return a.charAt(0) + longestCommonSub(a.substring(1),b.substring(1));
        }else{
            String temp = longestCommonSub(a.substring(1),b);
            String temp2 = longestCommonSub(a,b.substring(1));
            if(temp.length()>temp2.length()){
                return temp;
            }
            return temp2;
        }
    }
}
