
/**
 *
 * @author Huynh Van Phuot
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void addFirst(String s) {
        Node p = new Node(s, null);
        if (this.isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void addLast(String s) {
        Node p = new Node(s, null);
        if (this.isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public void addAtPosition(int index, String s) {
        Node p = new Node(s, null);
        Node temp = head;

        if (index == 0) {
            addFirst(s);
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            p.next = temp.next;
            temp.next = p;
        }
    }
    
    public void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void removeLastV2() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }
    
    public void removeAtPosition(int index) {
        Node temp = head;
        if(index == 0) {
            removeFirst();
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
        }
    }
    
    public void removeAtPosition(String s) {
        
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//    Circular Linked List
//    addFirst() {
//        p.next = tail.next;
//        tail.next = p;
//    }
//
//    addLast() {
//        p.next = tail.next;
//        tail.next = p;
//        tail = p;
//    }
//    Double Linked List
//    addFirst() {
//        Node p = new Node(x, null, null);
//        if(isEmpty()) {
//            header = trailer = p;
//        } else {
//            header.pre = p;
//            p.next = header;
//            header = p;
//        }
//    }
}
