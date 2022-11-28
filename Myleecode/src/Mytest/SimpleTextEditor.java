package Mytest;
import java.io.*;
import java.util.*;

public class SimpleTextEditor {
	
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		//Scanner scanner=new Scanner(System.in);
		//int n=scanner.nextInt();
		BufferedReader buffred=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt( buffred.readLine().trim());
		
		List<List<String>> list=new ArrayList<List <String>>();
		while (n>0)
		{
			String opertion;
			String value;
			List<String> input =new ArrayList<String>();
			opertion=buffred.readLine();
			if(!opertion.equals("4"))
			{
				input.add(String.valueOf(opertion.charAt(0)));
				value=opertion.substring(2,opertion.length());
				input.add(value);
			}
			else
			{
				input.add(opertion);
			}
			list.add(input);
			n--;
		}
	
		simpleText(list);
		buffred.close();
		
	}
	
	public static String simpleText(List<List<String>> list) throws IOException
	{
		String str="";
		Deque<String> deque=new LinkedList<String>();
		String delstr;
	//	 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		for(int i=0;i<list.size();i++)
		{
		  
			 List<String> inputlist=list.get(i);
			 int op=Integer.parseInt(inputlist.get(0));
			 int index;
			 String value;
				
				switch (op)
				{
					case 1:
						value=inputlist.get(1);
						str+=value;
						deque.push(str);
						break;
					case 2:
						value=inputlist.get(1);
						index=Integer.parseInt(value);
						delstr=str.substring(str.length()-index,str.length());
						str=str.substring(0, str.length()-index);
						deque.push(str);
						break;
					case 3:
						 value=inputlist.get(1);
						 index=Integer.parseInt(value);
					     System.out.println(str.charAt(index-1));
						// bufferedWriter.write(str.charAt(index-1));
						 break;
					case 4:
						  deque.pop();
						  str=deque.peek();
						break;
				}
			
		}//end for i
	//	bufferedWriter.close();
		return str;
	}
	

}
