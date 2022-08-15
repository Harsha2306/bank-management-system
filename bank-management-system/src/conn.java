import java.sql.*;
/*
1)Register the Driver class
2)Create connection
3)Create statement
4)Execute queries
5)Close connection
*/

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
