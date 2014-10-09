package application;

import javax.swing.*;

/**
 * Author Grinch
 * Date: 07.10.14
 * Time: 22:20
 */
public class MainWindow extends JFrame {
    private JPanel panel1;

    public MainWindow(){
        super("GEOClient:Connect");
        //setIconImage(new ImageIcon("res/icon.gif").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(panel1);
        pack();
        setLocationRelativeTo(null);
    }
}
