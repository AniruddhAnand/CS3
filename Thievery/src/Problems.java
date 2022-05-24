import java.util.HashMap;
import java.util.Objects;

public class Problems {
    class Point{
        int row, col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    HashMap<Point, Integer> pascalMatches = new HashMap<>();
    HashMap<Integer, Long> fibMatches = new HashMap<>();
    long fibonacci(int n){
        if(n<0){
            return 0;
        }
        if(n<2){
            return 1;
        }
        long value = fibMatches.containsKey(n)?fibMatches.get(n):fibonacci(n-1)+fibonacci(n-2);
        fibMatches.put(n,value);
        return fibMatches.get(n);
    }

    long fibonacciMemo(int n){
        return fibMatches.get(n);
    }

    int pascal(int row, int col){
        Point p = new Point(row,col);
        if(!pascalMatches.containsKey(p))pascalHelper(row,col);
        return pascalMatches.get(p);
    }
    int pascalHelper(int row, int col){
        if(row==1||col==1)return 1;
        if(row<1||col<1)return 0;
        Point point = new Point(row, col);
        int value = pascalMatches.containsKey(point)?pascalMatches.get(point):pascalHelper(row-1,col) + pascalHelper(row,col-1);
        pascalMatches.put(point,value);
        return value;
    }
    HashMap<Point, Integer> pathMatches = new HashMap<>();
    int numPath(int [][]maze){
        //To account for the 0,0 value and the final maze values
        Point point = new Point(maze.length, maze[0].length);
        if(pathMatches.get(point)==null) {
            pathMatches.put(point, + numPath(maze.length, maze[0].length));
        }
        return pathMatches.get(point);
    }
    int numPath(int row, int col){
        Point point = new Point(row,col);
        if(pathMatches.containsKey(point))return pathMatches.get(point);
        if(row==1||col==1){
            return 1;
        }
//        int count = 0;
//        if(row+1<start-1){
//            count+=1;
//            count +=/*path[row+1][col]==null?*/numPath(row+1,col,start,end)/*:0*/;
//        }
//        if(col+1<end-1){
//            count+=1;
//            count+=/*path[row][col+1]==null?*/numPath(row,col+1,start,end)/*:0*/;
//        }
//        return count;
        pathMatches.put(point,numPath(row,col-1)+numPath(row-1,col));
        return pathMatches.get(point);
    }

    HashMap<Integer, Integer> changeMatches = new HashMap<>();
    int minCoins(int change, int [] coins){
        if(!changeMatches.containsKey(change)) {
            changeMatches.put(change,minCoins(change, coins, 0, coins.length - 1));
        }
        return changeMatches.get(change);
    }

    private int minCoins(int change, int [] coins, int  count, int index){
        int [] equivalance = {1,5,10,25};
        if(change==0)return count;
        if(index<0)return -1;
        while(change>=equivalance[index]&&coins[index]>0){
            count++;
            change-=equivalance[index];
            coins[index]--;
        }
        int value = changeMatches.containsKey(change)? changeMatches.get(change): minCoins(change,coins,count, index-1);
        return value;
    }


    //TODO: FIX Method
    public int maxRobbery(int [] houses){
        return Math.max(maxRobbery(houses, 0),maxRobbery(houses, 1));
    }

    private int maxRobbery(int [] houses, int index){
        if(index>=houses.length){
            return 0;
        }
        return houses[index] + maxRobbery(houses,index+2);
    }

    public static void main(String[] args) {
        Problems p = new Problems();
//        long start = System. currentTimeMillis();
//        System.out.println(p.fibonacci(4));
//        System.out.println((System.currentTimeMillis()-start)/1000.0);
//        start = System. currentTimeMillis();
//        System.out.println(p.fibonacciMemo(2));
//        System.out.println((System.currentTimeMillis()-start)/1000.0);
//      //  System.out.println(p.pascal(4,3));
//      //  System.out.println(p.pascal(3,3));
        System.out.println(p.numPath(new int [5][5]));
        System.out.println(p.minCoins(11, new int[] {9, 6, 5, 1}));
//        System.out.println(p.maxRobbery(new int []{200,234,182,111,87,194,221,217,71,162,140,51,81,80,232,193,223,103,139,103}));
        int[] weights = { 6, 1, 2,  5, 4, 3};
        int[] values  = {10, 5, 7, 12, 8, 6};
        System.out.println(p.thievery(values,weights,10));
    }

    HashMap<Point, Integer> thieveryMatches = new HashMap<>();
    public int thievery(int [] values, int [] weights, int weight){
//        if(!thieveryMatches.containsKey(weight)){
//            thieveryMatches.put(weight, thievery(values,weights,weight,0,0,0));
//        }
//        return thieveryMatches.get(weight);
        return thievery(values,weights,weight,0);
    }
    private int thievery(int [] values, int [] weights, int maxWeight, int index){
//        Point p = new Point(currentWeight, index);
//        //if(thieveryMatches.containsKey(p))return thieveryMatches.get(p);
//        if(currentWeight==maxWeight||(currentWeight<maxWeight&&index>=values.length)){
//            return currentValue;
//        }
//        if(currentWeight>maxWeight){
//            return 0;
//        }
//        int value = Math.max(thievery(values,weights,maxWeight,index+1,currentWeight+weights[index],currentValue+values[index]),thievery(values,weights,maxWeight,index+1,currentWeight,currentValue));
//        return value;
        Point point = new Point(maxWeight, index);
        if(thieveryMatches.containsKey(point)){
            return thieveryMatches.get(point);
        }
        int value = 0;
        if(maxWeight==0||(maxWeight>0&&index>=values.length)){
            value = 0;
        }
        else if(maxWeight<0){
            value = -values[index-1];
        }
        else{
            value = Math.max(values[index] + thievery(values,weights,maxWeight-weights[index],index+1),thievery(values,weights,maxWeight,index+1));
        }

        thieveryMatches.put(point,value);
        return thieveryMatches.get(point);
    }

}
