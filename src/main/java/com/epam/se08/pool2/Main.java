package com.epam.se08.pool2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        ConnectionPool pool;
        Connection con;
        Statement st = null;
        ResultSet rs = null;
        try {
            pool = ConnectionPool.getInstance();
            pool.setDriverClassName("org.gjt.mm.mysql.Driver");
            pool.setUrl("jdbc:mysql://127.0.0.1/test");
            pool.setUsername("root");
            pool.setPassword("123456");
            pool.setConnectionNumber(5);
            pool.initConnections();
            con = pool.getConnection();

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
            con.close();
            pool.closeConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
