import java.util.ArrayList;

public class PR450Entregues {
    private ArrayList<PR450Producte> productes;

    public PR450Entregues() {
        productes = new ArrayList<PR450Producte>();
    }

    public void addProducte(PR450Producte p) {
        productes.add(p);
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
        String s = "Productes per entregar: [  ";
        for (int i = 0; i < productes.size(); i++) {
            s += productes.get(i).getId() + ": " + productes.get(i).getNom() + ", ";
        }
        return s.substring(0, s.length() - 2) + "  ]";
    }
}
