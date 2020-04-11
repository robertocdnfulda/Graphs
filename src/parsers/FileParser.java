package parsers;

import models.Edge;
import models.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class FileParser {

    public static Graph toGraph(String path) {

        String st;
        boolean firstRow = true;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        Graph graph = new Graph();

        String[] graphName = path.split("/");
        int splitName = graphName.length - 1;
        graph.setName(graphName[splitName].replace(".txt", ""));

        try {
            File file = new File(path);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String[] data;

            while ((st = br.readLine()) != null) {

                if(firstRow == true) {
                    graph.setNumberOfVertices(Integer.parseInt(st.trim()));
                    firstRow = false;
                } else {
                    data = st.split("\\s+");
                    Edge edge;

                    if(data.length == 3) {
                        edge = new Edge(Integer.parseInt(data[0]), Integer.parseInt(data[2]));
                        edge.setWeight(Integer.parseInt(data[1]));
                    } else {
                        edge = new Edge(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    }

                    edges.add(edge);
                }

            }

            graph.setEdges(edges);



        } catch (IOException e) {
            System.out.println(e);
        } finally {
            return graph;
        }

    }

    public static void toDot(Graph graph) {
        try {
            Date date = new Date();

            FileWriter writer = new FileWriter("output/" + graph.getName() + "_" + date.getTime() + ".dot");

            writer.write("digraph " + graph.getName() + " { ");

            for (int vertices = 1; vertices <= graph.getNumberOfVertices(); vertices++) {
                writer.write("  " + vertices + " [shape=circle]");
            }

            for (Edge edge: graph.getEdges()) {
                writer.write("  " + edge.getVertex1() +  " -> " + edge.getVertex2() + " [penwidth=2, arrowhead=none]");
            }

            writer.write(" } ");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
