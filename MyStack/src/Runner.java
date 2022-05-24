import java.util.Stack;

public class Runner {
    public static void main(String [] args){
        StackProbs probs = new StackProbs();
        Stack<Integer> stack = probs.doubleUp(makeStack(new int []{1, 3, 5, 0, -1}));
        System.out.println(stack);
        stack = probs.posAndNeg(makeStack(new int []{2, 9, -4, 3, -1, 0, -6}));
        System.out.println(stack);
        stack = probs.shiftByN(makeStack(new int []{7, 23, -7, 0, 22, -8, 4, 5}),3);
        System.out.println(stack);
        System.out.println(probs.reverseVowels("hello how are you") );
        System.out.println(probs.bracketBalance("(([()])))"));
        System.out.println(probs.bracketBalance("([()[]()])()"));
        System.out.println(probs.bracketBalance("[( axtyrf)[]]"));
    }
    public static Stack<Integer> makeStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums)
            stack.push(num);
        return stack;
    }
}
