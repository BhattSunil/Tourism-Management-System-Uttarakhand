package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField ppassword;
    JButton login, signup, forgot;

    Login() {
        setSize(800, 500);
        setLocation(200, 100);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 0, 400, 400);
        p2.setBackground(Color.WHITE);
        add(p2);

        JLabel username = new JLabel("Username");
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(username);

        tusername = new JTextField();
        tusername.setBounds(60, 60, 150, 40);
        p2.add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(60, 100, 100, 50);
        password.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        p2.add(password);

        ppassword = new JPasswordField();  // Changed to JPasswordField
        ppassword.setBounds(60, 160, 150, 40);
        p2.add(ppassword);

        // Creating Buttons
        login = new JButton("Login");
        login.setBounds(40, 210, 150, 60);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(200, 210, 150, 60);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgot = new JButton("Forgot Password");
        forgot.setBounds(100, 280, 150, 60);
        forgot.setBackground(new Color(133, 193, 233));
        forgot.setForeground(Color.WHITE);
        forgot.setBorder(new LineBorder(new Color(133, 193, 233)));
        forgot.addActionListener(this);
        p2.add(forgot);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = String.valueOf(ppassword.getPassword());  // Retrieve password securely

                String query = "select * from account where username ='" + username + "' AND password ='" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);// Ensure Loading class is properly implemented
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == forgot) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
