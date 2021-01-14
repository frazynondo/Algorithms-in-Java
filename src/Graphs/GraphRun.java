package Graphs;

public class GraphRun {

    public static void main(String[] args){

//        GraphLinkedList testList = new GraphLinkedList(4);
//        testList.addEdge(0, 1);
//        testList.addEdge(1, 2);
//        testList.addEdge(2, 3);
//        testList.addEdge(3, 0);
//        System.out.println(testList);

//        Map<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();
//
//        adjListMap.size()
        GraphHashMapAdj temp = new GraphHashMapAdj(4);
        temp.addEdge(0, 1);
        temp.addEdge(1, 2);
        temp.addEdge(2, 3);
        temp.addEdge(3, 0);
//        temp.addEdge(5, 3);
//       temp.addEdge(4, 5);
//        temp.DFSearch(3);

//        temp.GrapthToString();
        temp.DFS();

    }
}
