package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomers  extends JFrame implements ActionListener{
    // Declaring Globally
    JButton back;
    // Constructor for the View Customer class
    ViewCustomers(String username){
       
        setBounds (220, 110, 850, 550);
        setLayout (null);
        getContentPane().setBackground(Color.WHITE);
        
        
        // Create labels to display customer details
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
        
//        spliting into two columbs
        
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
                     
        // Add Back Button      
        back = new JButton("Back");
        back.setBackground (Color. BLACK) ;
        back.setForeground (Color.WHITE) ;
        back.setBounds (390, 305, 70,20);
        back.addActionListener(this);
        add (back);
        
        // Create an image icon and add it to the frame
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = il.getImage() .getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds (120, 335, 600, 200);
        add (image) ;
        
        
        try {
            // Create a database connection
            Conn c = new Conn();  
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
    
    // Action performed functionality when Back button clicked
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
       
    
    // The main method that initializes and shows the frame
    public static void main (String[] args){
        new ViewCustomers("sunil");
    }
}