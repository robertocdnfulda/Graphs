package models;

import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyEdgeList {

    private HashMap<Vertex, LinkedList<Edge>> adjacencyList;

    public AdjacencyEdgeList(Graph graph) {
        init(graph);
        build(graph);
    }

    public HashMap<Vertex, LinkedList<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(HashMap<Vertex, LinkedList<Edge>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private void init(Graph graph) {
        adjacencyList = new HashMap<Vertex,  LinkedList<Edge>>();

        for (int i = 1; i <= graph.getNumberOfVertices(); i++) {
            adjacencyList.put(graph.getVertices().get(i - 1), new LinkedList<Edge>());
        }
    }

    private void build(Graph graph) {
        for (Edge edge: graph.getEdges()) {
            LinkedList<Edge> list = adjacencyList.get(edge.getVertex1());
            list.add(edge);

            list = adjacencyList.get(edge.getVertex2());
            list.add(edge);
        }
    }
}
