import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String[] args) {

        PR450Producte p0 = new PR450Producte(0, "Llibre");
        PR450Producte p1 = new PR450Producte(1, "Boli");
        PR450Producte p2 = new PR450Producte(2, "Rotulador");
        PR450Producte p3 = new PR450Producte(3, "Carpeta");
        PR450Producte p4 = new PR450Producte(4, "Motxilla");

        PR450Magatzem magatzem = new PR450Magatzem();
        PR450Entregues entregues = new PR450Entregues();

        // Aquí afegir els property listeners adequats
        PropertyChangeListener l0 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat el id de %s a %s \n", evt.getOldValue(), evt.getNewValue());
            }
        };

        PropertyChangeListener l1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("Producte ha canviat el nom de %s a %s \n", evt.getOldValue(), evt.getNewValue());
            }
        };

        PropertyChangeListener listenerEliminar = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha esborrat el producte amd id %s al magatzem, capacitat %s \n", evt.getOldValue(), evt.getNewValue());
            }
        };
        PropertyChangeListener listenerAfegir = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amd id %s al magatzem, capacitat %s \n", evt.getOldValue(), evt.getNewValue());
            }
        };

        PropertyChangeListener listenerMagatzemEntrega = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                for (int i = 0; i < magatzem.getProductes().size(); i++) {
                    if (magatzem.getProductes().get(i).getId() == (int) evt.getOldValue()) {
                        entregues.addProducte(magatzem.getProductes().get(i));
                        break;
                    }
                }
                System.out.printf("S'ha mogut el producte amd id %s del magatzem cap a les entregues \n", evt.getOldValue());
            }
        };

        PropertyChangeListener entreguesAdd = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha afegit el producte amd id %s a les entregues \n", evt.getOldValue());
            }
        };

        PropertyChangeListener entreguesRemove = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.printf("S'ha entregat el producte amd id %s \n", evt.getOldValue());
            }
        };

        entregues.addPropertyChangeListener("entreguesAdd", entreguesAdd);
        entregues.addPropertyChangeListener("entreguesRemove", entreguesRemove);
        magatzem.addPropertyChangeListener("magatzemEntrega", listenerMagatzemEntrega);
        magatzem.addPropertyChangeListener("magatzemRemove", listenerEliminar);
        magatzem.addPropertyChangeListener("magatzemAdd", listenerAfegir);
        p0.addPropertyChangeListener("producteId", l0);
        p0.addPropertyChangeListener("producteName", l1);
        p1.addPropertyChangeListener("producteId", l0);
        p1.addPropertyChangeListener("producteName", l1);
        p2.addPropertyChangeListener("producteId", l0);
        p2.addPropertyChangeListener("producteName", l1);
        p3.addPropertyChangeListener("producteId", l0);
        p3.addPropertyChangeListener("producteName", l1);
        p4.addPropertyChangeListener("producteId", l0);
        p4.addPropertyChangeListener("producteName", l1);

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");

        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        entregues.removeProducte(2);
        entregues.removeProducte(3);

        System.out.println(magatzem);
        System.out.println(entregues);

    }
}
