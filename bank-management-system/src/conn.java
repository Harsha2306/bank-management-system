import java.sql.*;

/*
1)Register the Driver class
2)Create connection
3)Create statement
4)Execute queries
5)Close connection
*/

public class conn {
   final String url = "jdbc:mysql://localhost:3306/bankManagementSystem";//where jdbc is the API, mysql is the database, localhost is the server name on which mysql is running, we may also use IP address, 3306 is the port number and bankManagementSystem is the database name.
   final String user = "root";
   final String password = "mysql_HARSHA@555";
   Connection c;
   Statement s;
   conn(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection(url,user,password);//The getConnection() method of DriverManager class is used to establish connection with the database
           s = c.createStatement();//The createStatement() method of Connection interface is used to create statement
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
}
