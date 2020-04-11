package parsers;

import models.AdjacencyMatrix;
import models.Graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AdjacencyMatrixParser {
    public static void toDot(Graph graph, AdjacencyMatrix adjacencyMatrix) {
        try {
            Date date = new Date();
            FileWriter writer = new FileWriter("../../output/" + graph.getName() + "_" + date.getTime() + ".dot");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
