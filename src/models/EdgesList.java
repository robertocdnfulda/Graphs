package models;

import java.util.ArrayList;

public class EdgesList {

    private ArrayList<Edge> kanten;

    public EdgesList() {
        kanten = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getKanten() {
        return kanten;
    }

    public void setKanten(ArrayList<Edge> kanten) {
        this.kanten = kanten;
    }

    public void addKante(Edge edge) {
        kanten.add(edge);
    }
}
