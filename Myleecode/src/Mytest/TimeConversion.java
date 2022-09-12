package Mytest;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        
    // Write your code here
    	int length=s.length();
    	Integer hour=0;
    	String showhour;
    	String min;
    	String sec;
    	String sarray[]=new String[3];
    	sarray=s.split(":");
    	//for(int i=0;i<sarray.length;i++)
    	//System.out.println(sarray[i]);
    	hour=Integer.parseInt(sarray[0]);
    	if(sarray[2].contains("PM")) //下午
    			{
    		hour=hour+12;
    		if(hour==24)
    			hour=hour-12;
    		
    			}
    	else//上午的情况
    	{
    		
    		if(hour==12)
    		hour=Integer.parseInt(sarray[0])-12;
    	}
    	
    	if(hour.toString().length()<2) //hour 不足两位则补齐
    		showhour="0"+hour.toString();
    	else
    		showhour=hour.toString();
    	
    	//min=Integer.parseInt(sarray[1]);
    	min=sarray[1];
    	sec=sarray[2].substring(0,2);
    	
    	System.out.println(showhour+":"+min+":"+sec);
    	
   
     return "";

    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    //    String s = bufferedReader.readLine();
    //	 String s="07:05:45PM";
    //    String result = Result.timeConversion(s);

     //   bufferedWriter.write(result);
     //   bufferedWriter.newLine();

     //   bufferedReader.close();
      //  bufferedWriter.close();
        
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
        String myString = scanner.next();
        System.out.println("myString is: " + myString);
        String result = Result1.timeConversion(myString);
        }
        scanner.close();
        
        
    }
}
