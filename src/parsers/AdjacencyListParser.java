package parsers;

import models.AdjacencyList;
import models.Graph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AdjacencyListParser {
    public static void toDot(Graph graph, AdjacencyList adjacencyList) {
        try {
            Date date = new Date();
            FileWriter writer = new FileWriter("../../output/" + graph.getName() + "_" + date.getTime() + ".dot");

            writer.write("digraph " + graph.getName() + " { ");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
