import java.util.ArrayList;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class PR450Magatzem {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);
    private ArrayList<PR450Producte> productes;
    private int capacitat;

    public PR450Magatzem() {
        productes = new ArrayList<PR450Producte>();
        capacitat = 10;
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }
    
    public void addProducte(PR450Producte p) {
        if (capacitat > 0) {
            this.capacitat--;
            int newValue = this.capacitat;
            llistaObservers.firePropertyChange("magatzemAdd", p.getId(), newValue);
            productes.add(p);
        }
    }

    public void removeProducte(int id) {
        for (int i = 0; i < productes.size(); i++) {
            if (productes.get(i).getId() == id) {
                this.capacitat++;
                int newValue = this.capacitat;
                llistaObservers.firePropertyChange("magatzemRemove", id, newValue);
                llistaObservers.firePropertyChange("magatzemEntrega", id, null);
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


    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }
}
