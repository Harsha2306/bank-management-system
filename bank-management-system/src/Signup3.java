import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Signup3 extends JFrame {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        f= new JFrame("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        f.add(l1);

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,140,200,30);
        f.add(l2);

        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,300,200,30);
        f.add(l3);

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330,300,250,30);
        f.add(l4);

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100,330,200,20);
        f.add(l5);

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330,330,500,20);
        f.add(l6);

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,370,200,30);
        f.add(l7);

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330,370,200,30);
        f.add(l8);

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(100,400,200,20);
        f.add(l9);

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,430,200,30);
        f.add(l10);

        l11 = new JLabel("Form No:"+formno);
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(670,10,150,30);
        f.add(l11);

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770,10,40,30);
        f.add(l12);

        b1 = new JButton("Submit");
        b1.setBounds(250,650,100,30);
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");
        b2.setBounds(460,650,100,30);
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBounds(100,180,150,30);
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBounds(350,180,300,30);
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,220,250,30);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,220,250,30);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,600,20);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));

        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(810,750);
        f.setLocation(370,20);
        f.getContentPane().setBackground(Color.WHITE);
        f.add(b1);
        f.add(b2);
        f.add(r1);
        f.add(r2);
        f.add(r3);
        f.add(r4);
        f.add(c1);
        f.add(c2);
        f.add(c3);
        f.add(c4);
        f.add(c5);
        f.add(c6);
        f.add(c7);

        b1.addActionListener(e->{
            String atype = null;
            if(r1.isSelected())
                atype = "Saving Account";
            else if(r2.isSelected())
                atype = "Fixed Deposit Account";
            else if (r3.isSelected())
                atype = "Current Account";
            else if(r4.isSelected())
                atype = "Recurring Deposit Account";

            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){
                facility = facility + " EMAIL Alerts";
            }
            if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(c6.isSelected()){
                facility = facility + " E-Statement";
            }

            try {
                if(atype.equals("") || facility.equals(""))
                    JOptionPane.showMessageDialog(f,"Fill all the required fields");
                else {
                    conn c1 = new conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(f,"Card Number: " + cardno + "\n Pin:"+ pin);
                    f.setVisible(false);
                    new Deposit(pin);
                }
            }
            catch (Exception ae){
                ae.printStackTrace();
            }
        });

        b2.addActionListener(e->System.exit(0));
    }
}
