//sample 5040935924677501-----1487
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class login extends JFrame {
    public static void main(String[] args) {
        new login().buildLogin();
    }
    JFrame f = new JFrame("H BANK");
    JLabel l1 = new JLabel("WELCOME TO H BANK"),l2 = new JLabel("CARD NO:"),l3 = new JLabel("PIN:");
    JButton b1 = new JButton("SIGN IN"),b2 = new JButton("CLEAR"),b3 = new JButton("SIGN UP");
    JTextField tf = new JTextField(15);
    JPasswordField pf= new JPasswordField(15);
    public void buildLogin(){
        l1.setBounds(200,40,450,40);
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l2.setBounds(125,150,375,30);
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        tf.setBounds(300,150,230,30);
        tf.setFont(new Font("Arial", Font.BOLD, 14));
        pf.setBounds(300,220,230,30);
        pf.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        b1.addActionListener(e->{
            conn dbConnection = new conn();
            String cardNo = tf.getText(),pin = pf.getText();
            String query = "select * from login where cardno = '"+cardNo+"' and pin = '"+pin+"' ";
            try {
                ResultSet rs = dbConnection.s.executeQuery(query);
                //checking if user exists in the db
                if(rs.next()){
                    f.setVisible(false);
                    new Transactions(pin);
                }
                else {
                    JOptionPane.showMessageDialog(f,"Incorrect Card Number or PIN");
                    new login();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        b2.addActionListener(e->{
            tf.setText("");
            pf.setText("");
        });
        b3.addActionListener(e->{
            new Signup1();
            f.setVisible(false);
        });
        frameProperties();
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(tf);
        f.add(pf);
    }
    public void frameProperties (){
        f.setVisible(true);
        f.setSize(800,480);
        f.setLocation(550,200);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
