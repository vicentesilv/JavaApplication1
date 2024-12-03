public class UsuarioPremium extends Usuario {
    private String beneficios;

    public UsuarioPremium(String nombre, int edad, double saldo, String beneficios) {
        super(nombre, edad, saldo);
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return super.toString() + ", beneficios=" + beneficios + '}';
    }
}
