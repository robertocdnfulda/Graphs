package searches;

import models.AdjacencyList;
import models.Graph;
import models.Vertex;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public static void search(Graph graph, Vertex source) {

        AdjacencyList adjacencyList = new AdjacencyList(graph);

        LinkedList<Vertex> queue = new LinkedList<Vertex>();

        queue.add(source);

        while (queue.size() != 0) {
            source = queue.poll();
            System.out.println("Vertex: " + source.getVertex());
            System.out.println("Distance: " + source.getDistance());
            if (source.getPrevious() != null) {
                System.out.println("Previous: " + source.getPrevious().getVertex());
            }

            System.out.println("--------------------------------");

            Iterator<Vertex> i = adjacencyList.getAdjacencyList().get(source).listIterator();

            while (i.hasNext()) {
                Vertex vertex = i.next();
                if(!vertex.isVisited()) {
                    vertex.setVisited(true);
                    vertex.setDistance(source.getDistance() + 1);
                    vertex.setPrevious(source);
                    queue.add(vertex);
                }
            }

            source.setVisited(true);
        }
    }
}
