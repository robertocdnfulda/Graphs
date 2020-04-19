package searches;

import models.Edge;
import models.Graph;
import models.Vertex;

public class BellmannFord {

    public static void search(Graph graph, Vertex source) {
        Vertex vertices[] = graph.getVertices().toArray(new Vertex[0]);
        Edge edges[] = graph.getEdges().toArray(new Edge[0]);

        for (Vertex vertex: vertices) {
            vertex.setDistance(Integer.MAX_VALUE);
        }
        vertices[source.getVertex() - 1].setDistance(0);

        for (int i = 1;  i < vertices.length; ++i) {
            for (int j = 0; j < edges.length; ++j) {
                Vertex vertex1 = edges[j].getVertex1();
                Vertex vertex2 = edges[j].getVertex2();
                int weight = edges[j].getWeight();
                if (vertex1.getDistance() != Integer.MAX_VALUE && vertex1.getDistance() + weight < vertex2.getDistance()) {
                    vertex2.setDistance(vertex1.getDistance() + weight);
                }
            }
        }

        for (int j = 0; j < edges.length; ++j) {
            Vertex vertex1 = edges[j].getVertex1();
            Vertex vertex2 = edges[j].getVertex2();
            int weight = edges[j].getWeight();
            if (vertex1.getDistance() != Integer.MAX_VALUE && vertex1.getDistance() + weight < vertex2.getDistance()) {
                System.out.println("GRAPH WITH CYCLE!");
                return;
            }
        }

        System.out.println("Vertex | Distance");
        for (int i = 0; i < vertices.length; ++i) {
            System.out.println((i + 1) + "\t\t\t" + vertices[i].getDistance());
        }
        System.out.println("--------------------------------");
    }
}
