
import java.util.ArrayList;

/**
 *
 * @author Huynh Van Phuot
 */
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile("Graph.txt");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g.depthFirstSearch();
        System.out.println("Depth First Search");
        g.printEdges(edges, System.out);
        
        edges = g.breadthFirstSearch();
        System.out.println("Breadth First Search");
        g.printEdges(edges, System.out);
    }
}
