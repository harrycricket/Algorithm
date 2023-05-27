
import java.util.EmptyStackException;

/**
 *
 * @author Huynh Van Phuot
 */
public class MyStack {
    Node top;

    public MyStack() {
        top = null;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    // addFirst()
    public void push(int x) {
        Node p = new Node(x, null);
        if(this.isEmpty()) {
            top = p;
        } else {
            p.next = top;
            top = p;
        }
    }
    
    // reference to see the info, not remove
    public void top() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            System.out.println(top.info);
        }
    }
    
    // removeLast()
    public void pop() {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            top = top.next;
        }
    }
    
    public void traverse() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
