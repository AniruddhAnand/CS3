import java.util.*;
public class Tester {
    public static void main(String[] args) {
        //3
        System.out.println("\"Hello again, world!\"");
        System.out.println();

        //4
        System.out.println("\"this is a comment!\"");
        //comment
        System.out.println();

        //5
        int numApples = 50;
        System.out.println();
        //6
        final int PRICE_OF_APPLES = 10;
        System.out.println();
        //7
        System.out.println("The total for " + numApples + " apples: " + "\n" + numApples * PRICE_OF_APPLES + " cents");
        System.out.println();
        //8
        if (numApples * PRICE_OF_APPLES >= 1000) {
            System.out.println("\"Thank you valued customer!\"");
        }
        System.out.println();
        //9
        for (int n = 10; n >= 0; n--) {
            System.out.print(n + " ");
        }
        System.out.println();
        //10
        System.out.println();
        for (int mul = 150; mul <= 300; mul = mul + 3) {
            System.out.print(mul + " ");
        }
        System.out.println();
        //11
        System.out.println();
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        System.out.println();
        //12
        //silence
        //13
        Scanner console = new Scanner(System.in);
        System.out.println();
        //14
        System.out.println("Please print a number: ");
        double num = console.nextDouble();
        System.out.println();
        //15
        System.out.println(Math.sqrt(num));
        System.out.println();
        //16
        System.out.println("num^" + num + " = " + Math.pow(num, 3));
        System.out.println();
        //17
        System.out.println("Please print a number (#1): ");
        int num1 = console.nextInt();
        System.out.println("Please print a number(#2): ");
        int num2 = console.nextInt();
        boolean register = false;
        if (num1 - num2 <= 10 && num2 - num1 <= 10) {
            register = true;
        } else if (num1 - num2 > 10 && num2 - num1 > 10) {
            register = true;
        }
        if (register == true) {
            System.out.println("\"Within 10\"");
        }
        if (register == false) {
            System.out.println("\"Not Within 10\"");
        }
        System.out.println();
        //18

        double sum2 = 0;
        int breakLoop = 1;
        double numSave = 0;
        int run = 0;
        while (breakLoop > 0) {
            System.out.println("Please enter a number >>> ");
            numSave = console.nextDouble();
            if (numSave == 0) {
                breakLoop = 0;

            } else {
                sum2 = sum2 + numSave;
                run++;
            }
        }
        System.out.println();
        System.out.println("Sum is " + sum2);
        System.out.println("Average is " + (sum2 / run));
        System.out.println();
        //19
        double[] areas = new double[20];

        //20
        areas[0] = 4.56;

        //21
        int length = areas.length;
        System.out.println(length);
        System.out.println();
        //22
        boolean[] boolArray = {true, true, false, false, true};

        //23
        //tombstone

        //29 everything between these two are calls

        //24 calling the method
        simpleMethod();
        System.out.println();
        //25
        System.out.println(sum(10, 20));
        System.out.println();
        //26
        System.out.println(sumToN(14));
        System.out.println();
        //27
        triangle(7);
        System.out.println();
        //28
        System.out.println(altCaps("Bob"));
        //29 everything between these two are calls


    }

    //24
    public static void simpleMethod() {
        System.out.println("This is a method!");
    }

    //25
    public static int sum(int a, int b) {
        return a+b;
    }

    //26
    public static int sumToN(int n) {
        int sumHold = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sumHold = sumHold + i;
            }
        }
        return sumHold;
    }

    //27
    public static void triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    //28
    public static String altCaps(String s) {
        String newhold = " ";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
            if (count % 2 == 1) {
                newhold += Character.toUpperCase(s.charAt(i));
            } else {
                newhold += Character.toLowerCase(s.charAt(i));
            }
        }
        return newhold;
    }
}
