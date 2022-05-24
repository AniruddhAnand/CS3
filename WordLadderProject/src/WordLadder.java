import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordLadder {
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
                out.println(ladder(start, st.nextToken(), dictionary.get(start.length())));
                st = new StringTokenizer(f.readLine());
            }
        } catch (Exception e) {
        }
        out.close();
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) / 1000.0 + " seconds");
    }

    public static String ladder(String start, String end, LinkedList<String> dictionary) {
        HashSet<String> allWords = new HashSet<>();
        allWords.add(start);
        if (start.length() != end.length()|| !dictionary.contains(start)) {
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
            allWords.add(s);
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

    public static LinkedList<String> getSwitch(String word, LinkedList<String> dictionary, HashSet<String> allWords) {
        LinkedList<String> matches = new LinkedList<>();
        for (String s : dictionary) {
            if (difference(word, s) && !allWords.contains(s)) {
                matches.add(s);
                allWords.add(s);
            }
        }
        return matches;
    }

    public static boolean difference(String one, String two) {
        int difference = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i)!=(two.charAt(i))) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        return true;
    }
}
