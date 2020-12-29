package trees;

public class RunTrees {

    public static void main(String [] args){

        B_SearchTree <Integer> BST = new B_SearchTree<>();
        //
        //
        //
        /**          20
         *        /     \
         *      10       30
         *     /  \     /  \
         *    5   15   25  40
         *   /      \
         *  3       17
         *   \
         *   4
         *
         * [38, 42, 62, 75, 90]
         * **/

        BST.insert(20);
        BST.insert(10);
        BST.insert(30);
        BST.insert(5);
        BST.insert(15);
        BST.insert(17);
        BST.insert(3);
        BST.insert(4);
        BST.insert(25);
        BST.insert(40);
        BST.nodeDepth();
//        BST.maxDiameter();
//        System.out.println("Minimum value %d is the answer : "+ BST.getMin());






    }
}
