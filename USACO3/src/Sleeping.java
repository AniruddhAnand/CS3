import java.util.LinkedList;
import java.util.Scanner;

public class Sleeping {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int cases = console.nextInt();
        while(cases-->0){
            int count = console.nextInt();
            if(count<2){
                System.out.println(0);
                continue;
            }
            LinkedList<Integer> list = new LinkedList<>();
            int min = 1000000;
            int max = 0;
            for(int i=0;i<count;i++){
                int num = console.nextInt();
                list.add(num);
                if(num>max){
                    max = num;
                }
                if(num<min){
                    min = num;
                }
            }
            int operations = 0;
            while(min!=max){
                operations++;
                int index = list.indexOf(min);
                int num = min;
                if(index==0){
                    num+=list.remove(index+1);
                }else if(index==list.size()-1){
                    num+=list.remove(index-1);
                    index--;
                }else{
                    if(list.get(index+1)>list.get(index-1)){
                        num+=list.remove(index-1);
                        index--;
                    }else{
                        num+=list.remove(index+1);
                    }
                }
                list.set(index,num);
                min = getMin(list);
                max = getMax(list);
            }
            System.out.println(operations);
        }
    }
    public static int getMin(LinkedList<Integer>x){
        int min = x.get(0);
        for(int i=1;i<x.size();i++){
            if(x.get(i)<min){
                min = x.get(i);
            }
        }
        return min;
    }

    public static int getMax(LinkedList<Integer>x){
        int min = x.get(0);
        for(int i=1;i<x.size();i++){
            if(x.get(i)>min){
                min = x.get(i);
            }
        }
        return min;
    }
}


/*
import java.util.LinkedList;
import java.util.Scanner;

public class Sleeping {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int cases = console.nextInt();
        while(cases-->0){
            int count = console.nextInt();
            if(count<2){
                System.out.println(0);
                continue;
            }
            int total = 0;
            int max = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<count;i++){
                int num =console.nextInt() ;
                list.add(num);
                total+=num;
                if(num>max){
                    max = num;
                }
            }
            int operations = 0;
            for(int i=0;list.size()>1;i++){
                if(i>=list.size()-1)i=0;
                int num = list.get(i);
                if(num<max){
                    num+=list.remove(i+1);
                    i--;
                    list.set(i,num);
                }
            }
            System.out.println(operations);
        }
    }
}

 */