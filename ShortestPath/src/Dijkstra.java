import java.util.*;

public class Dijkstra {
    Graph graph;
    public Dijkstra(Graph graph){
        this.graph = graph;
    }
    double distance(int source, int destination){
        dijkstra(source,destination);
        return graph.adjacencyList[destination].distance;
    }
    private void dijkstra(int source, int destination){
        PriorityQueue<Integer> list = new PriorityQueue<>();
        list.add(source);
        final Vertex[] adjacencyList = graph.adjacencyList;
        adjacencyList[source].distance = 0;
        while(list.size()>0){
            int index = list.poll();
            if(index == destination){
                break;
            }
            Vertex x = adjacencyList[index];
            if(x.visited){
                continue;
            }
            for(int i = 0; i< x.edges.size(); i++){
                if(adjacencyList[x.edges.get(i)].visited){
                    continue;
                }
                adjacencyList[x.edges.get(i)].distance = Math.min(adjacencyList[x.edges.get(i)].distance, x.distance + graph.distanceTo(index, x.edges.get(i)));
                list.offer(x.edges.get(i));
            }
            x.visited = true;
        }
    }
}
