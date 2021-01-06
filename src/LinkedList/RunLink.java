package LinkedList;

public class RunLink {
    int value;
    public static void main(String [] args){


        LinkedList<Integer> test = new LinkedList<Integer>();
        test.insert(10);
        test.insert(20);
        test.insert(30);
        test.insert(40);
        test.insert(50);

       test.traverseList();
//        test.reverse();
        test.reverseRecursive();

    }


}
