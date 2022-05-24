import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Scooby {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("scooby.dat"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0;i<num;i++){
            LinkedList<String> doors = new LinkedList<>();
            st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens()){
                doors.add(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            solve(doors,st.nextToken());
        }
    }
    public static void solve(LinkedList<String> doors, String value){
        System.out.println(isSolvable(doors, value.charAt(0),value.charAt(1), new LinkedList<>())==true?"Yes":"No");
    }
    public static boolean isSolvable(LinkedList<String> doors, char start, char end, LinkedList<Character> visited){
        if(start==end){
            return true;
        }else if(visited.contains(start)){
            return false;
        }
        visited.add(start);
        boolean val = false;
        for(int i=0;i<doors.size();i++){
            String s = doors.get(i);
            int index = s.indexOf(start);
            if(index>-1){
                doors.remove(i);
                val = isSolvable(doors,s.charAt(index==0?1:0),end,visited);
                i--;
            }
            if(val){
                return true;
            }
        }
        return val;
    }
}
