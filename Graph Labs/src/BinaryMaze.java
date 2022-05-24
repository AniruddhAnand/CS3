import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BinaryMaze {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("maze.txt"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int [][] maze = new int[rows][cols];
        for(int i=0;i<rows;i++){
            st = new StringTokenizer(f.readLine());
            for(int j=0;j<cols;j++){
               maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(f.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        int endRow = Integer.parseInt(st.nextToken());
        int endCol = Integer.parseInt(st.nextToken());

        Queue<Point> next = new LinkedList<>();

        next.offer(new Point(startRow,startCol));

        int size = 0;
        boolean isSolved = false;
        outer: while(next.size()>0){
            int currentSize = next.size();
            for(int i=0;i<currentSize;i++) {
                Point current = next.poll();
                int x = current.getX();
                int y = current.getY();
                maze[x][y] = -1;
                if (x == endRow && y == endCol) {
                    isSolved = true;
                    break outer;
                }
                if (x - 1 > -1 && maze[x - 1][y] == 1) next.offer(new Point(x - 1, y));
                if (x + 1 < maze.length && maze[x + 1][y] == 1) next.offer(new Point(x + 1, y));
                if (y - 1 > -1 && maze[x][y - 1] == 1) next.offer(new Point(x, y - 1));
                if (y + 1 < maze[x].length && maze[x][y + 1] == 1) next.offer(new Point(x, y + 1));
            }
            size++;
        }
        if(isSolved){
            System.out.println(size);
        }else{
            System.out.println(-1);
        }
    }
}

class Point{
    private int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}