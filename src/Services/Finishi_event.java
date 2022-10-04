package Services;

import MODEL.Event;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Finishi_event {

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Bb375451.";
    private static final String UPDATE_FINISH_SQL = "UPDATE list_event.event Set status = ?, tru_fal = ? where id = ? and id_user = ?";

    public static boolean confirmed(Event ev) {

         boolean insert = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(UPDATE_FINISH_SQL);

           
           stmt.setString(1, ev.getStatus());
            stmt.setBoolean(2, true);
            stmt.setInt(3, ev.getId());
            stmt.setInt(4, ev.getId_user());
            
            int rowsAffected = stmt.executeUpdate();

            insert = rowsAffected > 0;

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public static boolean unConfirmed(Event ev) {

        boolean insert = true;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(UPDATE_FINISH_SQL);

            stmt.setString(1, ev.getStatus());
            stmt.setBoolean(2, false);
            stmt.setInt(3, ev.getId());
            stmt.setInt(4, ev.getId_user());

            int rowsAffected = stmt.executeUpdate();

            insert = rowsAffected > 0;

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }
}
