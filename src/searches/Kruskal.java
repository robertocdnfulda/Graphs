package searches;

import models.Edge;
import models.Graph;
import models.Vertex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kruskal {

    public static void search(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(graph.getNumberOfEdges(), Comparator.comparingInt(o -> o.getWeight()));

        for (Edge edge: graph.getEdges()) {
            priorityQueue.add(edge);
        }

        Vertex vertices[] = graph.getVertices().toArray(new Vertex[0]);
        Vertex parents[] = new Vertex[vertices.length];

        makeSet(parents, vertices);

        ArrayList<Edge> mst = new ArrayList<Edge>();

        int index = 0;

        while (index < vertices.length - 1) {
            Edge edge = priorityQueue.remove();

            Vertex x_set = find(parents, edge.getVertex1());
            Vertex y_set = find(parents, edge.getVertex2());

            if (x_set != y_set) {
                mst.add(edge);
                index++;
                union(parents, x_set, y_set);
            }

        }

        System.out.println("--- Kruskal - Minimum Spanning Tree ---");

        for (int i = 0; i < mst.size() ; i++) {
            Edge edge = mst.get(i);
            System.out.println("Edge") ;
            System.out.println("Vertex 1: " + edge.getVertex1().getVertex());
            System.out.println("Vertex 2: " + edge.getVertex2().getVertex());
            System.out.println("Weight: " + edge.getWeight());
            System.out.println("--------------------------------");
        }
    }

    private static void makeSet(Vertex[] parents, Vertex[] vertices) {
        for (int i = 0; i < vertices.length ; i++) {
            parents[i] = vertices[i];
        }
    }

    private static Vertex find(Vertex[] parents, Vertex vertex){
        if(parents[vertex.getVertex() - 1] != vertex)
            return find(parents, parents[vertex.getVertex() - 1]);;
        return vertex;
    }

    private static void union(Vertex[] parents, Vertex x, Vertex y){
        Vertex x_set_parent = find(parents, x);
        Vertex y_set_parent = find(parents, y);

        parents[y_set_parent.getVertex() - 1] = x_set_parent;
    }
}
