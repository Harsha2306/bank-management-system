import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class miniStatement extends JFrame{
    JFrame f;
    JLabel l1,l2,l3,lone,ltwo,lthree;
    JButton b1;
    String pin;
    miniStatement(String pin){
        this.pin = pin;
        f = new JFrame("MINI STATEMENT");
        l1 = new JLabel("Indian Bank");
        l1.setBounds(200, 20, 100, 20);

        l2 = new JLabel(); //cardNo
        l2.setBounds(50,80,300,20);

        l3 = new JLabel();// balance
        l3.setBounds(50,480,300,20);

        lone = new JLabel();
        lone.setBounds(50,180,200,30);

        ltwo = new JLabel();
        ltwo.setBounds(50,240,200,30);

        lthree = new JLabel();
        lthree.setBounds(50,300,200,30);

        b1 = new JButton("BACK");
        b1.setBounds(50,520,100,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);

        b1.addActionListener(e->{
            f.setVisible(false);
            new Transactions(pin);});
        try {
            conn c1 = new conn();
            Statement stmt = c1.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            rs.last();
            int balance = rs.getInt(5);
            String b = String.format("%,.2f", (double) balance);
            l3.setText("Your Current Account Balance is Rs "+b);
        }
        catch (Exception ae){
            ae.printStackTrace();
        }

        try {
            conn c1 = new conn();
            Statement stmt = c1.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from login where pin = '"+pin+"'");
            rs.next();
            String cardNo = rs.getString(2);
            l2.setText("Card Number:    " + cardNo.substring(0,4)+ "XXXXXXXX" + cardNo.substring(12));
        }
        catch (Exception ae){
            ae.printStackTrace();
        }

        try {
            conn c1 = new conn();
            Statement stmt = c1.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            int i=0;
            int balance;
            String b;
            if(rs.last()) {
                balance = rs.getInt(4);
                b = String.format("%,.2f", (double) balance);
                lone.setText(rs.getString(2)+"      "+rs.getString(3)+"      "+b);
                while (rs.previous() && i < 2) {
                    balance = rs.getInt(4);
                    b = String.format("%,.2f", (double) balance);
                    if(ltwo.getText().equals(""))
                        ltwo.setText(rs.getString(2)+"      "+rs.getString(3)+"      "+b);
                    else
                        lthree.setText(rs.getString(2)+"      "+rs.getString(3)+"      "+b);
                    i++;
                }
            }
        }
        catch (Exception ae){
            ae.printStackTrace();
        }

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(520, 650);
        f.setLocation(480,100);
        f.getContentPane().setBackground(Color.WHITE);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(b1);
        f.add(lone);
        f.add(ltwo);
        f.add(lthree);
    }
}
