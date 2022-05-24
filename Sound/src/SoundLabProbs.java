import java.util.*;
public class SoundLabProbs {

    public int lastIndexOf(int[] nums, int value) {
        int end = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public int range(int[] nums) {
        int sml = nums[0];
        int lrg = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sml = Math.min(nums[i], sml);
            lrg = Math.max(nums[i], lrg);
        }
        int range = lrg - sml;
        return range;
    }
    public int minDifference(int[] nums) {
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minDif = Math.min(minDif,Math.abs(nums[i]-nums[i-1]));
        }
        return minDif;
    }
    public String reverseWords(String str) {
        String line = "";
        String [] words = str.split(" ");
        for (int i = words.length-1;i>-1; i--) {
            line+=words[i];
            if(i!=0){
                line+=" ";
            }
        }
        return line;
    }
    public int priceIsRight(int[] bids, int price) {
        int bid = -1;
        for(int i=0;i<bids.length;i++){
            if(bids[i]>price){
                continue;
            }
            if(bid==-1){
                bid = bids[i];
            }else{
                bid = Math.max(bid, bids[i]);
            }
        }
        return bid;
    }
    public int[] productExceptSelf(int[] nums) {
        int [] products = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int product = 1;
            for(int j=0;j<nums.length;j++){
                if(j==i){
                    continue;
                }
                product*=nums[j];
            }
            products[i] = product;
        }
        return products;
    }
}