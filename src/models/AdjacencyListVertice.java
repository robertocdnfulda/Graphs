package models;

public class AdjacencyListVertice {

    private int vertice;

    private AdjacencyListVertice nextVertice;

    private AdjacencyListVertice lastVertice;

    public AdjacencyListVertice(int vertice) {
        this.vertice = vertice;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public AdjacencyListVertice getNextVertice() {
        return nextVertice;
    }

    public void setNextVertice(AdjacencyListVertice nextVertice) {
        this.nextVertice = nextVertice;
    }

    public AdjacencyListVertice getLastVertice() {
        return lastVertice;
    }

    public void setLastVertice(AdjacencyListVertice lastVertice) {
        this.lastVertice = lastVertice;
    }
}
