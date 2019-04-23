package WorkInProgress.Nodes;

import java.util.List;

public class Node<T> {

    public T contain;
    public Node<T> parent;
    public List<Node<T>> children;

    public Node(T contain, Node<T> parent) {
        this.contain = contain;
        this.parent = parent;
    }

    public void addChild(Node<T> child){
        this.children.add(child);
        child.parent = this;
    }

    public T getContain() {
        return contain;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

}
