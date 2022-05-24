import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Maze {
    private Square[][] maze;
    private Square start;
    private Square exit;
    public Maze(){
    }
    boolean loadMaze(String fileName){
        try {
            BufferedReader f = new BufferedReader(new FileReader(fileName));
            StringTokenizer st = new StringTokenizer(f.readLine());
            int width = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            maze = new Square[width][length];
            for(int i=0;i<width;i++){
                st = new StringTokenizer(f.readLine());
                for(int j=0;j<length;j++){
                    int type = Integer.parseInt(st.nextToken());
                    maze[i][j] = new Square(i,j,type);
                    if(type== Square.start){
                        start = maze[i][j];
                    }
                    if(type==Square.exit){
                        exit = maze[i][j];
                    }
                }
            }
            return true;
        }catch (IOException e){
            System.out.println("File Error");
            return false;
        }catch(MazeInputException m){
            System.out.println(m.toString());
            return false;
        }
    }
    List<Square> getNeighbors(Square s){
        ArrayList<Square> neighbors = new ArrayList<>();
        for(int i=s.getRow()-1;i<s.getRow()+2;i++){
            if(i<0||i>= maze.length){
                continue;
            }
            for(int j=s.getCol()-1;j<s.getCol()+2;j++){
                if(j<0||j>= maze[i].length){
                    continue;
                }
                if(i==s.getRow()&&j==s.getCol()){
                    continue;
                }
                if(i!=s.getRow()&&j!=s.getCol()){
                    continue;
                }
                if(maze[i][j].getType()!=Square.wall) {
                    neighbors.add(maze[i][j]);
                }
            }
        }
        return neighbors;
    }

    public Square getStart() {
        return start;
    }

    public Square getExit() {
        return exit;
    }

    void reset(){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                maze[i][j].setStatus(Status.Unknown.getSymbol());
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                s+=maze[i][j].toString();
                if(j==maze[i].length-1){
                    s+="\n";
                }else{
                    s+="\t";
                }
            }
        }
        return s;
    }
}
