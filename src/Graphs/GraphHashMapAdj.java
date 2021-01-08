package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GraphHashMapAdj {
    private Map<Integer, ArrayList<Integer>> adjListMap;

    private int vertices_num;
    private int Edges_num;

    public GraphHashMapAdj(int vertice) {
        this.vertices_num = vertice;
        this.Edges_num = 0;
        adjListMap = new HashMap<>();
//        System.out.println(vertices_num + " vertices, " + Edges_num + " Edges ");

        //Assign each Vertice a List with neighbouring Nodes
        for(int i = 0; i<vertices_num; i++){
            ArrayList<Integer> neghbours = new ArrayList<>();
            adjListMap.put(i, neghbours);
        }
    }

    public void addEdge(int v, int w){
        //Check if the inserted values are greater than the height and depth of the initialized graph
        if(v > adjListMap.size() || w > adjListMap.size()){
            return;
        }
        (adjListMap.get(v)).add(w);
        (adjListMap.get(w)).add(v);
        Edges_num = Edges_num + 1;
    }

    public ArrayList<Integer> getNeighbours(int v){

        if(v>adjListMap.size()){
            return null;
        }
        return new ArrayList<Integer>(adjListMap.get(v));
    }


    public String GrapthtoString(){

        StringBuilder sb = new StringBuilder();
        sb.append(this.vertices_num + " vertices, " + this.Edges_num + " Edges "+ " \n");
//      System.out.println(vertices_num + " vertices, " + Edges_num + " Edges ");

//        adjListMap.forEach((key, value) -> System.out.printf("Key: %s and Value: %s\n ", key, value));
//        System.out.println(" \n");

//        adjListMap.forEach((key, value) -> sb.append(key));
        for(Map.Entry v : adjListMap.entrySet()){
           // System.out.println("Key ->"+ v.getKey() + " Value -> "+v.getValue() + " Size --> "+ (adjListMap.get(v.getKey())).size());
            sb.append(v.getKey() + " :");
            for(int J = 0; J<(adjListMap.get(v.getKey())).size(); J++){
               sb.append(" -> " + adjListMap.get(v.getKey()).get(J));
//                System.out.println("Key: "+v.getKey()+ "Value --> "+ adjListMap.get(v.getKey()).get(J));
            }
           sb.append("\n");
        }

       System.out.println(sb.toString());
        return  sb.toString();
    }
}
