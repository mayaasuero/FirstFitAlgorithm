/**
 * TITLE: Graph
 * DESCRIPTION: This class implements a graph represented through an adjacency list.
 */

import java.util.LinkedList;
//Contributed by Sumit Ghosh, GeeksForGeeks
//Graph implementation : Undirected, unweighted, LinkedList
public class Graph {
    private int V;
    private LinkedList<Integer> adjListArray[];
    private int[] vColors; // Stores the colors of the vertices
    private int maxColors;

    // constructor
    Graph(int V) {
        maxColors = 1;
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];
        vColors = new int[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getAdjListArray() {
        return adjListArray;
    }

    // Adds an edge to an undirected graph
    public void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest.
        graph.adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjListArray[dest].add(src);
        //System.out.println("Edge: " + src + " " + dest);
    }

    // A utility function to print the adjacency list
    // representation of graph
    public void printGraph(Graph graph)
    {
        for(int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public void color(int vertex, int color) {
        if(color > maxColors) {
            this.maxColors = color;
        }
        vColors[vertex] = color;
    }

    public int getColor(int vertex) {
        return vColors[vertex];
    }

    // added NEW
    // get LL
    public LinkedList<Integer> getAdjacent(int vertex, Graph graph){
        return graph.adjListArray[vertex];
    }

    //temporary
    public void printSolution(){
        for(int i = 0; i < adjListArray.length; i++){
            System.out.print("(Vertex: " + i + "; Color: " + getColor(i) + ") ");
            if((i+1)%5 == 0){
                System.out.println();
            }
        }
    }

    public int getMaxColors(){
        return maxColors;
    }
}