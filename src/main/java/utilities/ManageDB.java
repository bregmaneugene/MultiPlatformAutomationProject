package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {
    /*####################################################################################
         Method Name: connectToDB
         Method Description: The method opens connection to the DB
         Method Parameters: String, String, String
         Method Returns: Void
     ####################################################################################*/
   public static void connectToDB (String urlDB, String userDB, String passDB){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con= DriverManager.getConnection(urlDB, userDB, passDB);
           stmt=con.createStatement();
       } catch (Exception e) {
           System.out.println("An error occurred while connecting to DB, see details: " + e);
       }}
    /*####################################################################################
         Method Name: disconnectFromDB
         Method Description: The method closes connection to the DB
         Method Parameters: NA
         Method Returns: Void
     ####################################################################################*/
       public static void disconnectFromDB() {
           try {
               con.close();
           } catch (Exception e) {
               System.out.println("An error occurred while disconnecting from DB, see details: " + e);
           }
       }
}
