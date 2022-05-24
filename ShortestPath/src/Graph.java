import java.util.Scanner;

public class Graph {
    int V, E;
    Vertex [] adjacencyList;
    public Graph(Scanner console){
        V = console.nextInt();
        E = console.nextInt();
        adjacencyList = new Vertex[V];
        console.nextLine();
        for(int i=0;i<V;i++,console.nextLine()){
            adjacencyList[i] = new Vertex(console.nextInt(),console.nextInt(),console.nextInt());
        }
        for(int i=0;i<E;i++,console.nextLine()){
            adjacencyList[console.nextInt()].edges.add(console.nextInt());
        }
    }
    double distanceTo(int from, int to){
        return Math.sqrt(Math.pow((adjacencyList[from].x-adjacencyList[to].x),2)+Math.pow((adjacencyList[from].y-adjacencyList[to].y),2));
    }
}