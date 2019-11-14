
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class RegisterLocker  extends JFrame{
    private JPanel JPanelRegister;
    private JLabel JLabelEnrollment;
    private JTextField TextFieldEnrollment;
    private JLabel JLabelName;
    private JTextField TextFieldName;
    private JLabel JLabelSpecialism;
    private JTextField TextFieldSpecialism;
    private JComboBox ComboBoxSemester;
    private JComboBox ComboBoxGroup;
    private JButton buttonToAccept;
    private JButton buttonCancel;


    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String db = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "mora";
    private static final String password = "mora";

    private Connection cn;
    private PreparedStatement ps;

    private void limpiarCajas() {
        TextFieldEnrollment.setText(null);
        TextFieldName.setText(null);
        TextFieldSpecialism.setText(null);
        ComboBoxGroup.setSelectedIndex(0);
        ComboBoxSemester.setSelectedIndex(0);


    }



    public void consultas() {
        try {



            Class.forName(drive);
            cn = DriverManager.getConnection(db, user, password);

            String sql = "INSERT INTO usuario (idusuario, nombre, carrera, semestre, grupo ) VALUES (?, ?, ?, ? ,? )";
            ps = cn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(TextFieldEnrollment.getText()));
            ps.setString(2, TextFieldName.getText());
            ps.setString(3, TextFieldSpecialism.getText());
            ps.setString(4, (String) ComboBoxSemester.getSelectedItem());
            ps.setString(5, (String) ComboBoxGroup.getSelectedItem());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Reservacion exitosa");
            cn.close();
            limpiarCajas();
            dispose();

        }catch (Exception e){

            System.err.println(e);
        }

    }


    public RegisterLocker() {

        super("Resgistro de Locker");
        this.setContentPane(JPanelRegister);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        TextFieldEnrollment.setBorder(new LineBorder(Color.BLACK,0));
        TextFieldName.setBorder(new LineBorder(Color.BLACK,0));
        TextFieldSpecialism.setBorder(new LineBorder(Color.BLACK,0));




        buttonToAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                consultas();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                dispose();
            }
        });
    }

    public void eliminar(){

        try {


            Class.forName(drive);
            cn = DriverManager.getConnection(db, user, password);

            String sql = "DELETE FROM usuario WHERE idusuario=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(TextFieldEnrollment.getText()));


            int resp = ps.executeUpdate();

            if ( resp > 0 ) {
                JOptionPane.showMessageDialog(null,"Reservacion cancelada");
            }
            cn.close();

        }catch (Exception e){

            System.err.println(e);
        }


    }


}
