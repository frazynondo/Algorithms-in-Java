package LinkedList;

public class Node<T extends Comparable<T>> {

    private T data;
    Node<T> nextNode;
    Node<T> previousNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getpreviousNode() {
        return nextNode;
    }

    public void setpreviousNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }


}
