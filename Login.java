import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

    private JPanel JPanelLogin;
    private JLabel JLabelUsuario;
    private JTextField JTextFieldUserName;
    private JLabel JLabelPassword;
    private JPasswordField JPasswordField;
    private JButton JButtonAceptar;

    private String user = "1";
    private String password = "1";



    public Login(){

            super("Login");
            setContentPane(JPanelLogin);
            setSize(300, 500);
            setLocationRelativeTo(null);
            setResizable(false);


            Border border = BorderFactory.createLineBorder(Color.white, 5);
            JTextFieldUserName.setBorder(border);
            JPasswordField.setBorder(border);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButtonAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    String userJT = JTextFieldUserName.getText();
                    String passwordJP = new String(JPasswordField.getPassword());

                    if(user.equals(userJT) && password.equals(passwordJP)) {
                        Locker lock = new Locker();
                        lock.setVisible(true);
                        dispose();
                    }
                }
            });

        JButtonAceptar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                super.keyPressed(k);

                String userJT = JTextFieldUserName.getText();
                String passwordJP = new String(JPasswordField.getPassword());

                if(k.getKeyCode() == KeyEvent.VK_ENTER) {

                    if(user.equals(userJT) && password.equals(passwordJP)) {
                        Locker lock = new Locker();
                        lock.setVisible(true);
                        dispose();
                    }
                }
            }
        });
    }

        public static void main( String [] args ) {
                JFrame frame = new Login();
                DBconexion db = new DBconexion();
                //db.ShowALL();
                frame.setVisible(true);
        }


}

