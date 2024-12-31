package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener {
    // Declaring Globally
    JButton delete;
    String username;

    // Constructor for DeleteCustomer, takes a username as a parameter
    DeleteCustomer(String username) {
        // Initialize the username
        this.username = username;
        
        // Set the JFrame properties
        setBounds(220, 110, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // Create and add labels for user information
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(30, 20, 150, 25);
        add(lblusername);

        JLabel Labelusername = new JLabel(); 
        Labelusername.setBounds(220, 20, 150, 25); 
        add(Labelusername); 
        
        JLabel lblid = new JLabel("Id:");
        lblid.setBounds(30, 80, 150, 25);
        add(lblid);

        JLabel Labelid = new JLabel(); 
        Labelid.setBounds(220, 80, 150, 25); 
        add(Labelid); 
        
        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(30, 140, 150, 25);
        add(lblnumber);

        JLabel Labelnumber = new JLabel(); 
        Labelnumber.setBounds(220, 140, 150, 25); 
        add(Labelnumber); 
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(30, 200, 150, 25);
        add(lblname);

        JLabel Labelname = new JLabel(); 
        Labelname.setBounds(220, 200, 150, 25); 
        add(Labelname); 
        
        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(30, 260, 150, 25);
        add(lblgender);

        JLabel Labelgender = new JLabel(); 
        Labelgender.setBounds(220, 260, 150, 25); 
        add(Labelgender); 
        
        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(500, 20, 150, 25);
        add(lblcountry);

        JLabel Labelcountry = new JLabel(); 
        Labelcountry.setBounds(690, 20, 150, 25);
        add(Labelcountry);
        
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(500, 80, 150, 25);
        add(lbladdress);

        JLabel Labeladdress = new JLabel(); 
        Labeladdress.setBounds(690, 80, 150, 25); 
        add(Labeladdress); 
        
        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(500, 140, 150, 25);
        add(lblphone);

        JLabel Labelphone = new JLabel(); 
        Labelphone.setBounds(690, 140, 150, 25); 
        add(Labelphone); 
        
        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(500, 200, 150, 25);
        add(lblemail);

        JLabel Labelemail = new JLabel(); 
        Labelemail.setBounds(690, 200, 150, 25); 
        add(Labelemail); 
                     
        // Create and configure the "Delete All" button     
        delete = new JButton("Delete All");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(380, 305, 100, 30); 
        delete.addActionListener(this);
        add(delete);
        
        
        try {
            // Create a database connection
            Conn c = new Conn();  
            // Retrieve user data from the database
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
                // Retrieve data from the ResultSet and set it to the corresponding JLabels
                Labelusername.setText(rs.getString("username"));
                Labelid.setText(rs.getString("id"));
                Labelnumber.setText(rs.getString("number"));
                Labelname.setText(rs.getString("name"));
                Labelgender.setText(rs.getString("gender"));
                Labelcountry.setText(rs.getString("country"));
                Labeladdress.setText(rs.getString("address"));
                Labelphone.setText(rs.getString("phone"));
                Labelemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    // ActionListener interface implementation for button click
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            // Delete user data from various database tables
            c.s.executeUpdate("DELETE FROM account WHERE username = '" + username + "'");
            c.s.executeUpdate("DELETE FROM customer WHERE username = '" + username + "'");
  c.s.executeUpdate("DELETE FROM bookpackage WHERE username = '" + username + "'");
                     
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
           
    // Main method to test the DeleteCustomer class
    public static void main(String[] args) {
        new DeleteCustomer("username");
    }
}
