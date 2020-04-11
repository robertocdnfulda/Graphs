package models;

import java.util.ArrayList;
import java.util.HashMap;

public class IncidenceMatrix {

    private HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> matrix;

    public IncidenceMatrix(Graph graph) {
        init(graph);
        build(graph);
    }

    private void init(Graph graph) {

        matrix = new HashMap<Integer, ArrayList<HashMap<Edge, Integer>>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {

            ArrayList<HashMap<Edge, Integer>> edgesValues = new ArrayList<HashMap<Edge, Integer>>();

            for (Edge edge: graph.getEdges()) {
                HashMap<Edge, Integer> edgeValue = new HashMap<Edge, Integer>();
                edgeValue.put(edge, 0);
                edgesValues.add(edgeValue);
            }

            matrix.put(i, edgesValues);
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            for(HashMap<Edge, Integer> hm : matrix.get(edge.getVertex1())) {
                if (hm.containsKey(edge)) {
                    hm.replace(edge, 1);
                }
            }
            for(HashMap<Edge, Integer> hm : matrix.get(edge.getVertex2())) {
                if (hm.containsKey(edge)) {
                    hm.replace(edge, 1);
                }
            }
        }
    }

    public HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> getMatrix() {
        return matrix;
    }

}
