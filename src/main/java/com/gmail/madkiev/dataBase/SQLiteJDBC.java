package com.gmail.madkiev.dataBase;

import java.sql.*;
public class SQLiteJDBC {

    /**
     * Connect to the blog.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/blog.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the blog table
     */
    public void selectAll(){
        String sql = "SELECT id, name, message FROM blog";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("message"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}