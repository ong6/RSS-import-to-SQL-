package SQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Createtable {
   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      String url = "jdbc:postgresql://localhost:5432/students";
      String user = "postgres";
      String password = "4562";
      
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection(url, user, password);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         
         String sql = "CREATE TABLE RSS " +
            "(TITLE          TEXT    NOT NULL, " +
            " DESCRIPTION    TEXT    NOT NULL, " +
            " LINK           TEXT    NOT NULL, " +
            " AUTHOR         TEXT, " +
            " GUID         	 TEXT	 NOT NULL, " +
            " PUBDATE        TEXT)";
         
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}