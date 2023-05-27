
import java.util.LinkedList;

/**
 *
 * @author Huynh Van Phuot
 */
public class Queue {

    LinkedList<Vertex> t;

    Queue() {
        t = new LinkedList<>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Vertex p) {
        t.addLast(p);
    }

    Vertex dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }
}
