public class MazeInputException extends Exception{
    MazeInputException(){
        super("Maze Input Invalid");
    }
    MazeInputException(String s){
        super(s);
    }
}
