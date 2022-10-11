package DAO;

import MODEL.Event;
import MODEL.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Bb375451.";

    private static final String SELECT_IDUSER_SQL = "SELECT * FROM list_event.event WHERE id_user = ?";
    private static final String INSERT_EVENTSQL = "insert into list_event.event "
            + "(name,number,ave_st,ap_numb,city,state,zip_code,country,category,description,"
            + "status,tru_fal,id_user) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
    private static final String DELETE_EVENT_SQL = "DELETE from list_event.event where id = ? and id_user = ?";
    

    public static ArrayList<Event> search_eventUser(User u) {

        ArrayList<Event> event = new ArrayList();
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECT_IDUSER_SQL);

            stmt.setInt(1, u.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String number = rs.getString("number");
                String ave_st = rs.getString("ave_st");
                String ap_numb = rs.getString("ap_numb");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip_code = rs.getString("zip_code");
                String country = rs.getString("country");
                String category = rs.getString("category");
                String description = rs.getString("description");
                String status = rs.getString("status");
                boolean confirmed = rs.getBoolean("tru_fal");

                Event ev = new Event();
                ev.setId(id);
                ev.setName(name);
                ev.setNumber(number);
                ev.setAve_st(ave_st);
                ev.setAp_numb(ap_numb);
                ev.setCity(city);
                ev.setZip_code(zip_code);
                ev.setCountry(country);
                ev.setCategory(category);
                ev.setDescription(description);
                ev.setStatus(status);
                ev.setConfirmed(confirmed);
                ev.setId_user(u.getId());

                event.add(ev);

            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;

    }

    public static boolean insertEvent(Event ev) {
        boolean insert = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(INSERT_EVENTSQL);

            stmt.setString(1, ev.getName());
            stmt.setString(2, ev.getNumber());
            stmt.setString(3, ev.getAve_st());
            stmt.setString(4, ev.getAp_numb());
            stmt.setString(5, ev.getCity());
            stmt.setString(6, ev.getState());
            stmt.setString(7, ev.getZip_code());
            stmt.setString(8, ev.getCountry());
            stmt.setString(9, ev.getCategory());
            stmt.setString(10, ev.getDescription());
            stmt.setString(11, ev.getStatus());
            stmt.setBoolean(12, ev.isConfirmed());
            stmt.setInt(13, ev.getId_user());
            int rowsAffected = stmt.executeUpdate();

            insert = rowsAffected > 0;

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insert;
    }

    public static boolean deleteEvent(Event ev) {

        boolean delete = false;
        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(DELETE_EVENT_SQL);
            
            stmt.setInt(1, ev.getId());
            stmt.setInt(2, ev.getId_user());

            int rowsAffected = stmt.executeUpdate();
            delete = rowsAffected > 0;

                
            
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }
}

