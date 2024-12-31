package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{
    // Declaring Globally
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice, bookpackage, back;
    
    // Constructor for the BookPackage class
    BookPackage(String username){
        this.username = username;
        
        setBounds (150, 100, 1000, 500);
        setLayout (null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(150, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        // Username label and field        
        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblusername);

        labelusername = new JLabel(); // Create a new JLabel
        labelusername.setBounds(250, 70, 200, 20); // Set its bounds
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(labelusername); // Add it to the frame or container
        
        // Select Package label and choice
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Poornagiri");
        cpackage.add("Ritha Sahib");
        cpackage.add("Shyamalatal");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        // No. Of Persons for Booking label and field        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblperson.setBounds(40, 150, 150, 25);
        add(lblperson);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        // ID label and field        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);

        
        // Number label and field
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblnumber.setBounds(40, 230, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        // Phone label and field
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        add(labelphone);

        // Total Price label and field
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbltotal.setBounds(40, 310, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 25);
        add(labelprice);

        
        // Retrieve user data from the database and set to labels
        try {
            Conn c = new Conn();  // Create a database connection
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            if (rs.next()) {
        // Retrieve data from the ResultSet and set it to the corresponding JLabels
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Check Price button
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        // Book Package button
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        // Back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        // Add an image to the frame
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image image = icon.getImage().getScaledInstance(460, 360, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);

        JLabel label12 = new JLabel(scaledIcon);
        label12.setBounds(500, 50, 460, 360);
        add(label12);
        
        setVisible(true);
        
    }
    
    // Action event handler for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0; // Initialize cost variable
            if (pack.equals("Poornagiri")) {
                cost += 3000;
            } else if (pack.equals("Ritha Sahib")) {
                 cost += 4500;
            } else if (pack.equals("Shyamalatal")) {
                 cost += 2000;
            }           
                int persons = Integer.parseInt(tfpersons.getText()); // Parse the number of persons
                cost *= persons; // Calculate the total cost based on the number of persons
                 labelprice.setText("Rs " + cost); // Update the total cost label
            
        } else if (ae.getSource() == bookpackage) {
                try{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookpackage value('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
        } else {
             setVisible(false); // Hide the frame if neither button was clicked
        }
}
    // Main method to create an instance of BookPackage
    public static void main(String[] args) {
        new BookPackage("username");
    }
    
}