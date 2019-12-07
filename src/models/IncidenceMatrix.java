package models;

import java.util.ArrayList;
import java.util.HashMap;
import parser.FileParser;

public class IncidenceMatrix {

    private HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> matrix;

    public IncidenceMatrix(Graph graph) {
        init(graph);
        build(graph);
    }

    private void init(Graph graph) {
        matrix = new HashMap<Integer, ArrayList<HashMap<Edge, Integer>>>();

        ArrayList<HashMap<Edge, Integer>> edgesValues = new ArrayList<HashMap<Edge, Integer>>();

        for (Edge edge: graph.getEdges()) {
            HashMap<Edge, Integer> edgeValue = new HashMap<Edge, Integer>();
            edgeValue.put(edge, 0);
            edgesValues.add(edgeValue);
        }

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            matrix.put(i, edgesValues);
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            
        }
    }

    public HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> getMatrix() {
        return matrix;
    }

    public void setMatrix(HashMap<Integer, ArrayList<HashMap<Edge, Integer>>> matrix) {
        this.matrix = matrix;
    }

    public void addKnotenRow(Integer knoten, ArrayList<HashMap<Edge, Integer>> kanten) {
        if (matrix.get(knoten) == null) {
            matrix.put(knoten, kanten);
        }
    }

    public void addKanteToKnoten(Integer knoten, Edge edge, int value) {
        ArrayList<HashMap<Edge, Integer>> kanten;

        kanten = matrix.get(knoten);

        if (kanten != null) {

            if (!containsKante(kanten, edge)) {
                HashMap<Edge, Integer> kanteValueHash = new HashMap<Edge, Integer>();

                kanteValueHash.put(edge, value);

                kanten.add(kanteValueHash);
            }
        }
    }

    private boolean containsKante (ArrayList<HashMap<Edge, Integer>> list , Edge edge) {

        for(HashMap<Edge, Integer> obj: list) {
            if(obj.get(edge) != null) {
                return true;
            }
        }

        return false;
    }
}
