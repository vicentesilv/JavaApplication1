public class Usuario {
    private String nombre;
    private int edad;
    private double saldo;

    public Usuario(String nombre, int edad, double saldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.saldo = saldo;
    }

    public Usuario() {
        // Constructor vacío para inicialización en herencias
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean validarDatos() {
        return nombre != null && !nombre.isEmpty() && edad > 0 && saldo >= 0;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre='" + nombre + '\'' + ", edad=" + edad + ", saldo=" + saldo + '}';
    }
}
