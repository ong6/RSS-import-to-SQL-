package SQLDatabase;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import RssReader.FeedMessage;
import RssReader.RSSFeedParser;
import RssReader.Feed;


// test if website is a rss website

public class InsertOneData {
	
	public static void main(String[] args){

		String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "4562";
            
	          	
	        RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/reuters/topNews");
	        Feed feed = parser.readFeed();
	      
	        for (FeedMessage message : feed.getMessages()) {
	        	String message2 = message.toString();
	         	String[] message_list = message2.split("=");
	         	
	         	//System.out.println((String)Array.get(message_list, 0));  Debug line to test if code runs
	         	
	         	//Storing data in a new variable
		        String title = (String)Array.get(message_list, 0);
		        String description = (String)Array.get(message_list, 1);
		        String link = (String)Array.get(message_list, 2);
		        String author = (String)Array.get(message_list, 3);
		        String guid = (String)Array.get(message_list, 4);
		        String pubdate = (String)Array.get(message_list, 5);
		        
		        String query = "INSERT INTO rss(title, description, link, author, guid, pubdate) VALUES(?, ?, ?, ?, ?, ?)\n";
	
		        try (Connection c = DriverManager.getConnection(url, user, password);
		        	PreparedStatement stmt = c.prepareStatement(query)) {
	          
		        	//Input Data into respective Columns
		            stmt.setString(1, title);
		            stmt.setString(2, description);
		            stmt.setString(3, link);
		            stmt.setString(4, author);
		            stmt.setString(5, guid);
		            stmt.setString(6, pubdate);
		            stmt.executeUpdate();
		            
		            
		            //used to delete duplicates 
		            c.prepareStatement("DELETE FROM rss a\r\n" + 
		            		"WHERE a.ctid <> (SELECT min(b.ctid)\r\n" + 
		            		"                 FROM   rss b\r\n" + 
		            		"                 WHERE  a.link = b.link);").executeUpdate();
	        
} catch (SQLException ex) {

    Logger lgr = Logger.getLogger(InsertOneData.class.getName());
    lgr.log(Level.SEVERE, ex.getMessage(), ex);
   
				}
	        }
    	}
	   
	
}