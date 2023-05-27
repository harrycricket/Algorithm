
/**
 *
 * @author Huynh Van Phuot
 */
public class Main {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.addFirst("Welcome");
        list.addLast("CSD");
        list.traverse();
        list.addAtPosition(0, "***");
        list.traverse();
        list.addLast("////");
        list.traverse();
        list.addAtPosition(3, "+++");
        list.traverse();
        list.addAtPosition(2, "to");
        list.removeFirst();
        list.traverse();
        list.removeLast();
        list.traverse();
        list.removeLastV2();
        list.traverse();

    }
}
