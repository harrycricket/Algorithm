
/**
 *
 * @author Huynh Van Phuot
 */
public class SinglyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node() {
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty");
        }
        System.out.println(head.getElement());
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("The list is empty");
        }
        System.out.println(tail.getElement());
    }

    //add
    public void addFirst(E e) {
//        SinglyLinkedList p = new SinglyLinkedList(e, null);
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> p = new Node<>(e, null);
        if (isEmpty()) {
            head = p;
        } else {
            tail.setNext(p);
            tail = p;
        }
        size++;
    }

    //remove 
    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        E p = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()) {
            tail = null;
        }
        return p;
    }
    
    public void show() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
