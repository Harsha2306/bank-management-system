import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class getBalance {
    getBalance(String pin){
        try {
            conn c1 = new conn();
            Statement stmt = c1.c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from bank where pin = '"+pin+"'");
            rs.last();
            int balance = rs.getInt(5);
            String b = String.format("%,.2f", (double) balance);
            JOptionPane.showMessageDialog(null,"Your Current Account Balance is Rs"+b);
            new Transactions(pin);
        }
        catch (Exception ae){
            ae.printStackTrace();
        }
    }
}
