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



class ConferenceScheduleResult {

    /*
     * Complete the 'maxPresentations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY scheduleStart
     *  2. INTEGER_ARRAY scheduleEnd
     */

	
    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
    // Write your code here
        int result=1;
        int n=scheduleStart.size();
      
        List<Meeting> meeting =new ArrayList<Meeting>(); 
          
          for(int j=0;j<n;j++)
          {
        	  Meeting tempmeet=new Meeting();
        	  
        	  tempmeet.start=scheduleStart.get(j);
        	  tempmeet.end=scheduleEnd.get(j);
        	  meeting.add(tempmeet);
          }
          
           EndSorter es = new EndSorter(); 
      	   Collections.sort(meeting, es);
      	   
           int start=meeting.get(0).start;
           int end =meeting.get(0).end;
      	
      	 for(int i = 1; i < meeting.size(); i++)
     	{
      		start=meeting.get(i).start ;
      		if (start>= end)
     		{
     			end = meeting.get(i).end;
     			result++;
     		}
     	}
        
        return result;

    }

	

}

class EndSorter implements Comparator<Meeting>
{
	@Override
	//Sorting meetings based on finish timings
	public int compare(Meeting o1, Meeting o2) 
	{
		if (o1.end < o2.end)
			return -1;
		
		else if (o1.end > o2.end)
		 	return 1;
			
		return 0;
	}
}

class Meeting
{
	
	int start;
	int end;
	
	public void Meeting(int start,int end)
	{
		this.start=start;
		this.end=end;
	}


}


public class ConferenceSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int scheduleStartCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scheduleStart = IntStream.range(0, scheduleStartCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int scheduleEndCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scheduleEnd = IntStream.range(0, scheduleEndCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = ConferenceScheduleResult.maxPresentations(scheduleStart, scheduleEnd);


        bufferedReader.close();
    }
}
