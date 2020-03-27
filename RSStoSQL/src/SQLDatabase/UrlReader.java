package SQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UrlReader {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "4562";
            
	    String query = "SELECT * FROM RSSLINKSTODOWNLOAD";

	        try (Connection c = DriverManager.getConnection(url, user, password);
	        		PreparedStatement stmt = c.prepareStatement(query);
	        		ResultSet rs = stmt.executeQuery()){
          
	        	while (rs.next()) {
	                System.out.println(rs.getString(3));
	        	}

	            //used to delete duplicates 
	            c.prepareStatement("DELETE FROM rsslinkstodownload a\r\n" + 
	            		"WHERE a.ctid <> (SELECT min(b.ctid)\r\n" + 
	            		"                 FROM   rsslinkstodownload b\r\n" + 
	            		"                 WHERE  a.link = b.link);").executeUpdate();
	            
	            
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(UrlTableInsert.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            
       		}
      	}
	
}
