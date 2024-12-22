package Mytest;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class PatientMedicalRecordResult {

    /*
     * Complete the 'getAverageTemperatureForUser' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/medical_records?userId=<userId>&page=<page>
     *
     * The function is expected to return a String value.
     * The function accepts a userId argumnent (Integer).
     * 
     * In the case of an empty array result, return value '0'
     */
    
    public static String getAverageTemperatureForUser(int userId)   {
      double sum=0;
      double total=1;
      
try {
		
	
URL url = new URL("https://jsonmock.hackerrank.com/api/medical_records?userId="+userId);
    //  System.out.println(url);
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
      
      long total_pages = (Long) jsonObject.get("total_pages");
       total=(long) jsonObject.get("total");
       conn.disconnect();
       
       
     for(int j=1;j<=total_pages;j++)
     {
     URL urlpage = new URL("https://jsonmock.hackerrank.com/api/medical_records?userId="+userId+"&page="+j);
     HttpURLConnection connpage = (HttpURLConnection) urlpage.openConnection();
     connpage.setRequestMethod("GET");
     connpage.setRequestProperty("Accept", "application/json");
     int responsecodepage=connpage.getResponseCode();
     
     if (responsecodepage != 200) {
         throw new RuntimeException("Failed : HTTP error code : "
             + conn.getResponseCode());
       }
     
     System.out.println(urlpage);
     String jsonpage="";
     String outputpage="";
     BufferedReader brpage = new BufferedReader(new InputStreamReader(
    	        (connpage.getInputStream())));
    	      
    	      while ((outputpage = brpage.readLine()) != null) {
    	    	  jsonpage+=outputpage;
    	        
    	      }
    	      JSONParser parsepage=new JSONParser();
    	      JSONObject jsonObjectpage =(JSONObject) parsepage.parse(jsonpage);
    	      
    JSONArray data = (JSONArray) jsonObjectpage.get("data"); 
      
	for(int i=0;i<data.size();i++)
	{
		
		
		JSONObject jsonData= (JSONObject) data.get(i);
		
		JSONObject  vitals=(JSONObject) jsonData.get("vitals");
		  
		 if(vitals.get("bodyTemperature") instanceof Double )// like 99.2
		 {
			 double temperature=(double)vitals.get("bodyTemperature");
			 System.out.println(temperature);
			 sum+=temperature;
					 
		 }
		 
		 if(vitals.get("bodyTemperature") instanceof Long )// like 100
		 {
			 Long temperature=(Long)vitals.get("bodyTemperature");
			 System.out.println(temperature);
			 sum+=temperature; 
		 }
		
	
		 
	}
	
	connpage.disconnect();
	
     }//for j
	
     
      }
      catch (MalformedURLException e) {

      e.printStackTrace();

      } catch (IOException e) {

      e.printStackTrace();

      }
      catch (ParseException e) {

      e.printStackTrace();

      }
       
       
  
      
      if(sum==0) return "0";
       
       else
       {  
    	   sum=sum/total;
    	   System.out.println(  String.format("%.1f",sum) ); 
       
           return String.format("%.1f",sum) ; 
       }    
    }

}

public class PatientMedicalRecord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int userId = Integer.parseInt(bufferedReader.readLine().trim());

        String result = PatientMedicalRecordResult.getAverageTemperatureForUser(userId);


        bufferedReader.close();
    }
}
