package WorkInProgress;

import java.util.ArrayList;
import java.util.List;

//todo javaDoc
public class Tree<T> {

    private Node<T> root;
    private int size;

    public boolean contain(T item) {
        if (root != null) {
            return find(item, root) != null;
        } else {
            return false;
        }

    }

    private Node<T> find(T item, Node<T> parent) {
        if (parent.contain == item) {
            return parent;
        } else {
            if (parent.children != null) {
                for (Node<T> child : parent.children) {
                    Node<T> rtn = find(item, child);
                    if (rtn != null) {
                        return rtn;
                    }
                }
            }
        }
        return null;
    }

    public boolean add(T item) {
        return add(null, item);
    }

    public boolean add(T parentItem, T childItem) {
        if (root == null) {
            root = new Node<>(childItem, null);
            size++;
            return true;
        }
        // adds the childItem if it isn't already in the tree.
        if (!contain(childItem)) {
            Node<T> parent = find(parentItem, root);
            if (parent != null) {
                Node<T> child = new Node<>(childItem, parent);
                parent.addChild(child);
                size++;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public List<T> getAllParents(T item) {
        List<T> list = new ArrayList<>();
        Node<T> child = find(item, root);
        if (child != null) {
            boolean getNextParent = true;
            while (getNextParent) {
                list.add(child.contain);
                if (child.parent != null) {
                    child = child.parent;
                } else {
                    getNextParent = false;
                }
            }
        }
        return list;
    }

}

class Node<T> {

    T contain;
    Node<T> parent;
    List<Node<T>> children;

    Node(T contain, Node<T> parent) {
        this.contain = contain;
        this.parent = parent;
        children = new ArrayList<>();
    }

    void addChild(Node<T> child) {
        this.children.add(child);
        child.parent = this;
    }

}