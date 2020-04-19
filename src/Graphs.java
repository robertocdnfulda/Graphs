import models.*;
import parsers.FileParser;
import searches.*;

import java.io.File;
import java.util.Scanner;

public class Graphs {

    private static final String PATH = "graphs/";

    public static void main(String args[]) {

        String loop = "";

        Scanner in = new Scanner(System.in);

        File folder = new File(PATH);
        File[] listOfFiles = folder.listFiles();

        System.out.println("----- Graphen & Netzwerke ----- Roberto C.D.N -----");

        do {

            System.out.println("Please select one of the following procedures: ");
            System.out.println("1 - Breadth First Search (BFS)");
            System.out.println("2 - Depth First Search (DFS)");
            System.out.println("3 - Kruskal");
            System.out.println("4 - Prim");
            System.out.println("5 - Bellmann - Ford");
            System.out.println("6 - Dijkstra");
            System.out.println("7 - Floyd - Warshall");

            int op = in.nextInt();
            in.nextLine();

            System.out.println("Please select one of the following graphs (extension required): ");

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }
            }

            String graphName = in.nextLine();

            Graph graph = FileParser.toGraph(PATH + graphName);
            FileParser.toDot(graph);

            int source = 0;

            switch (op) {
                case 1:
                    System.out.println("Please select the source node (1 - " + graph.getNumberOfVertices() + "): ");
                    source = in.nextInt();
                    in.nextLine();
                    BreadthFirstSearch.search(graph, graph.getVertices().get(source - 1));
                    break;
                case 2:
                    System.out.println("Please select the source node (1 - " + graph.getNumberOfVertices() + "): ");
                    source = in.nextInt();
                    in.nextLine();
                    DepthFirstSearch.search(graph, graph.getVertices().get(source - 1));
                    break;
                case 3:
                    Kruskal.search(graph);
                    break;
                case 4:
                    Prim.search(graph);
                    break;
                case 5:
                    System.out.println("Please select the source node (1 - " + graph.getNumberOfVertices() + "): ");
                    source = in.nextInt();
                    in.nextLine();
                    BellmannFord.search(graph, graph.getVertices().get(source - 1));
                    break;
                case 6:
                    System.out.println("Please select the source node (1 - " + graph.getNumberOfVertices() + "): ");
                    source = in.nextInt();
                    in.nextLine();
                    Dijkstra.search(graph, graph.getVertices().get(source - 1));
                    break;
                case 7:
                    FloydWarshall.search(graph);
                    break;
                default:

            }

            System.out.println("----- END -----");

            System.out.println("Do you wish to start again?");
            loop = in.nextLine();

        } while (loop.toUpperCase().equals("Y") || loop.toUpperCase().equals("YES"));

    }

}
