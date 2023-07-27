package com.example.day1.users;

import java.sql.*;

public class DBConnection {
    void connectDB() {
        try (
            Connection conn = DriverManager.getConnection("");
            PreparedStatement prepStmt = conn.prepareStatement("select * from");
            ResultSet rs = prepStmt.executeQuery();
            ){

            while (rs.next()) {
                // TOTO
            }

        } catch (Exception e) {

        }
    }

    private static void releasedResources(Connection conn, PreparedStatement prepStmt, ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            prepStmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
