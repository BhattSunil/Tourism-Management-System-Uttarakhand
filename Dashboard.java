package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    // Declaring Globally
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkpackages, bookpackage, viewpackage, deletePersonalDetails;

    // Constructor for the Dashboard class
    Dashboard(String username) {
        // Initialize the username
        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to be maximized
        setLayout(null);

        // Create the top panel (p1) with a background color and title
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 101));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        // Add an icon to the top panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(2, -5, 75, 75);
        p1.add(icon);

        // Add the title to the top panel
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(90, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        p1.add(heading);

        // Create the side panel (p2) with buttons for various functionalities
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 40));
        p2.setBounds(0, 65, 250, 900);
        add(p2);

        // Common button settings for alignment and spacing
        int btnWidth = 250, btnHeight = 40, marginTop = 80, btnGap = 20; // Increased marginTop to 80 for more spacing downwards

        // Add button
        addPersonalDetails = new JButton("Add Your Details");
        styleButton(addPersonalDetails, 0, marginTop, btnWidth, btnHeight);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Your Details");
        styleButton(updatePersonalDetails, 0, marginTop + (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Your Profile");
        styleButton(viewPersonalDetails, 0, marginTop + 2 * (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Your Account");
        styleButton(deletePersonalDetails, 0, marginTop + 3 * (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("View Packages");
        styleButton(checkpackages, 0, marginTop + 4 * (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Package");
        styleButton(bookpackage, 0, marginTop + 5 * (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(bookpackage);

        viewpackage = new JButton("View Booked Package");
        styleButton(viewpackage, 0, marginTop + 6 * (btnHeight + btnGap), btnWidth, btnHeight);
        p2.add(viewpackage);

        // Set up the main content area with a background image and title
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(251, 50, 1200, 800);
        add(image);

        setVisible(true);
    }

    Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void styleButton(JButton button, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMargin(new Insets(0, 15, 0, 0));
        button.addActionListener(this);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomers(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkpackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookpackage) {
            new BookPackage(username);
        } else if (ae.getSource() == viewpackage) {
            new ViewPackage(username);
        } else if (ae.getSource() == deletePersonalDetails) {
            new DeleteCustomer(username);
        }
    }

    // Main method to create an instance
    public static void main(String[] args) {
        new Dashboard("");
    }
}
