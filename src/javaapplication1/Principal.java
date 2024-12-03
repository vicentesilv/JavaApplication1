import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Principal extends JFrame {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;

    public Principal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("CRUD de Usuarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Lista de Usuarios");
        lblTitulo.setBounds(20, 20, 200, 25);
        add(lblTitulo);

        // Tabla para mostrar los usuarios
        modeloTabla = new DefaultTableModel(new Object[][]{}, new String[]{"Nombre", "Edad", "Saldo"});
        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(20, 60, 540, 200);
        add(scrollPane);

        JButton btnAgregar = new JButton("Agregar Usuario");
        btnAgregar.setBounds(20, 280, 150, 25);
        btnAgregar.addActionListener(e -> abrirVentanaAgregar());
        add(btnAgregar);

        JButton btnImprimir = new JButton("Imprimir PDF");
        btnImprimir.setBounds(200, 280, 150, 25);
        btnImprimir.addActionListener(e -> generarPDF());
        add(btnImprimir);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(380, 280, 150, 25);
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);
    }

    private void abrirVentanaAgregar() {
        AddUserFrame addUserFrame = new AddUserFrame(this);
        addUserFrame.setVisible(true);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        modeloTabla.addRow(new Object[]{usuario.getNombre(), usuario.getEdad(), usuario.getSaldo()});
    }

    private void generarPDF() {
        try {
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream("usuarios.pdf"));
            document.open();
            document.add(new com.itextpdf.text.Paragraph("Lista de Usuarios:"));
            for (Usuario usuario : usuarios) {
                document.add(new com.itextpdf.text.Paragraph(usuario.toString()));
            }
            document.close();
            JOptionPane.showMessageDialog(this, "PDF generado con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el PDF.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal().setVisible(true));
    }
}
