import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Attendance {
    public static void main(String[] args) {
        //This represents the largest attendance total of any member
        int max = 0;
        //This is used to map a student to their specific attendance rate
        HashMap<String, Integer> attendance = new HashMap<>();
        Scanner console = new Scanner(System.in);
        //Get the number of weeks
        System.out.print("Number of Weeks: ");
        int num = console.nextInt();
        console.nextLine();
        //Get each weeks attendance per member
        for(int i=1;i<=num;i++){
            System.out.print("Week " + i + " Attendance: ");
            String [] names = console.nextLine().split(" ");
            //Count attendance logic
            for(String name:names){
                int totalAttendance = 1;
                if(attendance.containsKey(name)){
                    totalAttendance = attendance.get(name) + 1;
                }
                attendance.put(name,totalAttendance);
                max = Math.max(max,totalAttendance);
            }
        }
        //Display the best attendance
        System.out.print("Best Attendance:");
        //Gather all possible best attendances
        for(String name:attendance.keySet()){
            if(attendance.get(name)==max){
                System.out.print(" " + name);
            }
        }
        //one vs plural logic for printing
        if(max>1) {
            System.out.println(", " + max + " meetings");
        }else{
            System.out.println(", " + max + " meeting");
        }
    }
}
