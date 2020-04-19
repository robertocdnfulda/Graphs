package searches;

import models.AdjacencyList;
import models.Graph;
import models.Vertex;

import java.util.ArrayList;
import java.util.Iterator;

public class DepthFirstSearch {

    private static int time = 0;
    private static ArrayList<Vertex> list = new ArrayList<Vertex>();

    public static void search(Graph graph, Vertex source) {
        AdjacencyList adjacencyList = new AdjacencyList(graph);
        search(source, adjacencyList);

        System.out.println("--- TopSort ---");
        for(Vertex vertex: list) {
            System.out.println("Vertex: " + vertex.getVertex());
            System.out.println("Finish Time: " + vertex.getFinishTime());
            System.out.println("--------------------------------");
        }
    }

    private static void search(Vertex vertex, AdjacencyList adjacencyList) {
        vertex.setVisited(true);
        time++;
        vertex.setDistance(time);

        System.out.println("Vertex: " + vertex.getVertex());
        System.out.println("Time: " + vertex.getDistance());
        if (vertex.getPrevious() != null) {
            System.out.println("Previous: " + vertex.getPrevious().getVertex());
        }
        System.out.println("--------------------------------");

        Iterator<Vertex> i = adjacencyList.getAdjacencyList().get(vertex).listIterator();

        while (i.hasNext()) {
            Vertex nextVertex = i.next();
            if(!nextVertex.isVisited()) {
                nextVertex.setPrevious(vertex);
                search(nextVertex, adjacencyList);
            }
        }
        time++;
        vertex.setFinishTime(time);
        list.add(vertex);

    }
}
