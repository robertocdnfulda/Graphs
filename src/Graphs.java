import models.*;
import parser.FileParser;

public class Graphs {

    private static final String PATH = "/home/robertocdn/IdeaProjects/Graphs/graphs/k5.txt";

    public static void main(String args[]) {

        Graph graph = FileParser.toGraph(PATH);

        /*
        AdjacencyList adjazenzListe = new AdjacencyList();
        AdjacencyMatrix adjazenzMatrix = new AdjacencyMatrix();
        IncidenceMatrix inzidenzMatrix = new IncidenceMatrix(graph);
        EdgesList kantenListe = new EdgesList();
*/

    }

}
