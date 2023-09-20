package hotel.managment.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public  Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Golaniya@1");

            s =c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
