import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Withdrawl extends JFrame {
    JFrame f;
    JTextField t1;
    JButton b1,b2,b3;
    JLabel l1,l2;
    String pin;
    Withdrawl(String pin) {
        this.pin = pin;
        f = new JFrame("WITHDRAW");

        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setBounds(120, 70, 270, 30);
        l1.setFont(new Font("Raleway", Font.BOLD, 18));

        l2 = new JLabel("TO WITHDRAW");
        l2.setBounds(200, 110, 150, 30);
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        t1 = new JTextField();
        t1.setBounds(165, 160, 180, 35);
        b1 = new JButton("WITHDRAW");
        b1.setBounds(140, 220, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setBounds(270, 220, 100, 30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);

        b3 = new JButton("EXIT");
        b3.setBounds(200, 300, 100, 30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(520, 450);
        f.setLocation(475,150);
        f.getContentPane().setBackground(Color.WHITE);

        f.add(t1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(l1);
        f.add(l2);

        b1.addActionListener(e->{
            LocalDateTime ldt = LocalDateTime.now();
            String date ="";
            String year = String.valueOf(ldt.getYear());
            String d = String.valueOf(ldt.getDayOfMonth());
            String month = String.valueOf(ldt.getMonthValue());
            date = d+"-"+month+"-"+year;
            String amount = t1.getText();
            if(amount.equals("")) {
                JOptionPane.showMessageDialog(f, "Please enter the amount to withdraw");
            }
            else if(Integer.parseInt(amount) > 50000)
                JOptionPane.showMessageDialog(f,"Maximum withdrawl is 50,000");
            else if(checkDailyLimit(amount)!="")
                JOptionPane.showMessageDialog(f,"Daily WithDrawl Limit Exceeded Remaining amount can be withdrawn is Rs "+checkDailyLimit(amount));
            else {
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
                }
                catch (Exception ae){
                    ae.printStackTrace();
                }
            }
            f.setVisible(false);
            new Transactions(pin);
        });

        b2.addActionListener(e->{
            f.setVisible(false);
            new Transactions(pin);
        });

        b3.addActionListener(e->System.exit(0));
    }

    public String checkDailyLimit(String amount){
        LocalDateTime ldt = LocalDateTime.now();
        String date ="";
        String year = String.valueOf(ldt.getYear());
        String d = String.valueOf(ldt.getDayOfMonth());
        String month = String.valueOf(ldt.getMonthValue());
        date = d+"-"+month+"-"+year;
        int dailyLimit = 0;
        try {
            conn obj = new conn();
            Statement stmt = obj.c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bank where pin = '" + pin + "' and mode ='Withdraw' and date = '" + date + "'");
            while (rs.next()){
                dailyLimit+=rs.getInt(4);
            }
            if(dailyLimit+Integer.parseInt(amount) > 50000){
                return String.format("%,.2f", (double) 50000-dailyLimit);
        }}
        catch (Exception ae){
            ae.printStackTrace();
        }
        return "";
    }
}
