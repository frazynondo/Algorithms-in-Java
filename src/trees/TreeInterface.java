package trees;

import java.util.List;

public interface TreeInterface<T> {

    public void traversal();
    //InOrder Traversal = Left --> Node --> Right
    public void In_OrderTraversal();
    //PreOrder Traversal = Node --> Left --> Right
    public void preOrderTraversal();
    public void insert(T data);
    public void delete(T data);
    public T getMax();
    public T getMin();

}
