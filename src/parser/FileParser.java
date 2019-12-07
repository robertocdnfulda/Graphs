package parser;

import models.Edge;
import models.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {

    public static Graph toGraph(String path) {

        String st;
        boolean firstRow = true;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        Graph graph = new Graph();

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
}
