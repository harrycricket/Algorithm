
/**
 *
 * @author Huynh Van Phuot
 */
public class Main {

    public static void main(String[] args) {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.addFirst(200);
        list.addLast(5);
        list.addFirst(3);
        list.addLast(7);
        list.addFirst(100);
        list.addLast(30);
        list.addFirst(19);
        list.addLast(123);
        list.show();
    }
}
