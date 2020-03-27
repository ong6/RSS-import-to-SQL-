package RSSoutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtractData {
	

	public static void main(String[] args){

		String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "4562";
        
        String query = "Select * from rss";
		
        try (Connection c = DriverManager.getConnection(url, user, password);
        	PreparedStatement stmt = c.prepareStatement(query);
        		ResultSet rs = stmt.executeQuery()) {
        	
        	while(rs.next()) {
        		
        		System.out.println(rs.getString(1));
        		
        		
        	}
        	
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(ExtractData.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
           
       					}
			        }
	        	}
	        
	
	
