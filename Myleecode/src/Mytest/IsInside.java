package Mytest;

public class IsInside {
	
	
	public static void main(String args[])
	
	
	{
		int x1=0,y1=0;
		int x2=10,y2=30;
		int x3=20,y3=0;
		int x=10,y=15;
		//int x=30,y=15;
		
		isBelong(x1,y1,x2,y2,x3,y3,x,y);
		
	}
	
	public static String isBelong(int x1,int y1,int x2,int y2,int x3,int y3,int x,int y  )
	{
		
		double A=area(x1,y1,x2,y2,x3,y3);
		double A1=area(x1,y1,x2,y2,x,y);
		double A2=area(x2,y2,x3,y3,x,y);
		double A3=area(x1,y1,x3,y3,x,y);
	
		if(A==A1+A2+A3)
		return "inside";
		else
		return "outside";
	}
	
	public static double  area(int x1,int y1,int x2,int y2,int x3,int y3)
	{
		
		double square=0;
		
		
		square=Math.abs(( x1*(y2-y3)
				+x2*(y3-y1)
				+x3*(y1-y2)
			   )/2);
		
		return square;
		
	}
	
	
}
