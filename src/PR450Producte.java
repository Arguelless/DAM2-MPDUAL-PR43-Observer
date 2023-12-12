import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;


public class PR450Producte {
    private PropertyChangeSupport llistaObservers = new PropertyChangeSupport(this);

    private int id;
    private String nom;

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int newValue) {
        int oldValue = this.id;
        if (oldValue != newValue) {
            this.id = newValue;
            llistaObservers.firePropertyChange("producteId", oldValue, newValue);
        }
    }

    public void setNom(String newValue) {
        String oldValue = this.nom;
        if (!oldValue.equals(newValue)) {
            this.nom = newValue;
            llistaObservers.firePropertyChange("producteName", oldValue, newValue);
        }

    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        llistaObservers.removePropertyChangeListener(name, listener);
    }
}
