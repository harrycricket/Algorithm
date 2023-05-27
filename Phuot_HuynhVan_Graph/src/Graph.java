
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author Huynh Van Phuot
 */
public class Graph extends TreeSet<Vertex>{

    public Graph() {
        super();
    }
    
    public void addVertex(Vertex v) {
        this.add(v);
    }
    Vertex get (String vertexName) {
        Iterator it = this.iterator();
        while (it.hasNext()) {            
            Vertex v = (Vertex)(it.next());
            if (v.name.equals(vertexName))
                return v;
        }
        return null;
    }
    
    public boolean addEdge(String nameFrom, String nameTo) {
        Vertex u = this.get(nameFrom);
        Vertex v = this.get(nameTo);
        if (u == null || v == null) 
            return false;
        Edge e = new Edge(u, v, 1);
        u.adjList.add(e);
        return true;
    }
    
    public boolean addEdge(Vertex u, Vertex v) {
        if (u == null || v == null) 
            return false;
        Edge e = new Edge(u, v, 1);
        u.adjList.add(e);
        return true;
    }
    
    public boolean addEdge(String nameFrom, String nameTo, double w) {
        Vertex u = this.get(nameFrom);
        Vertex v = this.get(nameTo);
        if (u == null || v == null) 
            return false;
        Edge e = new Edge(u, v, w);
        u.adjList.add(e);
        return true;
    }
    
    public boolean addEdge(Vertex u, Vertex v, double w) {
        if (u == null || v == null) 
            return false;
        Edge e = new Edge(u, v, w);
        u.adjList.add(e);
        return true;
    }
    
    public Graph loadFromFile(String fName) {
        Graph g = null;
        File f = new File(fName);
        if(!f.exists()) {
            System.out.println("File not found!");
            System.exit(0);
            return g;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line = null;
            StringTokenizer stk = null;
            line = bf.readLine();
            if(line != null) {
                g = new Graph();
                stk = new StringTokenizer(line, " ");
                while (stk.hasMoreTokens()) {                    
                    String name = stk.nextToken();
                    Vertex v = new Vertex(name);
                    g.add(v);
                }
            }
            while ((line = bf.readLine()) != null) {                
                stk = new StringTokenizer(line, " ");
                String nameFrom = stk.nextToken();
                Vertex u = g.get(nameFrom);
                while (stk.hasMoreTokens()) {                    
                    String nameTo = stk.nextToken();
                    Vertex v = g.get(nameTo);
                    g.addEdge(u, v);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            g = null;
        }
        return g;
    }

    @Override
    public String toString() {
        String S = "Empty graph";
        if (this == null || this.isEmpty())
            return S;
        S = "Graph:\n";
        for (Vertex u : this) {
            S += u.getName() + "\t";
            for (Edge e : u.getAdjList()) {
                S += e.toString() + " ";
            }
            S += "\n";
        }
        return S;
    }
    
    protected int DFS(Vertex u, int order, ArrayList<Edge> edges) {
        int newOrder = order + 1;
        u.setNum(order);
        for (Edge e : u.getAdjList()) {
            Vertex v = e.getV();
            if (v.num == 0) {
                edges.add(e);
                newOrder = DFS(v, newOrder, edges);
            }
        }
        return newOrder;      
    }
    
    public ArrayList<Edge> depthFirstSearch() {
        ArrayList result = new ArrayList<Edge>();
        Object[] vertices = this.toArray();
        for (Object vertice : vertices) {
            Vertex v = (Vertex) vertice;
            v.num = 0;
        }
        
        int order = 1;
        for (Object vertice : vertices) {
            Vertex v = (Vertex) vertice;
            if (v.num == 0) {
                order = DFS(v, order, result);
            }
        }
        return !result.isEmpty() ? result : null;
    }
    
    public ArrayList<Edge> breadthFirstSearch() {
        ArrayList result = new ArrayList<Edge>();
        Queue queue = new Queue();
        
        Object[] vertices = this.toArray();
        for (Object vertice : vertices) {
            Vertex v = (Vertex) vertice;
            v.num = 0;
        }
        
        int order = 1;
        for (Object vertice : vertices) {
            Vertex u = (Vertex) vertice;
            if (u.num == 0) {
                u.num = order++;
                queue.enqueue(u);
                while (!queue.isEmpty()) {
                    u = queue.dequeue();
                    for (Edge e : u.adjList) {
                        Vertex v = e.getV();
                        if (v.num == 0) {
                            v.num = order++;
                            queue.enqueue(v);
                            result.add(e);
                        }
                    }
                }
            }
        }
        return !result.isEmpty() ? result : null;
    }
    
    public void printEdges (ArrayList<Edge> edges, PrintStream pw) {
        if (edges != null && !edges.isEmpty()) {
            pw.println("Set of edge");
            pw.println(edges);
        } else pw.println("No edge.");
    }  
}