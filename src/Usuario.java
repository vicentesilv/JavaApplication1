public class Usuario {
    private String nombre;
    private int edad;
    private double saldo;

    public Usuario(String nombre, int edad, double saldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.saldo = saldo;
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", edad=" + edad + ", saldo=" + saldo + '}';
    }
}
