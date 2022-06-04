import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class validator{
    static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    static final String PIN_CODE = "^[1-9][0-9]{2}\\s?[0-9]{3}$";
    static final String TEXT = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
}

public class Signup1 extends JFrame {
    JFrame f = new JFrame("NEW ACCOUNT APPLICATION FORM");
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    JDayChooser dayChooser;
    JMonthChooser monthChooser;
    JYearChooser yearChooser;
    int lastThree = new Random().nextInt(100,1000);
    Signup1(){
        l1 = new JLabel("APPLICATION FORM NO. "+lastThree);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setBounds(140,20,600,40);
        f.add(l1);

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(290,80,600,30);
        f.add(l2);

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100,140,100,30);
        f.add(l3);

        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100,190,200,30);
        f.add(l4);

        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100,240,200,30);
        f.add(l5);

        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100,290,200,30);
        f.add(l6);

        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100,340,200,30);
        f.add(l7);

        l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100,390,200,30);
        f.add(l8);

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100,440,200,30);
        f.add(l9);

        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100,490,200,30);
        f.add(l10);

        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.setBounds(100,540,200,30);
        f.add(l11);

        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        l12.setBounds(100,590,200,30);
        f.add(l12);

        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));

        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));

        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300,140,400,30);
        f.add(t1);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300,190,400,30);
        f.add(t2);

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        t3.setBounds(300,340,400,30);
        f.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        t4.setBounds(300,440,400,30);
        f.add(t4);

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        t5.setBounds(300,490,400,30);
        f.add(t5);

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t6.setBounds(300,540,400,30);
        f.add(t6);

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        t7.setBounds(300,590,400,30);
        f.add(t7);

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(620,660,80,30);
        f.add(b);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(470,290,60,30);
        f.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(550,290,90,30);
        f.add(r2);

        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(r1);
        groupGender.add(r2);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300,390,100,30);
        f.add(r3);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,390,100,30);
        f.add(r4);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        r5.setBounds(635,390,100,30);
        f.add(r5);

        ButtonGroup groupStatus = new ButtonGroup();
        groupStatus.add(r3);
        groupStatus.add(r4);
        groupStatus.add(r5);

        dayChooser = new JDayChooser();
        monthChooser = new JMonthChooser();
        yearChooser = new JYearChooser();
        yearChooser.setEndYear(2003);
        yearChooser.setValue(2003);
        dayChooser.setBounds(250,230,200,90);
        monthChooser.setBounds(470, 240, 200, 20);
        yearChooser.setBounds(600,240,100,20);
        f.add(monthChooser);
        f.add(yearChooser);
        f.add(dayChooser);

        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(850,800);
        f.setLocation(370,20);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        b.addActionListener(e->{
            String formno = String.valueOf(lastThree);
            String name = t1.getText();
            String fname = t2.getText();
            String date = String.valueOf(dayChooser.getDay());
            String month = String.valueOf(monthChooser.getMonth()+1);
            String year = String.valueOf(yearChooser.getYear());
            String dob = year+"-"+month+"-"+date;
            String gender = null;
            if(r1.isSelected()){
                gender = "male";
            }
            else if(r2.isSelected()){
                gender = "female";
            }
            String email = t3.getText();
            String marital = null;
            if(r3.isSelected()){
                marital = "Married";
            }else if(r4.isSelected()){
                marital = "Unmarried";
            }else if(r5.isSelected()){
                marital = "Other";
            }
            String address = t4.getText();
            String city = t5.getText();
            String pincode = t6.getText();
            String state = t7.getText();
            try {
                if(formno.equals("") || name.equals("") || fname.equals("") || date.equals("") || month.equals("") || year.equals("") || gender==null || email.equals("") || marital == null || address.equals("") || city.equals("") || pincode.equals("") || state.equals(""))
                {
                    JOptionPane.showMessageDialog(f,"Please fill out all the fields");
                }
                else {
                    if(!validateEmail(email)) {
                        JOptionPane.showMessageDialog(f,"Please check your Email");
                    }
                    else if(!validateText(name)){
                        JOptionPane.showMessageDialog(f,"Please check your Name");
                    }
                    else if(!validateText(fname)){
                        JOptionPane.showMessageDialog(f,"Please check your Father's Name");
                    }
                    else if(!validateText(city)){
                        JOptionPane.showMessageDialog(f,"Please check your City");
                    }
                    else if(!validateText(state)){
                        JOptionPane.showMessageDialog(f,"Please check your State");
                    }
                    else if(!validatePincode(pincode)){
                        JOptionPane.showMessageDialog(f,"Please check your Pin Code");
                    }
                    else {
                        conn obj = new conn();
                        String query = "insert into signup1 values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                        obj.s.executeUpdate(query);
                        f.setVisible(false);
                        new Signup2(formno);
                    }
                }
            }
            catch (Exception ae){
                ae.printStackTrace();
            }
        });
    }

    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(validator.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePincode(String pincode){
        Pattern pattern = Pattern.compile(validator.PIN_CODE);
        Matcher matcher = pattern.matcher(pincode);
        return  matcher.matches();
    }

    public boolean validateText(String text){
        Pattern pattern = Pattern.compile(validator.TEXT);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
