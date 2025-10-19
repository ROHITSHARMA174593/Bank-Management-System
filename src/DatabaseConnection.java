import java.sql.*;

public class DatabaseConnection{
    // Here No need of Main Method

    Connection conn;

    //it used in Other files where we execute the Query
    Statement st;
    public DatabaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL driver load karein
            conn = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root", "10134369");
            st = conn.createStatement();
        } catch(Exception err){
            System.out.println(err);
        }
    }

}

// Steps:
// todo :: 1: Create Connection
// todo :: 2: Create Connection
// todo :: 3: Statement Connection


// todo ::::::      Control + Alt + Shift + S :: to we add library in external libraries folder because in intellij idea there is no any option to import anything