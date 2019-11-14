import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Locker extends JFrame {

    private JPanel JPanelLockers;



    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JComboBox comboBoxLocker;
    private JButton buttonCancel;


    public Locker() {


        super("Lockers");
        this.setContentPane(JPanelLockers);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        //setVisible(false)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a1Button.setFocusable(false);
        buttonCancel.setEnabled(false);
        comboBoxLocker.setEnabled(false);

        buttonCancel.addActionListener(new ActionListener() {
            RegisterLocker rl = new RegisterLocker();
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBoxLocker.getSelectedIndex() == 1) {
                    a1Button.setEnabled(true);
                    a1Button.setBackground(new Color(255, 160, 122));
                    rl.eliminar();
                }
            }
        });



        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                RegisterLocker rl = new RegisterLocker();
                rl.setVisible(true);
                a1Button.setEnabled(false);

            }
        });



        a1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                a1Button.setBackground(new Color(255, 69, 0));
                comboBoxLocker.setEnabled(true);
                buttonCancel.setEnabled(true);


            }
        });






    }

}
