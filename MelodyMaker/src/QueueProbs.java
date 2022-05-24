import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {
    Queue<Integer> evensFirst(Queue<Integer> nums){
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();
        while(nums.size()>0){
            int num = nums.poll();
            if(num%2==0){
                evens.offer(num);
            }else{
                odds.offer(num);
            }
        }
        while(evens.size()>0){
            nums.offer(evens.poll());
        }
        while(odds.size()>0){
            nums.offer(odds.poll());
        }
        return nums;
    }
    boolean numPalidrome(Queue<Integer> nums){
        Queue<Integer> front = new LinkedList<>();
        Stack<Integer> back = new Stack<>();
        while(nums.size()>0){
            int num = nums.poll();
            front.offer(num);
            back.push(num);
        }
        while(front.size()>0){
            if(front.poll()!=back.pop()){
                return false;
            }
        }
        return true;
    }
    //Yesterday Today Tomorrow
    public ArrayList<Integer> sieveOfEratosthenes(int n){
        Queue<Integer> numbers = new LinkedList<>();
        Stack<Integer> primes = new Stack<>();
        for(int i=2;i<=n;i++){
            numbers.add(i);
        }
        while(numbers.size()>0){
            int prime = numbers.poll();
            primes.push(prime);
            numbers = clear(numbers,prime);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:primes){
            list.add(i);
        }
        return list;
    }
    public Queue<Integer> clear(Queue<Integer> numbers, int factor){
        Queue<Integer> nonFactors = new LinkedList<>();
        while(numbers.size()>0){
            int temp = numbers.poll();
            if(temp%factor!=0){
                nonFactors.offer(temp);
            }
        }
        return nonFactors;
    }
}
