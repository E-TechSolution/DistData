
package GetDistData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBConncection {
//    public static void main(String[] args) {
//        getConnection();
//    }
       public static Connection getConnection(){
        String userName="us3r";
        String pass="pass";
        String driverUrl=null;
        String Connurl="jdbc:derby:src/db/DistData;create=true";//E:\\db\\java\\.db
        PreparedStatement pstmt = null;
        String sqlQuey="INSERT INTO";
        try (
         Connection conn = DriverManager.getConnection(Connurl,userName,pass);
               
            ){
            
            //Class.forName(driverUrl);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println(e);
        }
           return null;
        }
}
        
//Second Commit
//third commit
