package Mytest;


import java.io.*;
import java.math.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class IPTrackerResult {

/*
* Complete the 'ipTracker' function below.
*
* URL for cut and paste
* https://jsonmock.hackerrank.com/api/ip?ip=<ip>
*
* The function is expected to return a STRING.
* The function accepts a singe parameter ip.
*
* In case of no ip record, return string 'No Result Found'
*/
//ip=172.217.20.46
public static String ipTracker(String ip) throws ParseException {
	String country="";
	 try {

			URL url = new URL("https://jsonmock.hackerrank.com/api/ip?ip="+ip);
		
			 System.out.println(url);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			int responsecode=conn.getResponseCode();
			 
			String output="";
			String json="";
			if (responsecode != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			
			while ((output = br.readLine()) != null) {
				json+=output;
				
			}
			System.out.println(json);
			
			JSONParser parse=new JSONParser();
			JSONObject jsonObject =(JSONObject) parse.parse(json);
			long total = (Long) jsonObject.get("total");
			
			JSONArray data = (JSONArray) jsonObject.get("data"); 
			Iterator it=data.iterator();
		     while(it.hasNext())
		     {
		    	Map datamap=(HashMap) it.next();
		         for(Object key:datamap.keySet())
		         {
		        	 String data_key=(String)key;
		        	 String data_value=(String)datamap.get(key);
		        	 if(data_key.equals("country"))
		        	 {
		        		 country=data_value;
		        	 }
		         }
		     }
            
		//	System.out.println(country);
			
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

	
	if(country=="")
		return "No Result Found";
	else
	
    return country;
}

}

public class IPTracker {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

String ip = bufferedReader.readLine();

try {
	String result = IPTrackerResult.ipTracker(ip);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

bufferedReader.close();
}
}
