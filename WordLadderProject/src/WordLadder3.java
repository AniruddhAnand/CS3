import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadder3 {
    public final static void main(String... args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dictionary.txt"));
        StringTokenizer st = new StringTokenizer(f.readLine());
      HashMap<Integer,ArrayList<String>> dictionary = new HashMap();
      for(int i=1;i<31;i++){
          dictionary.put(i,new ArrayList<String>());
      }
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            dictionary.get(word.length()).add(word);
            try {
                st = new StringTokenizer(f.readLine());
            } catch (NullPointerException e) {
            }
        }
        f = new BufferedReader(new FileReader("input.txt"));
        st = new StringTokenizer(f.readLine());
        outer:while (st.hasMoreTokens()) {
            String start = st.nextToken();
            String end = st.nextToken();
            if(start.length()!=end.length()){
                st = new StringTokenizer(f.readLine());
                System.out.println("NO");
                continue;
            }
            if(start.equals(end)){
                st = new StringTokenizer(f.readLine());
                System.out.println("[" + start +"]");
                continue;
            }
            Queue<Stack<String>> queue = new LinkedList<>();
            HashSet<String> list = newWords(start,dictionary);
            for(String s:list){
                Stack<String>temp = new Stack<>();
                temp.push(start);temp.push(s);queue.add(temp);
            }
            try {
                for (Stack<String> stack : queue) {
                    if (check(queue, end)) {
                        st = new StringTokenizer(f.readLine());
                        continue outer;
                    }
                    queue.poll();
                    list = newWords(stack.peek(), dictionary);
                    for (String s : list) {
                        Stack<String> temp = (Stack<String>) stack.clone();
                        if (!stack.contains(s) && checkBetween(s, queue)) {
                            temp.push(s);
                            queue.add(temp);
                        }
                    }
                    if (check(queue, end)) {
                        st = new StringTokenizer(f.readLine());
                        continue outer;
                    }
                }
            }
            catch (Exception e){
                System.out.println("NO");
                st = new StringTokenizer(f.readLine());
            }
        }
    }





    public static boolean check(Queue<Stack<String>>queue,String word){
        for (Stack<String> stack : queue) {
            if (stack.peek().equals(word)) {
                System.out.println(stack);
                return true;
            }
        }
        return false;
    }
    public static void cloneQue(Queue<Stack<String>> s,Queue<Stack<String>> t){
        for(Stack<String>e:s){
            t.add((Stack<String>) e.clone());
        }
    }
    public static HashSet<String> newWords(String current, HashMap<Integer,ArrayList<String>> dictionary) {
        HashSet<String> newWords = new HashSet<>();
        for (String s : dictionary.get(current.length())) {
            if(oneDifferent(s, current))
                newWords.add(s);
        }
        return newWords;
    }

    public static boolean oneDifferent(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i))
                count++;
        }
        return count == 1;
    }
    public static boolean checkBetween(String s,Queue<Stack<String>> queue){
        for(Stack<String> stack:queue){
            if(stack.contains(s))
                return false;
        }
        return true;
    }
}
