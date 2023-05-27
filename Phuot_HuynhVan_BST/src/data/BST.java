package data;

/**
 *
 * @author Huynh Van Phuot
 * @param <T>
 */
public class BST<T extends Comparable<? super T>> {

    protected BST_Node<T> root = null;

    public BST() {
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T el) {
        if (isEmpty()) {
            root = new BST_Node<>(el);
            return;
        }
        BST_Node<T> p = root;
        BST_Node<T> prev = null;
        while (p != null) {
            prev = p;
            if (p.el.compareTo(el) < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (prev.el.compareTo(el) < 0) {
            prev.right = new BST_Node<>(el);
        } else {
            prev.left = new BST_Node<>(el);
        }
    }

    protected BST_Node<T> recInsert(BST_Node<T> p, T el) {
        if (isEmpty()) {
            p = new BST_Node<>(el);
        } else if (p.el.compareTo(el) < 0) {
            p.right = recInsert(p.right, el);
        } else {
            p.left = recInsert(p.left, el);
        }
        return p;
    }

    public void recInsert(T el) {
        root = recInsert(root, el);
    }

    public T search(T el) {
        BST_Node<T> p = root;
        while (p != null) {
            if (el.equals(p.el)) {
                return p.el;
            } else if (el.compareTo(p.el) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public boolean isInTree(T el) {
        return search(el) != null;
    }

    protected void visit(BST_Node<T> p) {
        System.out.println(p.el + " ");
    }

    protected void inorder(BST_Node<T> p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    protected void preorder(BST_Node<T> p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    protected void postorder(BST_Node<T> p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }

    public void preorder() {
        preorder(root);
    }

    public void inorder() {
        inorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    public void deleteByMerging(T el) {
        BST_Node<T> p = root, prev = null;
        while (p != null && !p.el.equals(el)) {
            prev = p;
            if (p.el.compareTo(el) < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        BST_Node<T> node = p;
        BST_Node<T> tmp;
        if (p != null && p.el.equals(el)) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                tmp = node.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }

                tmp.right = node.right;
                node = node.left;
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("Element " + el + " is not in the tree");
        } else {
            System.out.println("The tree is empty!");
        }
    }

    public void deleByCopying(T el) {
        BST_Node<T> p = root, prev = null;
        while (p != null && !p.el.equals(el)) {
            prev = p;
            if (p.el.compareTo(el) < 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        BST_Node<T> node = p;
        if (p != null && p.el.equals(el)) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                BST_Node<T> previous = node;
                BST_Node<T> tmp = node.left;
                while (tmp.right != null) {
                    previous = tmp;
                    tmp = tmp.right;
                }
                node.el = tmp.el;

                if (previous == node) {
                    previous.left = tmp.left;
                } else {
                    previous.right = tmp.left;
                }
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("Element " + el + " is not in the tree");
        } else {
            System.out.println("The tree is empty!");
        }
    }

}
