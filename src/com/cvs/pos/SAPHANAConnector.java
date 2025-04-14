package com.cvs.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SAPHANAConnector {

//	vhcvccaddb.sap.cvshealth.com:30615
// C020570
//Srihita10!cvs95
//	vhcvccaddb.sap.cvshealth.com:4306

	
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.sap.db.jdbc.Driver";
//    static final String DB_URL = "jdbc:sap://<hostname>:<port>";
 //   static final String DB_URL = "jdbc:sap://vhcvccaddb.sap.cvshealth.com:30615";
    //static final String DB_URL = "jdbc:sap://vhcvccaddb.sap.cvshealth.com:4306";
  //  static final String DB_URL = "jdbc:sap://vhcvccaddb.sap.cvshealth.com;10.73.10.73?databaseName=CADinstanceNumber=06:";
    static final String DB_URL = "jdbc:sap://vhcvccaddb.sap.cvshealth.com:30615?databaseName=CAD?instanceNumber=06:";
    // Database credentials
    // static final String USER = "<username>";
    // static final String PASS = "<password>";
       static final String USER = "C020570";
       static final String PASS = "Srihita10!cvs95>";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
         
            //  String sql = "SELECT * FROM <schema_name>.<table_name>";
            
            String sql = "SELECT TOP 1 * from \"SAPABAP1\".\"/POSDW/TLOGF\"  where MANDT=200 "  ;
            		
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve data by column name
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                // Print the values
                System.out.print("ID: " + id);
                System.out.println(", Name: " + name);
            }
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
}