import java.util.Scanner;

public class AdditionGame {
    public static void main(String [] args){
        Player p = new Player();
        Scanner console = new Scanner(System.in);
        while(p.isAlaive()){
            int randomNums = (int)(Math.random()*4)+2;
            int sum = 0;
            for(int i=0;i<randomNums;i++){
                int num = (int)(Math.random()*10);
                sum+=num;
                System.out.print(num);
                if(i==randomNums-1){
                    System.out.print("=");
                }else{
                    System.out.print("+");
                }
            }
            System.out.println("Answer");
            System.out.println("Enter Answer");
            int answerr = console.nextInt();
            if(answerr==sum){
                System.out.println("Correct");
                p.incement();
            }else{
                System.out.println("Wrong");
                p.decriment();
            }
        }
        System.out.println("You Loose");
        System.out.println("Points:" + p.getScore());
    }
}
