package travel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
       JButton create, back; 
       JTextField tfname,tfusername,tfpassword,tfanswer;
       Choice security;
    Signup(){
    setBounds(250,200,700,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1= new JPanel();
        p1.setBackground(new Color(133,193,213));
        p1.setLayout(null);
        p1.setBounds(0,0,350,400);
        add(p1);
        
        JLabel lblusername= new JLabel("Username");
       lblusername.setFont(new Font("Tahoma",Font.BOLD,20));
       lblusername.setBounds(30,20,125,25);
       p1.add(lblusername);
       
       tfusername =new JTextField();
       tfusername.setBounds(140,20,160,25);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p1.add(tfusername);
        
      JLabel lblname= new JLabel("Name");
      lblname.setBounds(30, 45, 125, 25);
      lblname.setFont(new Font("Tahoma",Font.BOLD,20));
      p1.add(lblname);
      
     tfname= new JTextField();
      tfname.setBounds(140,50,160,25);
      tfname.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfname);
      
      
       JLabel lblpassword= new JLabel("Password");
      lblpassword.setBounds(30, 75, 125, 25);
      lblpassword.setFont(new Font("Tahoma",Font.BOLD,20));
      p1.add(lblpassword);
      
       tfpassword= new JTextField();
      tfpassword.setBounds(140,80,160,25);
      tfpassword.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfpassword);
      
         JLabel lblsecurity= new JLabel("Security Ques");
      lblsecurity.setBounds(20, 110, 125, 25);
      lblsecurity.setFont(new Font("Tahoma",Font.BOLD,20));
      p1.add(lblsecurity);
      
      
   security = new Choice();
    security.add("Who is your favourite teacher");
    security.add("FIrst Pet name");
    security.add("Favourite Athelete");
    security.setBounds(140,115,160,30);
    p1.add(security);
    
    
      JLabel lblanswer = new JLabel("Answer");
      lblanswer.setBounds(20, 140, 125, 25);
      lblanswer.setFont(new Font("Tahoma",Font.BOLD,20));
      p1.add(lblanswer);
      
      
  tfanswer= new JTextField();
      tfanswer.setBounds(140,140,160,25);
      tfanswer.setBorder(BorderFactory.createEmptyBorder());
      p1.add(tfanswer);
           
     
      create= new JButton("Create");
     create.setBackground( Color.WHITE);
     create.setForeground(Color.BLUE);
     create.setFont(new Font("Tahoma",Font.BOLD,14));
     create.setBounds(150, 190, 130, 50);
     create.setBackground(new Color(131,193,233));
     create.addActionListener(this);
     p1.add(create);
      
     back= new JButton("Back");
    back.setBackground(Color.WHITE);
    back.setForeground(Color.BLUE);
    back.setFont(new Font("Tahoma",Font.BOLD,14));
    back.setBounds(30, 190, 110, 50);
    back.addActionListener(this);
    back.setBackground(new Color(131,193,233));
    p1.add(back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
    Image i2 = i1.getImage().getScaledInstance(170, 200, Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400, 80, 200, 200);
    add(image);
   
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {  
        if(ae.getSource()==create)
        {
                String username = tfusername.getText();
                String name = tfname.getText();
                String password= tfpassword.getText();
                String question= security.getSelectedItem();
                String answer= tfanswer.getText();
                
                String query="insert into account values('"+username+"','"+name+"', '"+password+"','"+question+"','"+answer+"')";
                
                try{
                Conn c =new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created Successfully");
                
                    setVisible(false);
                    new Login();
                }
                catch
                (Exception e)
                {e.printStackTrace();
                }
              
            }
        else if(ae.getSource()== back){
                    setVisible(false);
                    new Login();
                    }
    }
    
    public static void main(String []args){
    new Signup();
}
}