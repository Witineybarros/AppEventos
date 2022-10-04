package DAO;

import MODEL.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    // CONECTION WITH DB_SQL // 

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Bb375451.";

    // COMMAND IN DB TABLES //
    private static final String INSERT_SQL = "insert into list_event.user (name,ssn,email,pswd) values(?,?,?,?)";

    private static final String SELECTSSN_SQL = "SELECT * FROM list_event.user where ssn = ?";

    private static final String SELECTALLUSER_SQL = "SELECT * FROM list_event.user";

    private static final String DELETE_SQL = "DELETE from list_event.user where ssn = ?";

    private static final String UPDATENAME_SQL = "UPDATE list_event.user Set name = ? where ssn = ?";
    private static final String UPDATEEMAIL_SQL = "UPDATE list_event.user Set email = ? where ssn = ?";
    private static final String UPDATEPSWD_SQL = "UPDATE list_event.user Set pswd = ? where ssn = ?";

    public static User searchSSN(long ssn) {
        System.out.println("========== SSN USERS ===========");
        User u = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECTSSN_SQL);
            stmt.setLong(1, ssn);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                ssn = rs.getLong("ssn");
                String email = rs.getString("email");
                String pswd = rs.getString("pswd");

                u = new User();
                u.setId(id);
                u.setName(name);
                u.setSsn(ssn);
                u.setEmail(email);
                u.setPswd(pswd);

            }

            /*System.out.println("|    Id:" + id);
            System.out.println("|    Name:" + name);
            System.out.println("|    SSN:" + ssn);
            System.out.println("|    Email:" + email);
            System.out.println("|    Password:" + pswd);
            System.out.println("*------------------------------*");
             */
            stmt.close();
            c.close();
        } catch (SQLException e) {
        }
        return u;
    }

    public static ArrayList<User> searchUser() {

        ArrayList<User> list_user = new ArrayList();

        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECTALLUSER_SQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                long ssn = rs.getLong("ssn");
                String email = rs.getString("email");
                String pswd = rs.getString("pswd");

                User u = new User();
                u.setId(id);
                u.setName(name);
                u.setSsn(ssn);
                u.setEmail(email);
                u.setPswd(pswd);

                list_user.add(u);

            }
            stmt.close();
            c.close();
        } catch (SQLException e) {
        }

        return list_user;

    }

    public static boolean newUser(User u) {

        boolean success = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);

            stmt.setString(1, u.getName());
            stmt.setLong(2, u.getSsn());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPswd());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean updateName(User u) {
        boolean success = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(UPDATENAME_SQL);

            stmt.setString(1, u.getName());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean updateEmail(User u) {
        boolean success = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(UPDATEEMAIL_SQL);

            stmt.setString(1, u.getEmail());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean updatePsdw(User u) {
        boolean success = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(UPDATEPSWD_SQL);

            stmt.setString(1, u.getPswd());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean deleteUser(User u) {

        boolean success = false;
        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
            stmt.setLong(1, u.getSsn());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {

                success = true;
            }
            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
