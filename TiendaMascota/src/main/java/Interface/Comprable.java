package Interface;

public interface Comprable {

    boolean isDisponible();
    void quitarStock();
    void agregarStock();
    void agregarNStock(int cantidad);
    void actualizarDB();
}
