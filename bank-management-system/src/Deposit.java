import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;

public class Deposit extends JFrame {
    JFrame f;
    JTextField t1;
    JButton b1,b2;
    JLabel l1,l2;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        f = new JFrame("Deposit");

        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setBounds(120,70,270,30);
        l1.setFont(new Font("Raleway", Font.BOLD, 18));

        l2 = new JLabel("TO DEPOSIT");
        l2.setBounds(200,110,150,30);
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        t1 = new JTextField();
        t1.setBounds(165,160,180,35);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(140,220,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setBounds(270,220,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(520,450);
        f.setLocation(475,150);
        f.getContentPane().setBackground(Color.WHITE);

        f.add(t1);
        f.add(b1);
        f.add(l1);
        f.add(l2);
        f.add(b2);

        b1.addActionListener(e->{
            LocalDateTime ldt = LocalDateTime.now();
            String date ="";
            String year = String.valueOf(ldt.getYear());
            String d = String.valueOf(ldt.getDayOfMonth());
            String month = String.valueOf(ldt.getMonthValue());
            date = d+"-"+month+"-"+year;
            String amount = t1.getText();
            if(amount.equals("")) {
                JOptionPane.showMessageDialog(f, "Please enter the amount to deposit");
                f.setVisible(false);
                new Transactions("1234");
            }
            else{
                try {
                    conn c = new conn();
                    Statement stmt = c.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from bank where pin = '"+pin+"'");
                    if(rs.last()) {
                        int balance = rs.getInt(5);
                        balance = Integer.parseInt(amount) + balance;
                        String b = String.valueOf(balance);
                        c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "', '" + b + "');");
                        JOptionPane.showMessageDialog(f, "Rs. " + amount + " Deposited Successfully");
                        f.setVisible(false);
                        new Transactions(pin);
                    }
                    else {
                        c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "', '" + amount + "');");
                        JOptionPane.showMessageDialog(f, "Rs. " + amount + " Deposited Successfully");
                        f.remove(b2);
                        f.setVisible(false);
                        System.exit(0);
                    }
                }
                catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });
        b2.addActionListener(e->new Transactions(pin));
    }
}
