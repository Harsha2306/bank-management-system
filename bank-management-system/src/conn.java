import java.sql.*;

public class conn {
   final String url = "jdbc:mysql://localhost:3306/bankManagementSystem";
   final String user = "root";
   final String password = "mysql_HARSHA@555";
   Connection c;
   Statement s;
   conn(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection(url,user,password);
           s = c.createStatement();
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
}
