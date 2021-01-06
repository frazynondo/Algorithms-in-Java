package Graphs;

import LinkedList.LinkedList;

public class GraphLinkedList {
    private LinkedList<Integer>[] Adjacents;
    //Number of vertices and number of edges
    private int Vertices, Edges;

    public GraphLinkedList(int nodes) {
        this.Vertices = nodes;
        this.Edges = 0;
        this.Adjacents = new LinkedList[nodes];

        for(int I = 0; I< nodes; I++){
            Adjacents[I] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        Adjacents[u].insert(v);
        Adjacents[v].insert(u);
        Edges++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(Vertices + " vertices, " + Edges + " Edges "+ " \n");
        for(int v = 0; v < Vertices; v++){
            sb.append(v + ": ");
            for( int J = 0; J< Adjacents[v].Size(); v++){
              sb.append(J + " ");
            }
            sb.append("\n");
        }
        return  sb.toString();
    }
}
