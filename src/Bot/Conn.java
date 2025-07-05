/*
 this code connectes all the project to database
 */
package Bot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conn {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("Your Database URL Here", // Replace with your actual database URL
                    "root", "1234");
            System.out.println("Connection ok ...!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean search(String email) throws Exception {
        ps = con.prepareStatement("select * from users where email= ? ");

        ps.setString(1, email);

        rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("in search at true");
            return true;
        }
        else {
            System.out.println("in search at false");
            return false;
        }
    }

    void insert(String uname, String email, String pass) throws Exception {
        ps = con.prepareStatement("insert into users (name, email, password) values (?, ?, ?)");

        ps.setString(1, uname);
        ps.setString(2, email);
        ps.setString(3, pass);
        ps.executeUpdate();
    }


    boolean search_Login(String email, String pass) throws Exception {
        ps = con.prepareStatement("select * from users where email= ? and password= ? ");
        ps.setString(1, email);
        ps.setString(2, pass);

        rs = ps.executeQuery();
        if (rs.next())
            return true;
        else
            return false;
    }



}