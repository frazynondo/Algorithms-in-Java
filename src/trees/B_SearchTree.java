package trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//To compare generic data we make the T extend comparable
public class B_SearchTree<T extends Comparable<T>> implements TreeInterface<T> {

    private Node<T> root;
/**
 * public B_SearchTree(T data) {
 * super(data);
 * }
 */

    @Override
    public void insert(T data){
     /**
      * Check if the root is null to create a new node with the new data else
      * the tree is not empty insert the data where it belongs in the tree.
      * We can use both insert and SetleftChild and rightChild from instatiation
      **/
        if(root == null){
            root = new Node<T>(data);
        } else {
            insertNodeHelper(data, root);
        }

    }

    public void preOrder_Itr(){
        Stack<Node<T>> S = new Stack<>();
        Node<T> node = root;

        if(node != null){
            S.push(node);

            while(!S.isEmpty()){

                node = S.pop();

//               testList.add(node.getData());
                System.out.println(node.getData());

                if(node.getRightChild() != null){
                    S.push(node.getRightChild());

                }
                if(node.getLeftChild() != null){
                    S.push(node.getLeftChild());
                }
            }

        }
    }

    private void insertNodeHelper(T newData, Node<T> node) {

        //Compare generic data using comparable's compare to
        if(newData.compareTo(node.getData()) < 0){
            /**
             * Check if the node's left child is not null so we can call
             * the method recursively again on the left child
             * */
            if(node.getLeftChild() != null){
                insertNodeHelper(newData, node.getLeftChild());
            } else {
                //if its null we create a new left child node
                node.setLeftChild(new Node<T>(newData));
            }
        } else {
            //The above procedures but in the RightChild perspective
            if(node.getRightChild() != null){
                insertNodeHelper(newData, node.getRightChild());
            }else {
                node.setRightChild(new Node<T>(newData));
            }
        }

    }

    @Override
    public void preOrderTraversal(){
        List<T> test = new ArrayList<>();
        /**
         * Here we return a list of pre-order values and asign them to test
         * **/
        if(root != null){
           test = preOrderTraversalHelper(root, test);
        }

        if(test != null){
            for(int i = 0; i < test.size(); i++){
                System.out.println("Nodes data is : "+ test.get(i));
            }
        }
    }

    private List<T> preOrderTraversalHelper(Node<T> node, List<T> test) {

        if(node == null) return test;

//        System.out.println(node.getData());
        test.add(node.getData());
        preOrderTraversalHelper(node.getLeftChild(), test);
        preOrderTraversalHelper(node.getRightChild(), test);

        return test;
    }

    @Override
    public void traversal() {

    }

    @Override
    public void In_OrderTraversal() {
        List<T> test = new ArrayList<>();
        if(root != null){
         test = In_OrderTraversalHelper(root, test);
        }

        if(test != null){
            for(int i = 0; i < test.size(); i++){
                System.out.println("Nodes data is : "+ test.get(i));
            }
        }
    }

    private List<T> In_OrderTraversalHelper(Node<T> node, List<T> test){

        if(node == null) return test;

        In_OrderTraversalHelper(node.getLeftChild(), test);
        test.add(node.getData());
        In_OrderTraversalHelper(node.getRightChild(), test);


        return test;
    }


    @Override
    public void delete(T data) {

    }

    /**************************************************/

    @Override
    public T getMax(){

        if(root == null) return null;

        return getMaxHelper(root);
    }


   private T getMaxHelper(Node<T> node) {

            if(node.getRightChild() != null){
                return getMaxHelper(node.getRightChild());
            }

            return node.getData();
    }

    /**************************************************/

    @Override
    public T getMin(){
       if(root == null) return null;

       return getMinHelper(root);
    }


  private T getMinHelper(Node<T> node) {

            if(node.getLeftChild() != null){
                return getMinHelper(node.getLeftChild());
            }

            return node.getData();

    }
}



