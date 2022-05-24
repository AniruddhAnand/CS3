import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Play {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("play2.dat"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            LinkedList<Node> graph = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(f.readLine());
                Node node = new Node(Integer.parseInt(st.nextToken()));
                int index = graph.indexOf(node);
                if (index > -1) {
                    graph.get(index).add(new Node(Integer.parseInt(st.nextToken())));
                } else {
                    node.add(new Node(Integer.parseInt(st.nextToken())));
                    graph.add(node);
                }
            }
            int count = 0;
            for (int j = 0; j < l; j++) {
                st = new StringTokenizer(f.readLine());
                int index = graph.indexOf(new Node(Integer.parseInt(st.nextToken())));
                count+=traverse(graph,graph.get(index));
            }
            System.out.println(count);
        }
    }
    public static int traverse( LinkedList<Node> graph, Node current){
        if(current==null){
            return 0;
        }
        if(current.isVisited()){
            return 0;
        }else{
            current.setVisitTrue();
            int count = 1;
            int index = graph.indexOf(current);
            if (index<0){
                return 1;
            }
            LinkedList<Node> list = graph.get(index).getNeighbors();
            for(Node n:list){
                count+=traverse(graph,n);
            }
            return count;
        }
    }
}
class Node {
    private int value;
    private LinkedList<Node> neighbors;
    private boolean visited;
    public Node(int value){
        this.value = value;
        neighbors = new LinkedList<Node>();
    }
    public void setVisitTrue() {
        visited = true;
    }
    public boolean isVisited(){
        return visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, neighbors, visited);
    }
    public void add(Node n){
        neighbors.add(n);
    }

    public LinkedList<Node> getNeighbors() {
        return neighbors;
    }
}
