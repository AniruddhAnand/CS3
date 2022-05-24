public class MazeSolverQueue extends MazeSolver{
    private MyQueue<Square> queue = new MyQueue<>();
    public MazeSolverQueue(Maze maze){
        super(maze);
        queue.offer(maze.getStart());
    }
    void makeEmpty(){
        queue = new MyQueue<>();
    }
    boolean isEmpty(){
        return queue.isEmpty();
    }
    void add(Square s){
        queue.offer(s);
    }
    Square next(){
        return queue.poll();
    }
}
