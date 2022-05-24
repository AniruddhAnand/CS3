public class MazeSolverStack extends MazeSolver{
    private MyStack<Square> stack = new MyStack<>();
    public MazeSolverStack(Maze maze){
        super(maze);
        stack.push(maze.getStart());
    }
    void makeEmpty(){
        stack = null;
        stack = new MyStack<>();
    }
    boolean isEmpty(){
        return stack.isEmpty();
    }
    void add(Square s){
        stack.push(s);
    }
    Square next(){
        return stack.pop();
    }
}
