package WorkInProgress;

import WorkInProgress.Nodes.Node;

//TODO implement a tree
//TODO Make a shortest route algorithm based on a tree.
public class Tree<T extends Comparable> {

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
        if (parent.contain == item) {   //nullPointer in test
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
        return null; //failed to find item in tree
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

    private boolean add(T item, Node<T> node) {
        // if (node.children != null) {
        for (Node<T> child : node.children) {   //nullPointer in test
            if (child.contain == item) {
                System.out.println("?"); //todo fix
            }
        }
        // }
        if (item.equals(node.contain)) {    //todo need a closer look
            node.addChild(new Node<>(item, node));
            return true;
        } else {

        }

        if (root == null) {
            root = new Node<>(item, null);
        } else {
            Node<T> node2 = new Node<>(item, root);
            root.addChild(node);
            root.children.add(node);
        }
        return false;
    }

    public int getSize() {
        return size;
    }

}
