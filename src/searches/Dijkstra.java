package searches;

import models.AdjacencyMatrix;
import models.Edge;
import models.Graph;
import models.Vertex;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {

    public static void search(Graph graph, Vertex source) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph);
        HashMap<Vertex, HashMap<Vertex, Integer>> matrix = adjacencyMatrix.getMatrix();
        Vertex vertices[] = graph.getVertices().toArray(new Vertex[0]);

        for (Vertex vertex: vertices) {
            vertex.setDistance(Integer.MAX_VALUE);
            vertex.setVisited(false);
        }
        vertices[source.getVertex() - 1].setDistance(0);

        for (int i = 0; i < vertices.length; i++) {
            int minIndex = minDistance(vertices);

            vertices[minIndex].setVisited(true);

            for (int j = 0; j < vertices.length; j++) {
                if (!vertices[j].isVisited() && matrix.get(vertices[minIndex]).get(vertices[j]) != 0 && vertices[minIndex].getDistance() != Integer.MAX_VALUE
                        && vertices[minIndex].getDistance() + matrix.get(vertices[minIndex]).get(vertices[j]) < vertices[j].getDistance()) {
                    vertices[j].setDistance(vertices[minIndex].getDistance() + matrix.get(vertices[minIndex]).get(vertices[j]));
                }
            }
        }

        System.out.println("Vertex | Distance");
        for (int j = 0; j < vertices.length; j++) {
            System.out.println((j + 1) + " \t\t\t " + vertices[j].getDistance());
        }
        System.out.println("--------------------------------");

    }

    private static int minDistance(Vertex[] vertices)
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices.length; i++)
            if (!vertices[i].isVisited() && vertices[i].getDistance() <= min) {
                min = vertices[i].getDistance();
                minIndex = i;
            }

        return minIndex;
    }
}
