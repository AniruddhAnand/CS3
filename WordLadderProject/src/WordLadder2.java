import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();
        HashMap<Integer, LinkedList<String>> dictionary = new HashMap<>();
        BufferedReader f = new BufferedReader(new FileReader("dictionary.txt"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        try {
            while (st != null) {
                String word = st.nextToken();
                if (!dictionary.containsKey(word.length())) {
                    dictionary.put(word.length(), new LinkedList<String>());
                }
                dictionary.get(word.length()).add(word.toLowerCase());
                st = new StringTokenizer(f.readLine());
            }
        } catch (Exception e) {
        }
        f = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("test.txt");
        st = new StringTokenizer(f.readLine());
        try {
            while (st != null) {
                String start = st.nextToken();
                String end = st.nextToken();
                out.println(ladder(start, end, dictionary));
                st = new StringTokenizer(f.readLine());
            }
        } catch (Exception e) {
        }
        out.close();
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) / 1000 + " seconds");
    }

    public static String ladder(String start, String end, HashMap<Integer, LinkedList<String>> dictionary) {
        HashMap<String , Integer> allWords = new HashMap<>();
        if (!dictionary.get(start.length()).contains(start) || start.length() != end.length()) {
            return "No ladder between " + start + " and " + end;
        }
        if (start.equals(end)) {
            return "Found a ladder! >>> [" + start + "]";
        }
        if(difference(start,end)){
            return "Found a ladder! >>> [" + start +  ", " + end + "]";
        }
        Queue<Stack<String>> ladders = new LinkedList<>();
        LinkedList<String> extra = getSwitch(start, dictionary, allWords);
        for (String s : extra) {
            if (!allWords.containsKey(s)) {
                allWords.put(s, 0);
            }
            Stack<String> stack = new Stack<>();
            stack.push(start);
            stack.push(s);
            ladders.offer(stack);
        }
        while (ladders.size() > 0) {
            int size = ladders.size();
            for (int i = 0; i < size; i++) {
                Stack<String> stack = ladders.poll();
                extra = getSwitch(stack.peek(), dictionary, allWords);
                for (String s : extra) {
                    stack.push(s);
                    ladders.offer((Stack<String>) stack.clone());
                    if (difference(s, end)) {
                        stack.push(end);
                        return "Found a ladder! >>> " + stack;
                    }
                    stack.pop();
                }
            }
        }
        return "No ladder between " + start + " and " + end;
    }

    public static LinkedList<String> getSwitch(String word, HashMap<Integer, LinkedList<String>> dictionary, HashMap<String,Integer> allWords) {
        LinkedList<String> matches = new LinkedList<>();
        for (String s : dictionary.get(word.length())) {
            if (difference(word, s)) {
                if(!allWords.containsKey(s)){
                    allWords.put(s, 0);
                }else{
                    continue;
                }
                matches.add(s);
            }
        }
        return matches;
    }

    public static boolean difference(String one, String two) {
        if (one.equals(two)) {
            return true;
        }
        int difference = 0;
        for (int i = 0; i < one.length(); i++) {
            if (!one.substring(i, i + 1).equals(two.substring(i, i + 1))) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        return true;
    }

}
