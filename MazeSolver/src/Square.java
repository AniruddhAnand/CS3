import java.util.Objects;

public class Square {
    public static final int space = 0;
    public static final int wall = 1;
    public static final int start = 2;
    public static final int exit = 3;
    private int row;
    private int col;
    private int type;
    private char status;
    private Square prev;

    public Square(int row, int col, int type) throws MazeInputException{
        this(row,col,type,null);
    }
    public Square(int row, int col, int type,Square prev) throws MazeInputException{
        if(type<0||type>3){
            throw new MazeInputException();
        }
        this.row = row;
        this.col = col;
        this.type = type;
        status = Status.Unknown.getSymbol();
        this.prev =  prev;
    }

    public String toString(){
        switch (type){
            case wall: return "#";
            case start: return "S";
            case exit: return "E";
            default: return status+"";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return row == square.row && col == square.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, type, status);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setPrev(Square prev){
        this.prev = prev;
    }

    public Square getPrev() {
        return prev;
    }
}

enum Status{
    Unknown('_'),
    Exploring('o'),
    Explored('.'),
    ExitPath('x');
    private char symbol;
    Status(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
