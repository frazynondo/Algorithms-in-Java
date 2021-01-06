package Graphs;

public class graphAdjucent {
    //Adjucency Metrics representation
    //Number of vertices and edges in the graph
    private int Nodes, Egdes;
    private int [][] adMatrix;

    public graphAdjucent(int node) {
        /**Num of Vertices(Nodes) determines the Horizontal and vertical length of graph elements to be compared
         * For example if we have A B and C vertices then we initialize their Edges to zero by default
         * and set a value of one to the connected vertices. E.G if
         *    A  B  C
         * A  0  1  0 ---> A connects with B
         * B  0  0  1 ---> B connects to C
         * C  0  1  0 ---> Vertice C connects to B
         * */
        Nodes = node;
        Egdes = 0;
        adMatrix = new int[node][node];
        Egdes++;

    }

    public void addEdge(int U, int V){
     adMatrix[U][V] = 1; // setting up the connected edges
     adMatrix[V][U] = 1; // both nodew are connected in an undirected graph automatically
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(Nodes + " Vertices " + Egdes + " edges "+ "\n");
        for(int v = 0; v < Nodes; v++){
            sb.append(v + ": ");
            for (int w: adMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return  sb.toString();
    }
}
