package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GraphHashMapAdj {
    private Map<Integer, ArrayList<Integer>> adjListMap;

    public GraphHashMapAdj(int vertices_num) {

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
    }

    public ArrayList<Integer> getNeighbours(int v){

        if(v>adjListMap.size()){
            return null;
        }
        return new ArrayList<Integer>(adjListMap.get(v));
    }
}
