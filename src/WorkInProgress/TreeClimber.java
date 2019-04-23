package WorkInProgress;

import Entities.GameObject;
import Movement.IMover;
import WorkInProgress.Nodes.Node;

public class TreeClimber<T extends Comparable> implements IMover {
    private Node<T> root;

    public TreeClimber() {
        // new tree
        // exploreTree()
        // get list or queue
    }

    public boolean contain(T item) {
        return find(item, root) != null;
    }

    private Node<T> find(T item, Node<T> parent) {
        if (parent.contain == item) {
            return parent;
        } else {
            if (parent.children != null){
                for (Node<T> child : parent.children) {
                    Node<T> rtn = find(item, child);
                    if (rtn != null){
                        return rtn;
                    }
                }
            }
        }
        return null; //failed to find item in tree
    }

    private Node<T> findNode(Node<T> node) {    //todo quick copy-paste, needs review
        if (root.contain == node.contain) {
            return root;
        } else {
            if (root.children != null){
                for (Node<T> child : root.children) {
                    Node<T> rtn = find(node.contain, child);
                    if (rtn != null){
                        return rtn;
                    }
                }
            }
        }
        return null; //failed to find item in tree
    }

    public void add(Node<T> parent, Node<T> child) {
        find(parent.contain, root); //todo feel like this need to be T item and not Node parent
        // find.parent
        parent.addChild(child);
    }

    public boolean add(T item) {
        if (root == null) {
            root = new Node<>(item, null);
            return true;
        } else {
            return add(item, root);
        }
    }

    private boolean add(T item, Node<T> node) {
        for (Node<T> child : node.children) {
            if (child.contain == item) {
                System.out.println("?"); //todo fix
            }
        }
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


    @Override
    public void move() {
        //set position to shortestPathList.next()

    }

}
