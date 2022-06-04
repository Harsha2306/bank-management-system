import javax.swing.*;
import java.awt.*;

public class PinChange extends JFrame {
    JFrame f;
    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;
    String pin;
    PinChange(String pin){
        this.pin = pin;
        f = new JFrame("PIN CHANGE");
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(160,60,150,35);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(100,130,150,35);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(250,130,180,30);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setBounds(100,175,180,30);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(250,175,180,30);

        b1 = new JButton("CHANGE");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(130,275,120,30);

        b2 = new JButton("BACK");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(270,275,120,30);

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(520, 450);
        f.setLocation(475,150);
        f.getContentPane().setBackground(Color.WHITE);

        b2.addActionListener(e-> {
            f.setVisible(false);
            new Transactions(pin);
        });

        b1.addActionListener(e->{
            String npin = t1.getText();
            String rpin = t2.getText();
            if(!npin.equals(rpin))
                JOptionPane.showMessageDialog(f,"Entered PIN does not match");
            else if(npin.equals("")){
                JOptionPane.showMessageDialog(f,"Enter New Pin");
            }
            else if(rpin.equals(""))
                JOptionPane.showMessageDialog(f,"Re-Enter new PIN");
            else{
                try {
                    conn c1 = new conn();
                    c1.s.executeUpdate("update login set pin = '"+rpin+"' where pin = '"+pin+"';");
                    c1.s.executeUpdate("update bank set pin = '"+rpin+"' where pin = '"+pin+"' ");
                    c1.s.executeUpdate("update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ");
                    JOptionPane.showMessageDialog(f,"PIN changed successfully");
                }
                catch (Exception ae){
                    ae.printStackTrace();
                }
            }
            f.setVisible(false);
            System.exit(0);
        });

        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(l3);
        f.add(t2);
        f.add(b1);
        f.add(b2);
    }
}


