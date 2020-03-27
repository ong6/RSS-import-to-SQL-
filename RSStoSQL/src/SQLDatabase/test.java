package SQLDatabase;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String args[]) throws Throwable {
		String pubdate = "Tue, 28 Jan 2020 22:54:14";
		//String newPubdate = pubdate.substring(5,16).replace(' ', '-') + ' ' + pubdate.substring(16,pubdate.length());
		//System.out.println(newPubdate);
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        Date date = format.parse(pubdate);
        System.out.println(date);
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println(ts);
        
	}

}