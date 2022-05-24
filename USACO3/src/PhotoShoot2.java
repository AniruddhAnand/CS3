import java.util.Scanner;

public class PhotoShoot2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = console.nextInt();
        String s = console.next();
        int count1 = 0;
        int count2 = 0;
        int flips = 0;
//       char prev = s.charAt(0);
//       for(int i=1/*, j = num-1*/;i<num;i++){
//            if(s.charAt(i)=='G') {
//                if (i % 2 == 0) {
//                    count1++;
//                } else {
//                    count2++;
//                }
//            }
//            if(count1-count2>1){
//                flips++;
//                count1=0;
//                count2=0;
//            }
//            if(s.charAt(i)==prev&&prev=='G'){
//                flips++;
//            }
//        }
        System.out.println(flips);
    }
    public int count(String s){
        if(s.charAt(0)=='G'){
            int index = s.indexOf('H');
            if(index>-1){
              //  return Math.max()
            }
            return 0;
        }else{

        }
    }
}
