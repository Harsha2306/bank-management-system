import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class FastCash extends JFrame {
    JFrame f;
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    String pin;

    FastCash(String pin){
        this.pin = pin;
        f = new JFrame("FAST CASH");

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(120,40,300,30);

        b1 = new JButton("Rs 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,100,200,30);

        b2 = new JButton("Rs 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(270,100,200,30);

        b3 = new JButton("Rs 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(40,160,200,30);

        b4 = new JButton("Rs 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(270,160,200,30);

        b5 = new JButton("Rs 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setBounds(40,220,200,30);

        b6 = new JButton("Rs 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setBounds(270,220,200,30);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.setBounds(250,300,150,40);

        b8 = new JButton("BACK");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(70,300,150,40);

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(520, 450);
        f.setLocation(475,150);
        f.getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(e-> getInstantCash(b1.getText().substring(3)));

        b2.addActionListener(e-> getInstantCash(b2.getText().substring(3)));

        b3.addActionListener(e-> getInstantCash(b3.getText().substring(3)));

        b4.addActionListener(e-> getInstantCash(b4.getText().substring(3)));

        b5.addActionListener(e-> getInstantCash(b5.getText().substring(3)));

        b6.addActionListener(e-> getInstantCash(b6.getText().substring(3)));

        b7.addActionListener(e->System.exit(0));

        b8.addActionListener(e->new Transactions(pin));

        f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
    }


    public void getInstantCash(String amount) {
        Withdrawl obj = new Withdrawl(pin);
        obj.f.setVisible(false);
        if (obj.checkDailyLimit(amount) != "") {
            JOptionPane.showMessageDialog(f, "Daily WithDrawl Limit Exceeded Remaining amount can be withdrawn is Rs" + obj.checkDailyLimit(amount));
        } else {
            LocalDateTime ldt = LocalDateTime.now();
            String date = "";
            String year = String.valueOf(ldt.getYear());
            String d = String.valueOf(ldt.getDayOfMonth());
            String month = String.valueOf(ldt.getMonthValue());
            date = d + "-" + month + "-" + year;
            try {
                conn c = new conn();
                Statement stmt = c.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from bank where pin = '" + pin + "'");
                rs.last();
                int balance = rs.getInt(5);
                if (balance < Integer.parseInt(amount))
                    JOptionPane.showMessageDialog(f, "Insufficient Balance");
                else {
                    balance -= Integer.parseInt(amount);
                    String b = String.valueOf(balance);
                    c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "', '" + b + "');");
                    JOptionPane.showMessageDialog(f, "Rs. " + amount + " Debited Successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        f.setVisible(false);
        new Transactions(pin);
    }
}

