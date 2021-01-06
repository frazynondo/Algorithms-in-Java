package Graphs;

public class GraphRun {

    public static void main(String[] args){

        GraphLinkedList testList = new GraphLinkedList(4);
        testList.addEdge(0, 1);
        testList.addEdge(1, 2);
        testList.addEdge(2, 3);
        testList.addEdge(3, 0);
        System.out.println(testList);

    }
}
