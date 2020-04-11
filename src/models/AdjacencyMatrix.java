package models;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyMatrix {

    private HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> matrix;

    public AdjacencyMatrix(Graph graph) {
        init(graph);
        build(graph);
    }

    private void init(Graph graph) {
        matrix = new HashMap<Integer, ArrayList<HashMap<Integer, Integer>>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {

            ArrayList<HashMap<Integer, Integer>> verticesValues = new ArrayList<HashMap<Integer, Integer>>();

            for (int j = 1; j <= graph.getNumberOfVertices(); j++) {
                HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
                hm.put(j, 0);
                verticesValues.add(hm);
            }

            matrix.put(i, verticesValues);
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            for(HashMap<Integer, Integer> hm : matrix.get(edge.getVertex1())) {
                if (hm.containsKey(edge.getVertex2())) {
                    hm.replace(edge.getVertex2(), 1);
                }
            }
            for(HashMap<Integer, Integer> hm : matrix.get(edge.getVertex2())) {
                if (hm.containsKey(edge.getVertex1())) {
                    hm.replace(edge.getVertex1(), 1);
                }
            }
        }
    }

    public HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> getMatrix() {
        return matrix;
    }

    public void setMatrix(HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> matrix) {
        this.matrix = matrix;
    }

    public void addvertexRow(Integer vertex, ArrayList<HashMap<Integer, Integer>> vertex2) {
        if (matrix.get(vertex) == null) {
            matrix.put(vertex, vertex2);
        }
    }

    public void addvertex2Tovertex(Integer vertex, Integer vertex2, int value) {
        ArrayList<HashMap<Integer, Integer>> vertexList;

        vertexList = matrix.get(vertex);

        if (vertexList != null) {

            if (!containsvertex(vertexList, vertex2)) {
                HashMap<Integer, Integer> vertexValueHash = new HashMap<Integer, Integer>();

                vertexValueHash.put(vertex2, value);

                vertexList.add(vertexValueHash);
            }
        }
    }

    private boolean containsvertex (ArrayList<HashMap<Integer, Integer>> list ,Integer vertex2) {

        for(HashMap<Integer, Integer> obj: list) {
            if(obj.get(vertex2) != null) {
                return true;
            }
        }

        return false;
    }
}
