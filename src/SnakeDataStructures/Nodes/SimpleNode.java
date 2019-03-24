package SnakeDataStructures.Nodes;

public class SimpleNode<T> {

    private T contain;
    private SimpleNode<T> parent;
    private SimpleNode<T> leftChild;
    private SimpleNode<T> rightChild;

    public SimpleNode(T contain, SimpleNode<T> parent){
        this.contain = contain;
        this.parent = parent;
    }


    public T getContain(){
        return contain;
    }

    public void setLeftChild(T contain){
        leftChild = new SimpleNode<>(contain, this  );
    }

    public void setRightChild(T contain){
        rightChild = new SimpleNode<>(contain, this );
    }

    public SimpleNode<T> getParent(){
        return parent;
    }

    public SimpleNode<T> getLeftChild(){
        return leftChild;
    }

    public SimpleNode<T> getRightChild(){
        return rightChild;
    }



}
