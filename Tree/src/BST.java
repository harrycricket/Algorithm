
import java.io.RandomAccessFile;

/**
 *
 * @author Huynh Van Phuot
 */
public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.println(p.getInfo() + " ");
        }
    }

    public void fVisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.getInfo() + " ");
        }
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (this.isEmpty()) {
            root = newNode;
            return;
        }
        Node p = root;
        Node temp = null;
        while (p != null) {
            if (p.getInfo() == x) {
                System.out.println("Can't duplicated this value!");
                return;
            }
            temp = p;
            if (p.getInfo() < x) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (newNode.getInfo() > temp.getInfo()) {
            temp.right = newNode;
        } else {
            temp.left = newNode;
        }
    }

//    public void traverse() {
//        Node tmp = root;
//        while (tmp != null) {
//            System.out.println(tmp.info);
//            tmp = tmp.left;
//            tmp = tmp.right;
//        }
//    }
    public void preOrder(Node p) {

    }

    public void inOrder(Node p) {

    }

    public void postOrder(Node p) {

    }

    public Node search(int x) {
        Node p = new Node(x);
        return p;
    }

    public void delete(int x) {

    }

    public void deleteByMerging(int x) {

    }

    public void deleteByCopying(int x) {

    }
}
