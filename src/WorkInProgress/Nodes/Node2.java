package WorkInProgress.Nodes;


public class Node2<T> extends Node<T> {


    Node2(T contain, Node<T> parent) {
        super(contain, parent);
        branches = (Node<T>[]) new Object[2];
    }

    @Override
    public boolean addNode(int i, Object contain) {
        return false;
    }

    @Override
    public Node getNode(int i) {
        return null;
    }
}
