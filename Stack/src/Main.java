
/**
 *
 * @author Huynh Van Phuot
 */
public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(3);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        stack.traverse();
        stack.top();
        stack.traverse();
        stack.pop();
        stack.pop();
        stack.traverse();
        
        
    }
}
