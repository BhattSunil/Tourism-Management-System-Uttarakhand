package travel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

     Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          //  c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmgmtsystem", "root", "sunilbhatt@123");
           
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmgmtsystem", "root", "sunilbhatt@123");
           s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public static void main(String args []){
System.out.print("HEllo");
new Conn();
}}