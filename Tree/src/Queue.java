
import java.util.LinkedList;

/**
 *
 * @author Huynh Van Phuot
 */
public class Queue {
    LinkedList<Node> t;
    
    public void Queue() {
        t = new LinkedList<Node>();
    }
    
    public boolean isEmpty() {
        return t.isEmpty();
    }
    
    public void enqueue(Node p) {
        t.addLast(p);
    }
    
    public Node dequeue() {
        if(isEmpty()) {
            return null;
        } 
        return t.removeFirst();
    }
    
    public Node front() {
        if(isEmpty()) {
            return null;
        }
        return t.getFirst();
    }
}
