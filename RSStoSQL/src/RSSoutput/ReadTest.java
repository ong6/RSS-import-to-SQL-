package RSSoutput;

import java.lang.reflect.Array;
import java.util.Arrays;

import RssReader.Feed;
import RssReader.FeedMessage;
import RssReader.RSSFeedParser;

public class ReadTest {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser(
                "http://feeds.reuters.com/reuters/topNews");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        
       for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);
            String message2 = message.toString();
            String message_list[] = message2.split("`");
            //System.out.println(Arrays.toString(message_list)); this is the array list        
            
            System.out.println(Arrays.asList(message_list).get(1));
            
            System.out.println(Array.get(message_list, 5));
       }
    }


    
    
}