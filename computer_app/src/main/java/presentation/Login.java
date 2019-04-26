package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login{
    private JFrame frame;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JPanel panel1;
    private JButton loginButton;
    private static String defaultUsername = "paulorenatoshoes";
    private static String defaultPassword = "prs";

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernameTextField.getText().equals(defaultUsername) && passwordTextField.getText().equals(defaultPassword)){
                    new MainMenu().show();
                    dispose();
                }
            }
        });
    }

    public void dispose(){
        frame.dispose();
    }

    public void show(){
        frame = new JFrame("Login");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getWidth()/5),(int) (screenSize.getHeight()/5));
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Login().show();
    }
}
