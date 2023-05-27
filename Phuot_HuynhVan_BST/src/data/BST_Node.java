package data;

/**
 *
 * @author Huynh Van Phuot
 * @param <T>
 */
public class BST_Node<T extends Comparable<? super T>> {

    protected T el;
    protected BST_Node<T> left, right;

    public BST_Node() {
        left = right = null;
    }

    public BST_Node(T el) {
        this(el, null, null);
    }

    public BST_Node(T el, BST_Node<T> left, BST_Node<T> right) {
        this.el = el;
        this.left = left;
        this.right = right;
    }

//public class BST_Node {
//    private Student info;
//    BST_Node left, right;
//
//    public BST_Node(Student std) {
//        this(std, null, null);
//    }
//
//    public BST_Node(Student info, BST_Node left, BST_Node right) {
//        this.info = info;
//        this.left = left;
//        this.right = right;
//    }
//
//    public Student getInfo() {
//        return info;
//    }
//
//    public void setInfo(Student info) {
//        this.info = info;
//    }
//
//    public BST_Node getLeft() {
//        return left;
//    }
//
//    public void setLeft(BST_Node left) {
//        this.left = left;
//    }
//
//    public BST_Node getRight() {
//        return right;
//    }
//
//    public void setRight(BST_Node right) {
//        this.right = right;
//    }

    

}
