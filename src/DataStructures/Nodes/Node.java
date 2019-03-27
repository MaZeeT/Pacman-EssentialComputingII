package DataStructures.Nodes;

public abstract class Node<T> {

    private T contain;
    private Node<T> parent;
    Node<T>[] branches;

    Node(T contain, Node<T> parent) {
        this.contain = contain;
        this.parent = parent;
    }


    public T getContain() {
        return contain;
    }

    public Node<T> getParent() {
        return parent;
    }

    public abstract boolean addNode(int i, T contain);

    public abstract Node<T> getNode(int i);

}
