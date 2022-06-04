import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PIN_CODE = "^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$",AADHAR_CARD = "^[2-9][0-9]{11}$";
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
public class test extends JFrame{
    public static void main(String[] args) {

    }
}
//insert into bank values("8286","13-1-2022","Withdraw",10000,40000);