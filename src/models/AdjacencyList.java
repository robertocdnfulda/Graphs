package models;

import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyList {

    private HashMap<Vertex, LinkedList<Vertex>> adjacencyList;

    public AdjacencyList(Graph graph) {
        init(graph);
        build(graph);
    }

    public HashMap<Vertex, LinkedList<Vertex>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(HashMap<Vertex, LinkedList<Vertex>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private void init(Graph graph) {
        adjacencyList = new HashMap<Vertex,  LinkedList<Vertex>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            adjacencyList.put(graph.getVertices().get(i - 1), new LinkedList<Vertex>());
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            LinkedList<Vertex> list = adjacencyList.get(edge.getVertex1());
            list.add(edge.getVertex2());

            list = adjacencyList.get(edge.getVertex2());
            list.add(edge.getVertex1());
        }
    }
}
