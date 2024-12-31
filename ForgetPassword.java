package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ForgetPassword extends JFrame implements ActionListener{
    // Declaring Globally
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, getpassword, back;
    
// Constructor for the ForgetPassword class    
ForgetPassword () {
        setBounds (200, 150, 850, 380);
        getContentPane ().setBackground (Color. WHITE);
        setLayout (null);
        
        // Load and display an image
        ImageIcon il = new ImageIcon (ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = il.getImage().getScaledInstance (200, 200, Image. SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon (i2);
        JLabel image = new JLabel(i3);
        image.setBounds (580, 70, 200, 200);
        add (image);
        
        // Create a panel for form elements
        JPanel pl = new JPanel();
        pl.setLayout (null);
        pl.setBounds (30, 30, 500, 280);
        add (pl);
        
        // Add labels, text fields, and buttons for the form
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds (40, 20, 100, 25);
        lblusername.setFont (new Font ("Tahoma", Font. BOLD, 14));
        pl.add(lblusername);
        
        tfusername = new JTextField ();
        tfusername.setBounds (200, 20, 175, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);
        
        search = new JButton ("Search");
        search.setBackground (Color.LIGHT_GRAY);
        search.setForeground (Color. WHITE);
        search.setBounds (400, 20, 85, 25);
        search.addActionListener(this);
        pl.add (search); 

        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds (40, 60, 100, 25);
        lblname.setFont (new Font ("Tahoma", Font. BOLD, 14));
        pl.add(lblname);
        
        tfname = new JTextField ();
        tfname.setBounds (200, 60, 175, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);
        
        
        
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds (40, 100, 200, 25);
        lblquestion.setFont (new Font ("Tahoma", Font. BOLD, 14));
        pl.add(lblquestion);
        
        tfquestion = new JTextField ();
        tfquestion.setBounds (200, 100, 175, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfquestion);
        
        
        
        JLabel lblanswer = new JLabel("Your Answer");
        lblanswer.setBounds (40, 140, 200, 25);
        lblanswer.setFont (new Font ("Tahoma", Font. BOLD, 14));
        pl.add(lblanswer);
        
        tfanswer = new JTextField ();
        tfanswer.setBounds (200, 140, 175, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfanswer);
        
        getpassword = new JButton ("Retrieve");
        getpassword.setBackground (Color.LIGHT_GRAY);
        getpassword.setForeground (Color. WHITE);
        getpassword.setBounds (400, 140, 85, 25);
        getpassword.addActionListener(this);
        pl.add (getpassword);
        
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds (40, 180, 200, 25);
        lblpassword.setFont (new Font ("Tahoma", Font. BOLD, 14));
        pl.add(lblpassword);
        
        tfpassword = new JTextField ();
        tfpassword.setBounds (200, 180, 175, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpassword);
        
        
        
        back = new JButton ("Back To Login");
        back.setBackground (Color.LIGHT_GRAY);
        back.setForeground (Color. WHITE);
        back.setBounds (150, 240, 200, 25);
        back.addActionListener(this);
        pl.add (back); 

        
        setVisible (true);
    }

    // ActionListener interface implementation for button click
    public void actionPerformed (ActionEvent ae) {
    if (ae.getSource() == search) {
        try {
            // Retrieve user information based on the entered username
            String query = "SELECT * FROM account WHERE username = '" + tfusername.getText() + "'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
            tfname.setText(rs.getString("name"));
            tfquestion.setText(rs.getString("security"));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == getpassword) {
         try {
                // Retrieve the password based on the entered answer and username
                String query = "SELECT * FROM account WHERE answer ='" + tfanswer.getText() + "' AND username='" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
            tfpassword.setText(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
            // Return to the Login screen
            setVisible (false);
            new Login ();
        }
    }

    // The main method to run the application
    public static void main(String[] args) {
          new ForgetPassword ();
    }
}