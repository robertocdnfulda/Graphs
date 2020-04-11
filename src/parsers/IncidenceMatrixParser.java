package parsers;

import models.Edge;
import models.Graph;
import models.IncidenceMatrix;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class IncidenceMatrixParser {
    public static void toDot(Graph graph, IncidenceMatrix incidenceMatrix) {
        try {
            Date date = new Date();
            FileWriter writer = new FileWriter("../../output/" + graph.getName() + "_" + date.getTime() + ".dot");

            writer.write("digraph " + graph.getName() + " { ");
            writer.write(" ");

            HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> matrix = incidenceMatrix.getMatrix();

            for (int key: matrix.keySet()) {
                writer.write("  " + key + " [shape=circle]");
            }

            writer.write(" ");

            for (ArrayList<HashMap<Edge, Integer>> a : matrix.values()) {

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
