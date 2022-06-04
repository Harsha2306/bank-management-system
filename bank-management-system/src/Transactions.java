import javax.swing.*;
import java.awt.*;

public class Transactions extends JFrame {
    JFrame f;
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions(String pin){
        this.pin = pin;
        f = new JFrame("TRANSACTIONS");

        l1 = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(63,50,400,30);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(50,100,150,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(300,100,150,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);

        b3 = new JButton("FAST CASH");
        b3.setBounds(50,150,150,35);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(300,150,150,35);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(50,200,150,35);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(300,200,150,35);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);

        b7 = new JButton("EXIT");
        b7.setBounds(170,300,150,35);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);

        b7.addActionListener(e->System.exit(0));

        f.setVisible(true);
        f.setLayout(null);
        f.setSize(520,450);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocation(475,150);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(l1);

        b1.addActionListener(e->{
            f.setVisible(false);
             new Deposit(pin);
        });

        b2.addActionListener(e->{
            f.setVisible(false);
             new Withdrawl(pin);
        });

        b3.addActionListener(e->{
            f.setVisible(false);
             new FastCash(pin);
        });

        b4.addActionListener(e->{
            f.setVisible(false);
            new miniStatement(pin);
        });

        b5.addActionListener(e->{
            f.setVisible(false);
             new PinChange(pin);
        });

        b6.addActionListener(e->{
            f.setVisible(false);
             new getBalance(pin);
        });

        b7.addActionListener(e->System.exit(0));
    }
}
