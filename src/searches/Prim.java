package searches;

import models.*;

import java.util.*;

public class Prim {

    public static void search(Graph graph) {

        Vertex vertices[] = graph.getVertices().toArray(new Vertex[0]);
        AdjacencyEdgeList adjacencyEdgeList = new AdjacencyEdgeList(graph);
        HashMap<Vertex, LinkedList<Edge>> adjacencyList = adjacencyEdgeList.getAdjacencyList();

        boolean[] inPriorityQueue = new boolean[vertices.length];
        ResultSet[] resultSet = new ResultSet[vertices.length];
        int[] key = new int[vertices.length];

        HeapNode [] heapNodes = new HeapNode[vertices.length];
        for (int i = 0; i < vertices.length ; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = vertices[i];
            heapNodes[i].key = Integer.MAX_VALUE;
            resultSet[i] = new ResultSet();
            resultSet[i].previous = new Vertex(-1);
            inPriorityQueue[i] = true;
            key[i] = Integer.MAX_VALUE;
        }

        heapNodes[0].key = 0;

        PriorityQueue<HeapNode> priorityQueue = new PriorityQueue<HeapNode>(vertices.length,
                new Comparator<HeapNode>() {
                    @Override
                    public int compare(HeapNode o1, HeapNode o2) {
                        return o1.key - o2.key;
                    }
                });

        for (int i = 0; i < vertices.length ; i++) {
            priorityQueue.offer(heapNodes[i]);
        }

        while(!priorityQueue.isEmpty()){

            HeapNode extractedNode = priorityQueue.poll();
            Vertex extractedVertex = extractedNode.vertex;

            inPriorityQueue[extractedVertex.getVertex() - 1] = false;

            LinkedList<Edge> list = adjacencyList.get(extractedVertex);

            for (int i = 0; i < list.size() ; i++) {
                Edge edge = list.get(i);
                Vertex dest = edge.getVertex2();
                int newKey = edge.getWeight();
                if(inPriorityQueue[dest.getVertex() - 1]) {
                    if(key[dest.getVertex() - 1] > newKey) {
                        decreaseKey(priorityQueue, newKey, dest);
                        resultSet[dest.getVertex() - 1].previous = extractedVertex;
                        resultSet[dest.getVertex() - 1].weight = newKey;
                        key[dest.getVertex() - 1] = newKey;
                    }
                }
            }
        }

        int min_weight = 0;

        System.out.println("--- Prim - Minimum Spanning Tree ---");

        for (int i = 0; i < vertices.length ; i++) {
            if(resultSet[i].previous.getVertex() != -1) {
                System.out.println("Edge");
                System.out.println("Vertex 1: " + (i + 1));
                System.out.println("Vertex 2: " + resultSet[i].previous.getVertex());
                System.out.println("Weight: " + resultSet[i].weight);
                System.out.println("--------------------------------");
                min_weight += resultSet[i].weight;
            }
        }

        System.out.println("Total minimum key: " + min_weight);
    }

    public static void decreaseKey(PriorityQueue<HeapNode> priorityQueue, int newKey, Vertex vertex){

        Iterator it = priorityQueue.iterator();

        while (it.hasNext()) {
            HeapNode heapNode = (HeapNode) it.next();
            if(heapNode.vertex == vertex) {
                priorityQueue.remove(heapNode);
                heapNode.key = newKey;
                priorityQueue.offer(heapNode);
                break;
            }
        }
    }

    static class HeapNode{
        Vertex vertex;
        int key;
    }

    static class ResultSet {
        Vertex previous;
        int weight;
    }

}

