import java.util.ArrayList;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class PR450Entregues {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes;

    public PR450Entregues() {
        productes = new ArrayList<PR450Producte>();
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public void addProducte(PR450Producte p) {
        llistaObservers.firePropertyChange("entreguesAdd", p.getId(), null);
        productes.add(p);
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                llistaObservers.firePropertyChange("entreguesRemove", id, null);
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

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }
}
