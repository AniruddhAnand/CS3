import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(new File(/*"grid25x25.txt"*/"usa.txt"));
        Graph g = new Graph(console);
     //   System.out.println(Arrays.toString(g.adjacencyList));

        //System.out.println(new Dijkstra(g).distance(console.nextInt(),console.nextInt())/*727,756*/);
        System.out.println(new Dijkstra(g).distance(0,500));
    }
}
