import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    int x, y, ID;
    List<Integer> edges;
    boolean visited;
    double distance;

    public Vertex( int ID, int x, int y){
        this.x = x;
        this.y = y;
        this.ID = ID;
        visited = false;
        edges = new LinkedList<>();
        distance = Double.POSITIVE_INFINITY;
    }
    @Override
    public String toString() {
        return "[" + ID + ": " + distance + "]" + edges.toString();
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(distance,((Vertex)o).distance);
    }
}
