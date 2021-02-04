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

    public void reverse(){
        if(root == null) return;
        reverseHelp(root);
    }
    //Reverse a linkedList
    public void reverseHelp(Node<T> node){


        Node<T> currentNode = node;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        while (previousNode != null){
            System.out.println("Node = :"+ previousNode.getData());
            previousNode = previousNode.getNextNode();
        }
    }

    public void reverseRecursive(){
        if(root == null) return;
        Node<T> previous = null, temp = null, next = null;
        temp = reverseRecursiveHelp(previous, root);

        while(temp != null){
            System.out.println("Next :"+ temp.getData());
            temp = temp.getNextNode();
        }
    }
    Node<T> tries;
    Node<T> test = null;
    private Node<T> reverseRecursiveHelp(Node<T> previous, Node<T> currentNode) {

        if(currentNode == null) {
            return null;
        } else {
//            System.out.println("Recursive Data is = "+ currentNode.getData());

//              temp.setNextNode(previous);
//              temp = currentNode;
//              previous = currentNode;
              if(currentNode.getNextNode() == null) return null;

              Node<T> temp = currentNode;
              temp.setNextNode(previous);
              previous = temp;
              currentNode = currentNode.getNextNode();
              reverseRecursiveHelp(previous, currentNode);

              return previous;

//               tries.setNextNode(test);
//               test = tries;


//
//            System.out.println("Recursive Temp Data is = "+ temp.getData());
////            System.out.println("Recursive Temp Next Data is = "+ temp.getNextNode().getData());
//            if(temp.getNextNode() == null){
//                System.out.println("Recursive Temp Next Data is = "+ 0);
//            }else {
//                System.out.println("Recursive Temp Next Data is = "+ temp.getNextNode().getData());
//            }
//
//            return temp;
        }


//        System.out.println("Current Recursive is = "+ currentNode.getNextNode().getData());
//        System.out.println("Current Recursive is = "+ currentNode.getData());
//        reverseRecursiveHelp(previousNode, currentNode.getNextNode());
//        Node<T> current = new Node<T>(currentNode.getData());
//        Node<T> temp = currentNode;
//        temp.setNextNode(previousNode);
//        previousNode = currentNode;

//        return temp;
    }

    //Method to find middle index of a LinkedList
    public void getMiddleNode(){
        if(root == null) return;
        //The helper returns the middle Index of the LinkedList
        getMiddleNodeHelper(root);
    }
    public Node<T> getMiddleNodeHelper(Node<T> node){

        Node<T> fastPointer = node;
        Node<T> slowPointer = node;

        //We increment Slow pointer twice as fast
        while(fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null){
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }

        return slowPointer;
    }



    public Node<T> removeDuplicates(){
        Node<T> temp = root, current = root;
        while(temp.getNextNode() != null) {
            System.out.println("--->" + temp.getData());
            while ((temp.getData().compareTo(temp.getNextNode().getData()) == 0)) {
                temp = temp.getNextNode();
                if (temp.getNextNode() == null) {
                    break;
                }
            }
            if (temp.getNextNode() != null) {
                temp = temp.getNextNode();
            } else {
                break;
            }

        }

        return current;
    }

    public Node<T> removeDuplicatesONE(){
        Node<T> current = root, head = root, tails = root;

        while (root != null){
            System.out.println("Root BEFORE ---> "+ root.getData());
            root = root.getNextNode();
        }

        while(current != null){
            Node<T> temp = current.getNextNode();
            while(temp != null && temp.getData().compareTo(current.getData()) == 0){
                temp = temp.getNextNode();
            }
            current.setNextNode(temp);
            current = temp;
        }

        while (head != null){
            System.out.println("Head ---> "+ head.getData());
            head = head.getNextNode();
        }

        return head;
    }

    @Override
    public int Size() {
        return this.sizeOfList;
    }
}
