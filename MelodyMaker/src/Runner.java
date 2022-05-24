import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String []args){
        QueueProbs probs = new QueueProbs();
        System.out.println(probs.evensFirst(create(new int []{3, 5, 4, 17, 6, 83, 1, 84, 16, 37})));
        System.out.println(probs.numPalidrome(create(new int []{3,8,17,9,17,8,3})));
        System.out.println(probs.sieveOfEratosthenes(100));
    }
    public static Queue<Integer> create(int [] x){
        Queue<Integer> newQueue = new LinkedList<>();
        for(int i:x){
            newQueue.offer(i);
        }
        return newQueue;
    }
}
