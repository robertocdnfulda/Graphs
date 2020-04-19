package models;

import java.util.ArrayList;

public class Graph {

    private String name;

    private int numberOfVertices;

    private ArrayList<Edge> edges;

    private ArrayList<Vertex> vertices;

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public int getNumberOfEdges() {
        return  edges.size();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
