package com.automation.utility;

import org.postgresql.Driver;
import org.testng.annotations.BeforeMethod;

import java.sql.*;

public class DBConnection {

   String DATABASE_URL="jdbc:postgresql://localhost:5432/dvdrental";
   String JDBC_DRIVER = "org.postgresql.Driver";
   Connection con = null;
   Statement stmt = null;

    public DBConnection() {
        try{
            Class.forName(JDBC_DRIVER);
            con =  DriverManager.getConnection(DATABASE_URL,"postgres","Testing123");
            stmt = con.createStatement();

            String sql = "select * from customer";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally
        {
            try{
                if(!con.isClosed()){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }


   }
}
