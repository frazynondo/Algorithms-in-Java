package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T>{
    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;
        if(root == null){
         root = new Node<T>(data);
        } else {
            insertDataAtBeggining(data);
        }

    }

    private void insertDataAtBeggining(T data) {
        Node<T> temp = new Node<T>(data);
        temp.setNextNode(root);
        this.root = temp;
    }

    private void insertDataAtEnd(T data, Node<T> node){
        if(node.getNextNode() != null){
            insertDataAtEnd(data, node.getNextNode());
        }else{
            Node<T> newNode = new Node<T>(data);
            node.setNextNode(newNode);

        }

    }

    @Override
    public void remove(T data) {

    }

    @Override
    public void traverseList() {

    }

    @Override
    public int Size() {
        return 0;
    }
}
