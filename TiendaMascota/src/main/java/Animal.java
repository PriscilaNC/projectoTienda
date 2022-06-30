abstract class Animal implements Comprable {
    private String nombre;
    private String raza;
    private String especie;
    private int stock = 1;
    private double masa;
    private int edad;
    private int valor;
    private boolean sexo;
    private String paisOrigen;
    private String tipoAlimentacion;

    public Animal(String nombre, String raza, String especie, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion) {
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
        this.masa = masa;
        this.edad = edad;
        this.valor = valor;
        this.sexo = sexo;
        this.paisOrigen = paisOrigen;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public abstract void crearJSON();

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return ""+ nombre + "," + raza + "," + especie + '\n' +
                ", masa=" + masa +
                ", edad=" + edad +
                ", valor=" + valor +
                ", sexo=" + sexo +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", tipoAlimentacion='" + tipoAlimentacion + '\'' +
                '}';
    }
}
