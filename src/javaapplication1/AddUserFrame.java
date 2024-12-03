import javax.swing.*;

public class AddUserFrame extends JFrame {

    private JTextField txtNombre, txtEdad, txtSaldo;
    private Principal mainFrame;

    public AddUserFrame(Principal mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Usuario");
        setSize(300, 250);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 20, 150, 25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 60, 100, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(120, 60, 150, 25);
        add(txtEdad);

        JLabel lblSaldo = new JLabel("Saldo:");
        lblSaldo.setBounds(20, 100, 100, 25);
        add(lblSaldo);

        txtSaldo = new JTextField();
        txtSaldo.setBounds(120, 100, 150, 25);
        add(txtSaldo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 160, 100, 25);
        btnGuardar.addActionListener(e -> guardarUsuario());
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 160, 100, 25);
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);
    }

    private void guardarUsuario() {
        try {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            double saldo = Double.parseDouble(txtSaldo.getText());

            Usuario nuevoUsuario = new Usuario(nombre, edad, saldo);
            mainFrame.agregarUsuario(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario agregado con éxito!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el usuario. Verifique los datos.");
        }
    }
}
