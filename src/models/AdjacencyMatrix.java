package models;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyMatrix {

    private HashMap<Vertex, HashMap<Vertex, Integer>> matrix;

    public AdjacencyMatrix(Graph graph) {
        init(graph);
        build(graph);
    }

    public AdjacencyMatrix(Graph graph, boolean withWeight) {
        if (withWeight) {
            initWithWeight(graph);
            buildWithWeight(graph);
        } else {
            init(graph);
            build(graph);
        }
    }

    private void init(Graph graph) {
        matrix = new HashMap<Vertex, HashMap<Vertex, Integer>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {

            HashMap<Vertex, Integer> verticesValues = new HashMap<Vertex, Integer>();

            for (int j = 1; j <= graph.getNumberOfVertices(); j++) {
                verticesValues.put(graph.getVertices().get(j - 1), 0);
            }

            matrix.put(graph.getVertices().get(i - 1), verticesValues);
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            HashMap<Vertex, Integer> hm = matrix.get(edge.getVertex1());

            if (hm.containsKey(edge.getVertex2())) {
                hm.replace(edge.getVertex2(), 1);
            }

            hm = matrix.get(edge.getVertex2());

            if (hm.containsKey(edge.getVertex1())) {
                hm.replace(edge.getVertex1(), 1);
            }

        }
    }

    private void initWithWeight(Graph graph) {
        matrix = new HashMap<Vertex, HashMap<Vertex, Integer>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {

            HashMap<Vertex, Integer> verticesValues = new HashMap<Vertex, Integer>();

            for (int j = 1; j <= graph.getNumberOfVertices(); j++) {
                verticesValues.put(graph.getVertices().get(j - 1), Integer.MAX_VALUE);
            }

            matrix.put(graph.getVertices().get(i - 1), verticesValues);
        }
    }

    private void buildWithWeight(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            HashMap<Vertex, Integer> hm = matrix.get(edge.getVertex1());

            if (hm.containsKey(edge.getVertex2())) {
                hm.replace(edge.getVertex2(), edge.getWeight());
            }

            hm = matrix.get(edge.getVertex2());

            if (hm.containsKey(edge.getVertex1())) {
                hm.replace(edge.getVertex1(), edge.getWeight());
            }

        }
    }


    public HashMap<Vertex, HashMap<Vertex, Integer>> getMatrix() {
        return matrix;
    }

}
