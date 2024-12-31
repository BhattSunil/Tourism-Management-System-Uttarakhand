package travel.management.system;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Loading extends JFrame implements Runnable {
	Thread t;
	JProgressBar bar;
	String username;

    Loading() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	public void run() {
		try {
			for(int i = 1;i <= 101;i++) {
				int max = bar.getMaximum();
				int val = bar.getValue();
				if(val < max) {
					bar.setValue(val+1);
				}
				else {
					setVisible(false);
					new Dashboard(username);
					//obj
				}
				Thread.sleep(50);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    Loading(String username){
    	this.username = username;
    	t = new Thread(this);
    	setBounds(370,200,650,400);
    	setVisible(true);
    	setLayout(null);
    	getContentPane().setBackground(Color.white);
    	JLabel text = new JLabel(" Champawat Tourism Application");
    	text.setBounds(110,30,600,40);
    	text.setFont(new Font("Raleway",Font.BOLD,25));
    	text.setForeground(Color.blue);
    	add(text);
    	 bar = new JProgressBar();
    	bar.setBounds(150,110,300,35);
    	bar.setStringPainted(true);
    	
    	add(bar);
    	JLabel loading = new JLabel("Loading please wait...");
    	loading.setBounds(200,140,600,30);
    	loading.setFont(new Font("Raleway",Font.BOLD,16));
    	loading.setForeground(Color.red);
    	add(loading);
    	JLabel username1 = new JLabel("Welcome "+username);
    	username1.setBounds(200,220,600,30);
    	username1.setFont(new Font("Raleway",Font.BOLD,16));
    	username1.setForeground(Color.blue);
    	add(username1);
    t.start();
    	
    	
    }
	public static void main(String[] args) {
		new Loading("username");

	}

}