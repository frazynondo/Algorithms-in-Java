package Graphs;

import java.util.*;

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


    public String GrapthToString(){

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

    public void DFSearch(int S){
        Stack<Integer> stack = new Stack<>();
        Boolean [] Visited = new Boolean[vertices_num];
        stack.push(S);

        while(!stack.isEmpty()){
            int U = stack.pop();
            if(Visited[U] != null){
                Visited[U] = true;
                System.out.println(U + " ");
                for(int v: adjListMap.get(U)){
                    if(Visited[v] != null){
                        stack.push(v);
                    }
                }
            }
        }
    }

    public void DFS(){
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int [] Visited = new int[adjListMap.size()];
//        int P;
        System.out.println(adjListMap.entrySet());

        stack.push(count);

        Visited[0] = 1;
        while(!stack.isEmpty()){
            int P = stack.pop();
            System.out.println(" -> "+ P);
         for(int v : adjListMap.get(P)){
//            System.out.println(v);
             if(Visited[v] != 1){
                 stack.push(v);
                 Visited[v] = 1;
             }
//             if(Visited[adjListMap.get(v).get(0)] != 1){
//                 stack.push(adjListMap.get(v).get(0));
//                 Visited[adjListMap.get(v).get(0)] = 1;
//         }
         }
//            if(adjListMap.get(P).get(0) != null){
//                if(Visited[adjListMap.get(P).get(0)] != 1){
//                    stack.push(adjListMap.get(P).get(0));
//                    Visited[adjListMap.get(P).get(0)] = 1;
//                }else if(Visited[adjListMap.get(P).get(1)] != 1){
//                    stack.push(adjListMap.get(P).get(1));
//                    Visited[adjListMap.get(P).get(1)] = 1;
//                }
//
//                }
            }
        }
        }



