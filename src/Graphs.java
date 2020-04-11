import models.*;
import parsers.FileParser;
import searches.BreadthFirstSearch;
import searches.DepthFirstSearch;

import java.io.File;
import java.util.Scanner;

public class Graphs {

    private static final String PATH = "graphs/";

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        File folder = new File(PATH);
        File[] listOfFiles = folder.listFiles();

        System.out.println("----- Graphen & Netzwerke ----- Roberto C.D.N -----");

        System.out.println("All Graphs available: ");

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getName());
            }
        }

        System.out.println("Please select a Graph(extension required): ");

        String graphName = in.nextLine();

        Graph graph = FileParser.toGraph(PATH + graphName);

        System.out.println("Please select one of the following procedures: ");
        System.out.println("1 - Breadth First Search (BFS)");
        System.out.println("2 - Depth First Search (DFS)");

        int op = in.nextInt();

        int source = 0;

        switch (op) {
            case 1:
                System.out.println("Please select the source node (1 - "+ graph.getNumberOfVertices() + "): ");
                source = in.nextInt();
                BreadthFirstSearch.search(graph, source);
                break;
            case 2:
                System.out.println("Please select the source node (1 - "+ graph.getNumberOfVertices() + "): ");
                source = in.nextInt();
                DepthFirstSearch.search(graph, source);
            default:
                System.out.println("No valid procedure selected.");

        }

        /*
        AdjacencyList adjazenzListe = new AdjacencyList();
        AdjacencyMatrix adjazenzMatrix = new AdjacencyMatrix();
        IncidenceMatrix inzidenzMatrix = new IncidenceMatrix(graph);
        EdgesList edgesListe = new EdgesList();
*/

        //IncidenceMatrix incidenceMatrix = new IncidenceMatrix(graph);
        //AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph);
        //AdjacencyList adjacencyList = new AdjacencyList(graph);

        //FileParser.toDot(graph);
    }

}
