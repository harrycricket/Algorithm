package data;

/**
 *
 * @author Huynh Van Phuot
 */
public class Node {
    Laptop info;
    Node next;

    public Node() {
    }

    public Node(Laptop info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Laptop getInfo() {
        return info;
    }

    public void setInfo(Laptop info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
