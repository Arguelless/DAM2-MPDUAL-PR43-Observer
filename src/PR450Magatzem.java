import java.util.ArrayList;

public class PR450Magatzem {
    private ArrayList<PR450Producte> productes;
    private int capacitat = 10;

    public PR450Magatzem() {
        productes = new ArrayList<PR450Producte>();

    }

    public void addProducte(PR450Producte p) {
        if (productes.size() < capacitat) {
            productes.add(p);
        }
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                productes.remove(i);
                break;
            }
        }
    }

    public String toString() {
        String s = "Productes al magatzem: [  ";
        for (int i = 0; i < productes.size(); i++) {
            s += productes.get(i).getId() + ": " + productes.get(i).getNom() + ", ";
        }
        return s.substring(0, s.length() - 2) + "  ]";
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
}
