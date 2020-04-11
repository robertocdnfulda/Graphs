package models;

import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyList {

    private HashMap<Integer, LinkedList<Integer>> adjacencyList;

    public AdjacencyList(Graph graph) {
        init(graph);
        build(graph);
    }

    public HashMap<Integer, LinkedList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(HashMap<Integer, LinkedList<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private void init(Graph graph) {
        adjacencyList = new HashMap<Integer,  LinkedList<Integer>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            adjacencyList.put(i, new LinkedList<Integer>());
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            LinkedList<Integer> list = adjacencyList.get(edge.getVertex1());
            list.add(edge.getVertex2());

            list = adjacencyList.get(edge.getVertex2());
            list.add(edge.getVertex1());
        }
    }
}
