package database;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLAccess {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/";

    private static final String USER = "root";
    private static final String PASSWORD = "1234567890";

    private static final String CRT_EMPLOYEE_TBL = "CREATE TABLE Employee ("
                    + "ID SMALLINT NOT NULL,"
                    + "FirstName VARCHAR(45) NOT NULL,"
                    + "LastName VARCHAR(45) NOT NULL,"
                    + "Profile VARCHAR(45) NOT NULL,"
                    + "Salary INT(64) NOT NULL,"
                    + "PRIMARY KEY (ID))";

    private static final String CRT_ROOM_TBL = "CREATE TABLE Room ("
                    + "ID SMALLINT NOT NULL,"
                    + "#Beds INT(64) NOT NULL,"
                    + "Availability BIT NOT NULL,"
                    + "Salary INT(64) NOT NULL,"
                    + "PRIMARY KEY (ID))";


    private static Connection conn = null;
    private static Statement stm = null;
    private PreparedStatement ps = null;

    private boolean connect(final String db) {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL + db, USER, PASSWORD);
            stm = conn.createStatement();
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean disconnect() {
        try {
            conn.close();

            stm.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * creates mySQL Hotel DataBase.
     * also creates Employee and Room tables
     * SHOULD BE EXECUTED ONLY ONCE
     */
    public boolean createHotelDataBase() {
        try {
            connect("");
            stm.executeUpdate("CREATE DATABASE Hotel");
            stm.executeUpdate(CRT_EMPLOYEE_TBL);
            stm.executeUpdate(CRT_ROOM_TBL);
            disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * deletes Hotel database.
     * (for debugging)
     */
    public void dropHotelDataBase() {
        try {
            connect("Hotel");
            stm.executeUpdate("DROP DATABASE Hotel");
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

