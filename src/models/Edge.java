package models;

public class Edge {

    private Vertex vertex1;

    private Vertex vertex2;

    private int weight;

    public Edge(int knoten1, int knoten2) {
        this.vertex1 = new Vertex(knoten1);
        this.vertex2 = new Vertex(knoten2);
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
