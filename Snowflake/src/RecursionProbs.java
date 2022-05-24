import java.util.Stack;
/*interface PrintingProbs{
    void frontCarrot(int i);
    void backCarrot(int i);
}*/
public class RecursionProbs {
    public static void main(String [] args){
        RecursionProbs probs = new RecursionProbs();
        System.out.println(probs.sumReciprocals(10));
        System.out.println(probs.productOfEvens(4));
        Stack<Integer> x = new Stack<>();
        x.push(3);x.push(7);x.push(12);x.push(9);
        probs.doubleUp(x);
        System.out.println(x);
        probs.countToBy(34,5);
        System.out.println();
        System.out.println(probs.matchingDigits(298892, 7892));
        probs.printThis(7);
        System.out.println();
        probs.printNums2(9);
        System.out.println(probs.conversion(1453,8));
    }
    String conversion(int num, int base){
        if(num==0){
            return "";
        }
        return conversion(num/base,base) + (num%base);
    }
    double sumReciprocals(int n){
        if(n==0){
            return 0.0;
        }
        return 1.0/n + sumReciprocals(n-1);
    }
    int productOfEvens(int n){
        if(n==0){
            return 1;
        }
        return n*2*productOfEvens(n-1);
    }
    //Riddle
    void doubleUp(Stack<Integer> nums){
        if(nums.size()==0){
            return;
        }
        int x = nums.pop();
        doubleUp(nums);
        nums.push(x);
        nums.push(x);
    }
    void countToBy(int n, int m){
        if(n-m<=0){
            System.out.print(n);
            return;
        }
        countToBy(n-m,m);
        System.out.print(", " + n);
    }
    int matchingDigits(int a, int b){
        if(a<10||b<10){
            if(a%10==b%10){
                return 1;
            }
            return 0;
        }
        if(a%10==b%10){
            return 1+matchingDigits(a/10,b/10);
        }
        return matchingDigits(a/10,b/10);
    }
    void printThis(int n){
        if(n<=2){
            if(n%2==0){
                System.out.print("**");
            }else{
                System.out.print("*");
            }
            return;
        }
        System.out.print("<");
        printThis(n-2);
        System.out.print(">");
        /*PrintingProbs print = new PrintingProbs() {
            @Override
            public void frontCarrot(int i) {
                if(i==0){
                    return;
                }
                System.out.print("<");
                frontCarrot(i-1);
            }

            @Override
            public void backCarrot(int i) {
                if(i==0){
                    return;
                }
                System.out.print(">");
                backCarrot(i-1);
            }
        };
        print.frontCarrot((n%2==0?n/2-1:n/2));
        printThis(n%2);
        print.backCarrot((n%2==0?n/2-1:n/2));*/

    }
    void printNums2(int n){
        if(n<=2){
            if(n%2==0){
                System.out.print("1 1 ");
            }else{
                System.out.print("1 ");
            }
            return;
        }
        System.out.print((int)((n/2.0)+.5) + " ");
        printNums2(n-2);
        System.out.print((int)((n/2.0)+.5) + " ");
    }
}
