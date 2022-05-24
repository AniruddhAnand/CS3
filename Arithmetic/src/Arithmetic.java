import java.util.Scanner;

public class Arithmetic {
    public static void main(String [] args){
        Scanner console = new Scanner(System.in);
        //Number 1
        System.out.print("1st Number: ");
        int num1 = console.nextInt();
        //Number 2
        System.out.print("2nd Number: ");
        int num2 = console.nextInt();
        //Operator input
        System.out.print("Operator: ");
        String operator = console.next();
        //Do arithmetic for each operator
        try {
            switch (operator) {
                case "+":
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    return;
                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    return;
                case "*":
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    return;
                case "/":
                    if(num1%num2!=0){
                        System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
                        return;
                    }
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    return;
            }
        }
        //Handle Zero error
        catch (Exception e){
            if(num2==0&&operator.equals("/")){
                System.out.println("Error: Division by Zero");
            }else {
                System.out.println("Invalid Operation");
            }
        }
    }
}
