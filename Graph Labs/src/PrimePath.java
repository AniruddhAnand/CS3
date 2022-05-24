import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PrimePath {
    public static class Node{
        private int val;
        private boolean visitied;
        public Node(int val){
            this.val = val;
            visitied = false;
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }

        public int getVal() {
            return val;
        }

        public boolean isVisitied() {
            return visitied;
        }

        public void setVisitiedTrue() {
            visitied = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, visitied);
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<Node, LinkedList<Node>> graph = new HashMap<>();
        LinkedList<Integer> primes = sieveOfEratosthenes(9999);
        for(int i:primes){
            Node n = new Node(i);
            graph.put(n,new LinkedList<>());
            for (int j:primes){
                if(compare(j,i))graph.get(n).add(new Node(j));
            }
        }
        BufferedReader f = new BufferedReader(new FileReader("path.dat"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        Queue<Node> list  = new LinkedList<>();
        list.add(new Node(num1));
        boolean isComplete = false;
        int count = 0;

        outer:while(list.size()>0){
            int currentSize = list.size();
            for(int i=0;i<currentSize;i++){
                Node n = list.poll();
                if(n.val==num2){
                    isComplete = true;
                    break outer;
                }
                LinkedList<Node> list1 = graph.get(n);
                if(list1==null)continue;
                for(Node n2:list1){
                    if(!n2.isVisitied())list.offer(n2);
                }
                n.setVisitiedTrue();
            }
            count++;
        }

        System.out.println(isComplete?count:"Not Possible");
    }

    public static LinkedList<Integer> sieveOfEratosthenes(int n){
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
        LinkedList<Integer> list = new LinkedList<>();
        for(int i:primes){
            if(i<1000){
                continue;
            }
            list.add(i);
        }
        return list;
    }
    public static Queue<Integer> clear(Queue<Integer> numbers, int factor){
        Queue<Integer> nonFactors = new LinkedList<>();
        while(numbers.size()>0){
            int temp = numbers.poll();
            if(temp%factor!=0){
                nonFactors.offer(temp);
            }
        }
        return nonFactors;
    }

    public static boolean compare(int n1, int n2){
        String s1 = n1+"";
        String s2 = n2+"";
        int count = 0;
        for(int i=0;i<4;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return count==1;
    }
}
