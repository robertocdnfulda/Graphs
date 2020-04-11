package searches;

import models.AdjacencyList;
import models.AdjacencyListVertice;
import models.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public static void search(Graph graph, int source) {

        AdjacencyList adjacencyList = new AdjacencyList(graph);

        boolean[] visitedVertices = new boolean[graph.getNumberOfVertices()];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visitedVertices[source - 1] = true;
        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.println("Vertex: " + source);

            Iterator<Integer> i = adjacencyList.getAdjacencyList().get(source).listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if(!visitedVertices[n - 1]) {
                    visitedVertices[n - 1] = true;
                    queue.add(n);
                }
            }
        }
    }
}
