import java.util.Stack;

public class StackProbs {
    Stack<Integer> doubleUp(Stack<Integer> nums){
        Stack<Integer> doubled = new Stack<>();
        while(nums.size()>0){
            int i = nums.pop();
            doubled.push(i);
            doubled.push(i);
        }
        return reverse(doubled);
    }
    Stack<Integer> reverse(Stack<Integer> nums){
        Stack<Integer> reversed = new Stack<>();
        while(nums.size()>0){
            reversed.push(nums.pop());
        }
        return reversed;
    }
    Stack<Integer> posAndNeg(Stack<Integer> nums){
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> negs = new Stack<>();
        while(nums.size()>0){
            Integer i = nums.pop();
            if(i<0){
                negs.push(i);
            }else{
                pos.push(i);
            }
        }
        while(negs.size()>0){
            nums.push(negs.pop());
        }
        while(pos.size()>0){
            nums.push(pos.pop());
        }
        return nums;
    }
    Stack<Integer> shiftByN(Stack<Integer> nums, int n){
        int size = nums.size()-n;
        Stack<Integer> bottom = new Stack<>();
        for(int i=0;i<size;i++){
            bottom.push(nums.pop());
        }
        bottom = reverse(bottom);
        nums  = reverse(nums);
        while(nums.size()>0){
            bottom.push(nums.pop());
        }
        return bottom;
    }
    String reverseVowels(String str){
        Stack<String> vowels = new Stack<>();
        for(int i=0;i<str.length();i++){
            String s = str.substring(i,i+1);
            if("AEIOU".contains(s.toUpperCase())){
                vowels.push(s);
            }
        }
        String newStr = "";
        for(int i=0;i<str.length();i++){
            String s = str.substring(i,i+1);
            if("AEIOU".contains(s.toUpperCase())){
                newStr+=vowels.pop();
            }else{
                newStr+=s;
            }
        }
        return newStr;
    }
    //Riddle

    boolean bracketBalance(String s){
        Stack<String> brackets = new Stack<>();
        String prev = "";
        for(int i=0;i<s.length();i++){
            String str = s.substring(i,i+1);
            if(match(prev,str)){
                brackets.pop();
                prev = brackets.size()>0?brackets.peek():"";
                continue;
            }else if("[]()".contains(str)){
                brackets.push(str);
                prev = str;
            }
        }
        return brackets.size()==0;
    }

    private boolean match(String one, String two){
        return (one.equals("(")&&two.equals(")"))||(one.equals("[")&&two.equals("]"));
    }
}
