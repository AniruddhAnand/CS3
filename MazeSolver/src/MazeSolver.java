import java.util.*;

/**
 * The abstract class containing the maze solver algorithm.
 *
 * @author Joey Gonzales-Dones (3/05/2013)
 *
 */

public abstract class MazeSolver {

    protected Maze maze;

    protected static final int space = 0;
    protected static final int wall = 1;
    protected static final int start = 2;
    protected static final int exit = 3;
    protected int stepCount = 0;
    boolean isSolved = false;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    abstract void makeEmpty();

    abstract boolean isEmpty();

    abstract void add(Square sq);

    abstract Square next();

    /**
     *
     * @return returns a boolean depending on whether or not the maze has been solved.
     */
    public boolean isSolved() {
        return isSolved;
    }

    /**
     *
     * @return returns either a string of the solution path as a list of coordinates [i,j] from the start to the exit or a message indicating no such path exists
     */
    public String getPath() {
        if(isSolved()){

            return "Solved";
        }else if(isEmpty()){
            return "Unsolvable";
        }else{
            return "Solving";
        }
    }

    /**
     * Runs one iteration of the algorithm
     * @return returns the current square being examined.
     */
    void step(){
        if(isEmpty()){
            return;
        }
        Square temp = next();
        List<Square> neighbors = maze.getNeighbors(temp);
        for(Square s:neighbors){
            temp.setStatus(Status.Explored.getSymbol());
            if(s.getType()==Square.exit){
                s.setPrev(temp);
                isSolved = true;
                s = s.getPrev();
                MyStack<String> path = new MyStack<>();
                while(!s.equals(maze.getStart())){
                    s.setStatus(Status.ExitPath.getSymbol());
                    path.push("[" + s.getRow() + ", " + s.getCol() + "]");
                    s = s.getPrev();
                }
                System.out.print("Path: ");
                while(!path.isEmpty()){
                    System.out.print(path.pop() + " ");
                }
                return;
            }
            if(s.getStatus()==Status.Unknown.getSymbol()&&s.getType()==Square.space){
                s.setStatus(Status.Exploring.getSymbol());
                add(s);
                s.setPrev(temp);
            }
        }
    }
}





