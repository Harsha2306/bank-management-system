import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class validator2{
    static final String AADHAR_NUMBER = "^[2-9][0-9]{11}$";
    static final String PAN_NUMBER = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
}

public class Signup2 extends JFrame {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    Signup2(String formno){
        this.formno = formno;
        f = new JFrame("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        String[] religionA = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religionA);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] categoryA = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(categoryA);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] incomeA = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(incomeA);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] educationA = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(educationA);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String[] occupationA = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupationA);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        f.setLayout(null);

        l12.setBounds(700,10,60,30);
        f.add(l12);

        l13.setBounds(760,10,60,30);
        f.add(l13);

        l1.setBounds(280,30,600,40);
        f.add(l1);

        l2.setBounds(100,120,100,30);
        f.add(l2);

        c1.setBounds(350,120,320,30);
        f.add(c1);

        l3.setBounds(100,170,100,30);
        f.add(l3);

        c2.setBounds(350,170,320,30);
        f.add(c2);

        l4.setBounds(100,220,100,30);
        f.add(l4);

        c3.setBounds(350,220,320,30);
        f.add(c3);

        l5.setBounds(100,270,150,30);
        f.add(l5);

        c4.setBounds(350,270,320,30);
        f.add(c4);

        l11.setBounds(100,290,150,30);
        f.add(l11);

        l6.setBounds(100,340,150,30);
        f.add(l6);

        c5.setBounds(350,340,320,30);
        f.add(c5);

        l7.setBounds(100,390,150,30);
        f.add(l7);

        t1.setBounds(350,390,320,30);
        f.add(t1);

        l8.setBounds(100,440,180,30);
        f.add(l8);

        t2.setBounds(350,440,320,30);
        f.add(t2);

        l9.setBounds(100,490,150,30);
        f.add(l9);

        r1.setBounds(350,490,100,30);
        f.add(r1);

        r2.setBounds(460,490,100,30);
        f.add(r2);

        l10.setBounds(100,540,180,30);
        f.add(l10);

        r3.setBounds(350,540,100,30);
        f.add(r3);

        r4.setBounds(460,540,100,30);
        f.add(r4);

        b.setBounds(570,640,100,30);
        f.add(b);

        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(850,750);
        f.setLocation(370,20);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        b.addActionListener(e->{
            String religion = (String)c1.getSelectedItem();
            String category = (String)c2.getSelectedItem();
            String income = (String)c3.getSelectedItem();
            String education = (String)c4.getSelectedItem();
            String occupation = (String)c5.getSelectedItem();

            String pan = t1.getText();
            String aadhar = t2.getText();

            String scitizen = "";
            if(r1.isSelected()){
                scitizen = "Yes";
            }
            else if(r2.isSelected()){
                scitizen = "No";
            }

            String eaccount = "";
            if(r3.isSelected()){
                eaccount = "Yes";
            }else if(r4.isSelected()){
                eaccount = "No";
            }
            try {
                if(religion.equals("") || category.equals("") || income.equals("") || education.equals("") || occupation.equals("") || pan.equals("") || aadhar.equals("") || scitizen.equals("") || eaccount.equals(""))
                    JOptionPane.showMessageDialog(f,"Please fill out all the fields");
                else{
                    if(!aadharNoValidator(aadhar)) {
                        JOptionPane.showMessageDialog(f, "Please Check Your Aadhar Number");
                    }
                    else if(!panNoValidator(pan))
                        JOptionPane.showMessageDialog(f,"Please Check your PAN CARD Number");
                    else {
                        /*ABCTY1234D
                        * 476155100410
                        * */
                        conn c = new conn();
                        String query = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "');";
                        c.s.executeUpdate(query);
                        f.setVisible(false);
                        new Signup3(formno);
                    }
                }
            }
            catch (Exception ae){
                ae.printStackTrace();
            }
        });
    }

    public boolean aadharNoValidator(String an){
        Pattern pattern = Pattern.compile(validator2.AADHAR_NUMBER);
        Matcher matcher = pattern.matcher(an);
        return matcher.matches();
    }

    public boolean panNoValidator(String pn){
        Pattern pattern = Pattern.compile(validator2.PAN_NUMBER);
        Matcher matcher = pattern.matcher(pn);
        return  matcher.matches();
    }
}
