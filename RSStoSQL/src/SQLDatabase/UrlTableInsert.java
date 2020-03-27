package SQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UrlTableInsert {
	
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "4562";
            
	        String query = "INSERT INTO rsslinkstodownload(ID, Name, link) VALUES(?, ?, ?)\n";

	        try (Connection c = DriverManager.getConnection(url, user, password);
	        	PreparedStatement stmt = c.prepareStatement(query)) {
          
	        	//insert statements here to update links into URL table
	        	
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Top News Feed','http://feeds.reuters.com/reuters/topNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','World News Feed','http://feeds.reuters.com/Reuters/worldNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Business News Feed','http://feeds.reuters.com/reuters/businessNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Technology News Feed','http://feeds.reuters.com/reuters/technologyNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Domestic News Feed (US)','http://feeds.reuters.com/Reuters/domesticNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Sports News Feed','http://feeds.reuters.com/reuters/sportsNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Politics News Feed','http://feeds.reuters.com/reuters/politicsNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','US Video Top News Feed','http://feeds.reuters.com/reuters/USVideoTopNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','US Video World News Feed','http://feeds.reuters.com/reuters/USVideoWorldNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Health News Feed','http://feeds.reuters.com/reuters/healthNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Environment Feed','http://feeds.reuters.com/reuters/environment');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','US Legal Feed','http://feeds.reuters.com/reuters/USLegal');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Wealth  Feed','http://feeds.reuters.com/news/wealth');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Entertainment Feed','http://feeds.reuters.com/reuters/entertainment');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Lifestyle Feed','http://feeds.reuters.com/reuters/Lifestyle');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Science News Feed','http://feeds.reuters.com/reuters/scienceNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Reuters Pictures Feed','http://feeds.reuters.com/ReutersPictures');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','US Video Feed','http://feeds.reuters.com/reuters/USVideoBreakingviews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Oddly Enough News Feed','http://feeds.reuters.com/reuters/oddlyEnoughNews');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Reuters','Arts Culture Feed','http://feeds.reuters.com/news/artsculture');").executeUpdate();


	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','Latest Chemical Headlines','https://www.icis.com/rss/publicrss/?redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','Latest Energy headlines','https://www.icis.com/rss/publicrss/?source=heren&redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','Europe Chemicals','https://www.icis.com/rss/publicrss/?region=europe&redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','Asia Chemicals','https://www.icis.com/rss/publicrss/?region=asia&redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','America Chemicals','https://www.icis.com/rss/publicrss/?region=americas&redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','Middle East / Africa Chemicals','https://www.icis.com/rss/publicrss/?region=africa%20/%20middle%20east&redirect=english');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('ICIS News','ICIS Chemical Business articles','https://www.icis.com/rss/publicrss/?source=ecn&redirect=english');").executeUpdate();


	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Oil Headlines','https://www.spglobal.com/platts/en/rss-feed/oil');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Electric Power Headlines','https://www.spglobal.com/platts/en/rss-feed/electric-power');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Natural Gas Headlines','https://www.spglobal.com/platts/en/rss-feed/natural-gas');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Coal Headlines','https://www.spglobal.com/platts/en/rss-feed/coal');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Petrochemical Headlines','https://www.spglobal.com/platts/en/rss-feed/petrochemicals');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Metals Headlines','https://www.spglobal.com/platts/en/rss-feed/metals');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Shipping Headlines','https://www.spglobal.com/platts/en/rss-feed/shipping');").executeUpdate();
	        	c.prepareStatement("INSERT INTO RSSLINKSTODOWNLOAD (SOURCE,NAME,LINK) VALUES ('Platts','Latest Agriculture Headlines','https://www.spglobal.com/platts/en/rss-feed/agriculture');").executeUpdate();

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