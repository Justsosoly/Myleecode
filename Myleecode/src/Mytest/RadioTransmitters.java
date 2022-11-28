package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class RadioTransmittersResult {

	/*
	 * Complete the 'hackerlandRadioTransmitters' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY x 2. INTEGER k
	 */

	public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
		// Write your code here
		int transmitters = 0;
	    int n=x.size();
		int currentradiobase ;
		int nextrange ;
		Collections.sort(x);
		int radio[] = new int[x.size()];
		int i=0;
		while(i<n)//开始寻找无线电站的位置，先找无线电站左边的覆盖范围，再找无线电右边的覆盖范围
		{
		
			currentradiobase= x.get(i) + k;//往右建设一个发射器，往左发射无线电最远可以到达当前这栋房子
			while(i<n&&x.get(i)<=currentradiobase) //找到可以到达最左边房子的发射器位置
			{
			 i++;	//往右找房子，一直到超出覆盖范围后再往左回到上一个房子的位置
			}
			transmitters++;//放置一个发射器
			radio[i-1]=1;//有发射器的房子标志为1
			
			nextrange=x.get(i-1)+k;//现在建好的发射器往右最远可以到达的位置

			while(i<n&&x.get(i)<=nextrange)//一直到发射器不能覆盖的房子位置，则进入下个发射器的建设或者结束
			{
			 i++;	
			}
			
		}
		
		return transmitters;
	}
		
/*
		
			if(Collections.max(x)<=2)
		{
			transmitters=1;
			return transmitters;
		}
		
		
		
		for (int i = 1; i < x.size(); i++) {
			int house = x.get(i);
			if (nextradiobase <=house)//
			{
				if ((house - (currentrange+1)) <= k) // can cover the house（i）
				{
					radio[i] = 1;
					transmitters++;
					currentrange = house + k;
					nextradiobase = currentrange + k;
				}
				else	
				{
					radio[i-1] = 1;
					transmitters++;
					currentrange = x.get(i-1) + k;
					nextradiobase = currentrange + k;
				}

			} else // jump out the range nextradiobase >= house
			{
				if(house>currentrange&&house<nextradiobase)
				{
					radio[i] = 1;
					transmitters++;
					currentrange = house + k;
					nextradiobase = currentrange + k;
					continue;
				}	
				continue;
			}

		}
*/

	

}

public class RadioTransmitters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = RadioTransmittersResult.hackerlandRadioTransmitters(x, k);


        bufferedReader.close();
    }
}
