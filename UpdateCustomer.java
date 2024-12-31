package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    // Declaring components globally
    JLabel Labelusername, Labelname;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid, tfgender;
    JButton add, back;

    // Constructor for UpdateCustomer class
    UpdateCustomer(String username) {
        // Set frame dimensions and layout
        setBounds(220, 110, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Heading
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        // Labels and Text Fields for each field
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        Labelusername = new JLabel();
        Labelusername.setBounds(220, 50, 150, 25);
        add(Labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        Labelname = new JLabel();
        Labelname.setBounds(220, 170, 150, 25);
        add(Labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 330, 150, 25);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone No. with Country Code");
        lblphone.setBounds(30, 370, 190, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 370, 150, 25);
        add(tfphone);

        // Update and Back Buttons
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        // Image for decoration
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = il.getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(475, 40, 250, 400);
        add(image);

        // Retrieve customer details from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            while (rs.next()) {
                Labelusername.setText(rs.getString("username"));
                Labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    // Handling button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            // Retrieve data from text fields
            String username = Labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = Labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            // Update customer details in the database
            try {
                Conn c = new Conn();
                String query = "UPDATE customer SET id = ?, number = ?, name = ?, gender = ?, country = ?, address = ?, phone = ?, email = ? WHERE username = ?";
                PreparedStatement pstmt = c.c.prepareStatement(query);
                pstmt.setString(1, id);
                pstmt.setString(2, number);
                pstmt.setString(3, name);
                pstmt.setString(4, gender);
                pstmt.setString(5, country);
                pstmt.setString(6, address);
                pstmt.setString(7, phone);
                pstmt.setString(8, email);
                pstmt.setString(9, username);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        new UpdateCustomer("username");
    }
}
