package models;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyMatrix {

    private HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> matrix;

    public AdjacencyMatrix() {
        matrix = new HashMap<Integer, ArrayList<HashMap<Integer, Integer>>>();
    }

    public HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> getMatrix() {
        return matrix;
    }

    public void setMatrix(HashMap<Integer, ArrayList<HashMap<Integer, Integer>>> matrix) {
        this.matrix = matrix;
    }

    public void addKnotenRow(Integer knoten, ArrayList<HashMap<Integer, Integer>> knoten2) {
        if (matrix.get(knoten) == null) {
            matrix.put(knoten, knoten2);
        }
    }

    public void addKnoten2ToKnoten(Integer knoten, Integer knoten2, int value) {
        ArrayList<HashMap<Integer, Integer>> knotenList;

        knotenList = matrix.get(knoten);

        if (knotenList != null) {

            if (!containsKnoten(knotenList, knoten2)) {
                HashMap<Integer, Integer> knotenValueHash = new HashMap<Integer, Integer>();

                knotenValueHash.put(knoten2, value);

                knotenList.add(knotenValueHash);
            }
        }
    }

    private boolean containsKnoten (ArrayList<HashMap<Integer, Integer>> list ,Integer knoten2) {

        for(HashMap<Integer, Integer> obj: list) {
            if(obj.get(knoten2) != null) {
                return true;
            }
        }

        return false;
    }
}
