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

        if(this.root == null) return;

        --this.sizeOfList;

        if(this.root.getData().compareTo(data)==0){
            this.root = this.root.getNextNode();
        }else {
            remove(data, root, root.getNextNode());
        }

    }

    private void remove(T DataToRemove, Node<T> nodePrevious, Node<T> nodeCurrent){

        while(nodeCurrent != null){
            if(nodeCurrent.getData().compareTo(DataToRemove) == 0){
//                nodeCurrent = nodeCurrent.getNextNode();
//                nodePrevious.setNextNode(nodeCurrent);
                nodePrevious.setNextNode(nodeCurrent.getNextNode());
                nodeCurrent = null;
            }
            nodePrevious = nodeCurrent;
            nodeCurrent = nodeCurrent.getNextNode();
        }

    }

    @Override
    public void traverseList() {

        if(root == null) return;

        Node<T> currentNode = root;
        while(currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

    }

    @Override
    public int Size() {
        return this.sizeOfList;
    }
}
