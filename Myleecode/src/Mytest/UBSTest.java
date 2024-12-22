package Mytest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.*
;




class WalletException extends Exception
{
	public WalletException() throws Exception
	{
	   // super();
		//throw new Exception();
	}
}



class Weather
{
    String place;
    Double temperature;

    public Weather()
    {

    }

    public Weather(String place, Double temperature) 
    {
        this.place = place;
        this.temperature = temperature;
    }

    public Double getTemperature() 
    {
        return temperature;
    }

    public String getPlace() 
    {
        return place;
    }

    public String toString() 
    {
        return new StringBuffer(" Place : ")
                .append(this.place)
                .append(" Temperature : ")
                .append(this.temperature)
                .toString();
    }




}



//第三题
class SampleDemo implements Runnable {
	private Thread t;
	private String threadName;

	SampleDemo(String threadName) {
		this.threadName = threadName;
	}

	public void run() {
		while (true)
		{
		    try {
				Thread.sleep(1000);
				System.out.println(threadName);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
 class TestThread {
public static void main(String args[]) {
SampleDemo A = new SampleDemo( "A");
SampleDemo B = new SampleDemo( "B");
B.start();
A.start();
}
}
 
 
public class UBSTest {
	
	
	


	public static void main1(String args[])  {

		try
		{
			System.out.println("Begin :");
		 WalletException we=new WalletException();
		}
		catch(WalletException e)
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("my exception :"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main2(String args[]) 
	{
	
	List<Weather> weathers = new ArrayList<>();
	
	weathers.add(new Weather("Rainy", 17.0));
	weathers.add(new Weather("Cloudy", 23.0));
	weathers.add(new Weather("Cold", 3.0));
	weathers.add(new Weather("Sunny", 33.0));
	weathers.add(new Weather("Hot", 37.0));
	weathers.add(new Weather("Freezing", -15.0));
	weathers.add(new Weather("Windy", 13.0));
	weathers.add(new Weather("Snowy", 0.0));

	
	//由小到大 1
	weathers.stream().map(Weather::getTemperature).sorted().forEach(System.out::println);
	System.out.println();
	
	//由小到大 2  1和2是一样的结果
	weathers.stream().map(Weather::getTemperature).sorted((p1,p2)->p1.compareTo(p2)).forEach(System.out::println);
	System.out.println();
	
	//由大到小 3
	weathers.stream().map(Weather::getTemperature).sorted((p1,p2)->p2.compareTo(p1)).forEach(System.out::println);
	System.out.println();
	
	//并没有发生改变，还是按构造到时候顺序 4
	for(int i=0;i<weathers.size();i++)
		System.out.println(weathers.get(i));
	
	
	//错误语句 并没有这个用法 5 
//	weathers.stream().sorted(Weather::getTemperature).forEach(System.out::println);
	
	

	}
	
	
	
	public static void main4(String args[]){
		UBSTest tester = new UBSTest();
	        
	      // 类型声明
	      MathOperation addition = (int a, int b) -> a + b;
	        
	      // 不用类型声明
	      MathOperation subtraction = (a, b) -> a - b;
	        
	      // 大括号中的返回语句
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
	        
	      // 没有大括号及返回语句
	      MathOperation division = (int a, int b) -> a / b;
	      System.out.println(addition);
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 + 5 = " + tester.operate(10, 5,(int a, int b) -> a + b ));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	        
	      // 不用括号
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
	        
	      // 用括号
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
	        
	      greetService1.sayMessage("Runoob");
	      greetService2.sayMessage("Google");
	   }
	    
	   interface MathOperation {
	      int operation(int a, int b);
	   }
	    
	   interface GreetingService {
	      void sayMessage(String message);
	   }
	    
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	
	   interface MyTest
	   {
		   int aMethod(String s);
	   }
	
	   public static void main5(String args[]){
		//  MyTest a = a-> a.length(); //invalid  2个a变量
		   MyTest b=(String s)->1; //correct one
	//	   MyTest s= "2"-> Integer.parseInt(s);//->符号报错，“2”为常量，不为parameters
	//	   MyTest x=y ->{return y;};//int 不能转String

		   
	   }
	   
  //9.0
	   public static void main6(String args[])
		{
			
			try
			{
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
			/*
			int n=7;
			int sum  = Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
	                .limit(n)
	                .map(x -> x[0])
	                .collect(toList())
	                .stream()
	                .distinct()
	                .filter(i ->  i % 2 == 0)
	                .mapToInt(i->i).
	                sum();

			 */
			
			}
			catch (NumberFormatException e) //Line 9 
			{
			System.out.println("bad number"); // Line 11 
			}
           
		
	   
 
	
 } 

//第二题 the output is Inside BaseC::method
interface BaseI 
{ 
	void method(); 
}

class BaseC
{
   public void method()
   {
  System.out.println("Inside BaseC::method");
   }
}


 class ImplC extends BaseC implements BaseI
{
 public static void main(String []s)
   {
	// ImplC t=new ImplC();
	// t.method();
	(new ImplC()).method();
   }
 
}
}