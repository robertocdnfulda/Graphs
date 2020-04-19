package searches;

import models.AdjacencyMatrix;
import models.Graph;
import models.Vertex;

import java.util.HashMap;
import java.util.Iterator;

public class FloydWarshall {

    public static void search(Graph graph) {
        Vertex vertices[] = graph.getVertices().toArray(new Vertex[0]);
        long distances[][] = new long[graph.getNumberOfVertices()][graph.getNumberOfVertices()];

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph, true);
        HashMap<Vertex, HashMap<Vertex, Integer>> matrix = adjacencyMatrix.getMatrix();

        Iterator v1 = matrix.entrySet().iterator();

        while (v1.hasNext()) {
            HashMap.Entry pairV1 = (HashMap.Entry)v1.next();
            Vertex vertex1 = (Vertex) pairV1.getKey();
            HashMap<Vertex, Integer> hM = matrix.get(vertex1);
            Iterator v2 = hM.entrySet().iterator();

            while (v2.hasNext()) {
                HashMap.Entry pairV2 = (HashMap.Entry)v2.next();
                Vertex vertex2 = (Vertex) pairV2.getKey();
                distances[vertex1.getVertex() - 1][vertex2.getVertex() - 1] = matrix.get(vertex1).get(vertex2);
            }
        }

        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                for (int x = 0; x < vertices.length; x++) {
                    if (distances[j][i] + distances[i][x] < distances[j][x]){
                        distances[j][x] = distances[j][i] + distances[i][x];
                    }
                }
            }
        }

        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i < vertices.length; ++i)
        {
            for (int j=0; j < vertices.length; ++j)
            {
                if (distances[i][j] == Integer.MAX_VALUE)
                    System.out.println("MAX VALUE ");
                else
                    System.out.println("Vertex 1: " + (i + 1) + " Vertex 2: " + (j + 1) + " Distance: " + distances[i][j]);
            }
        }
        System.out.println("--------------------------------");

    }
}
