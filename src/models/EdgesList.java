package models;

import java.util.ArrayList;

public class EdgesList {

    private ArrayList<Edge> edges;

    public EdgesList(Graph graph) {
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

}
