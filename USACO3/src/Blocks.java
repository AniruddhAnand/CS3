import java.util.*;

public class Blocks {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numWords = console.nextInt();
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        console.nextLine();
        String s = console.nextLine();
        for (int j = 0; j < 6; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c))continue;
            HashSet<Integer> set = new HashSet<>();
            set.add(1);
            map.put(c,set);
        }
        s = console.nextLine();
        for (int j = 0; j < 6; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.get(c).add(2);continue;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(2);
            map.put(c,set);
        }
        s = console.nextLine();
        for (int j = 0; j < 6; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.get(c).add(3);continue;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(3);
            map.put(c,set);
        }
        s = console.nextLine();
        for (int j = 0; j < 6; j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.get(c).add(4);
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(4);
            map.put(c,set);
        }
        outer: while (numWords-- > 0) {
            boolean [] dice = new boolean[4];
            String str = console.nextLine();
            if(isValid(str,map,dice)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean isValid(String s, HashMap<Character, HashSet<Integer>> map, boolean [] dice){
        if(s.length()==0){
            return true;
        }
        boolean isValid = false;
        if(map.containsKey(s.charAt(0))){
            for(int i:map.get(s.charAt(0))){
                if(!dice[i-1]){
                    dice[i-1] = true;

                    isValid = isValid(s.substring(1),map,dice);
                    dice[i-1] = false;
                }
                if(isValid){
                    return true;
                }
            }
        }else{
            return false;
        }
        return isValid;
    }
}
