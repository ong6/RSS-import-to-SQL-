package SQLDatabase;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import RssReader.Feed;
import RssReader.FeedMessage;
import RssReader.RSSFeedParser;

// Run this to import updated news from rsslinks SQL table.


public class InsertData {
	
	private static Timestamp ts;

	public static void main(String[] args) throws SQLException, ParseException {

		String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "4562";
            
	    String query1 = "SELECT * FROM RSSLINKSTODOWNLOAD";

	        try (Connection cc = DriverManager.getConnection(url, user, password);
	        		PreparedStatement st = cc.prepareStatement(query1);
	        		ResultSet rs = st.executeQuery()){
          
	        	while (rs.next()) {
	                String RSSLINK = rs.getString(3);
	                String author = rs.getString(1);
	                
			        RSSFeedParser parser = new RSSFeedParser(RSSLINK);
			        Feed feed = parser.readFeed();
			      
			        for (FeedMessage message : feed.getMessages()) {
			        	String message2 = message.toString();
			         	String[] message_list = message2.split("`");
			         	
			         	//System.out.println((String)Array.get(message_list, 0));  Debug line to test if code runs
			         	
			         	//Storing data in a new variable
				        String title = ((String) Array.get(message_list, 0)).trim();
				        String description = ((String) Array.get(message_list, 1)).trim();
				        String link = (String)Array.get(message_list, 2);
				        //String author = (String)Array.get(message_list, 3);
				        String guid = (String)Array.get(message_list, 4);
				        String pubdate = (String)Array.get(message_list, 5);
				        
				        //Change date format ICIS
				        boolean icisCheck =  RSSLINK.contains("icis");
				        boolean reutersCheck =  RSSLINK.contains("reuters");
				        boolean plattsCheck =  RSSLINK.contains("spglobal");
				        
				      //Change date format ICIS
				        if (icisCheck == true) {			        
				        
					        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm");
					        Date epubdate = format.parse(pubdate);
					        ts = new Timestamp(epubdate.getTime());
				        }
				      //Change date format reuters
				        else if (reutersCheck == true) {
				        	
				        	DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss X");
					        Date epubdate = format.parse(pubdate);
					        ts = new Timestamp(epubdate.getTime());
				        	
				        }
				      //Change date format platts
				        else if (plattsCheck == true) {
				        	String npubdate = pubdate.replace("T", " ");
				        	String zpubdate = npubdate.replace("Z", " UTC");
				        	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
					        Date epubdate = format.parse(zpubdate);
					        ts = new Timestamp(epubdate.getTime());
				        }
				        
				        else {
				        	ts = null;
				        }
				        
				        String query = "INSERT INTO rss(title, description, link, author, guid, pubdate, epubdate) VALUES(?, ?, ?, ?, ?, ?, ?)\n";
			
				        try (Connection c = DriverManager.getConnection(url, user, password);
				        	PreparedStatement stmt = c.prepareStatement(query)) {
			          
				        	//Input Data into respective Columns
				            stmt.setString(1, title);
				            stmt.setString(2, description);
				            stmt.setString(3, link);
				            stmt.setString(4, author);
				            stmt.setString(5, guid);
				            stmt.setString(6, pubdate);
				            stmt.setTimestamp(7, ts);
				            stmt.executeUpdate();
				            
				            
				           
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(InsertData.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
           
       					}
			        }
	        	}
	        }
	        
	     DeleteCopies.delete();
	
	}
}