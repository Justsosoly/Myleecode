package Mytest;


import java.io.*;
import java.util.HashMap;



class BearSteadyGeneResult {

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */
	
	//统计出A,C,G,T四个字母的出现次数
	public static HashMap<Character,Integer> sumMap(String str)
	{
      HashMap<Character,Integer> sourcemap=new HashMap<Character,Integer>();
    	
    	int n=str.length();
    	sourcemap.put('A', 0);
    	sourcemap.put('C', 0);
    	sourcemap.put('G', 0);
    	sourcemap.put('T', 0);
    	
    	for(int i=0;i<n;i++)
    	{
    		char key=str.charAt(i);
    		
    		if(sourcemap.get(key)=='\0')
    		{
    			sourcemap.put(key, 1);
    		}
    		else
    		   sourcemap.put(key, sourcemap.get(key)+1);
    	}
    	return sourcemap;
	}


	
	public static boolean isSteady( HashMap<Character,Integer> map, HashMap<Character,Integer> countmap,int steady )
	{
		boolean steadyflag=false;
	    int count=4;

		for(char key: map.keySet())
		{
			int value=map.get(key);
			
			if(value<=steady) 
			{
				countmap.put(key, 1);//都小于steady，则变为1
			}
		}
		
		for(char keycount:countmap.keySet())
		{
			int valuecount=countmap.get(keycount);
			if(countmap.get(keycount)==1)
			{
				count--;
			}
			else
				return false;
		}
		
		if(count==0) //都小于等于steady，稳定
			steadyflag=true;
		else
			steadyflag=false;
		
		return steadyflag;
	}
	
	
	
    public static int steadyGene(String gene) {
    // Write your code here
    	int n=gene.length();
    	int steady=n/4;
    	HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    	map= sumMap(gene);
    	
    	int left=0;
    	int right=0;
    	int i=0,j=0;
    
    	
    	HashMap<Character,Integer> countmap=new HashMap<>();//默认为0，都不稳定,所以需要找出来处理后为1
 	
 	countmap.put('A', 0);
 	countmap.put('C', 0);
 	countmap.put('G', 0);
 	countmap.put('T', 0);

    
    	//1则为稳定
    	int min=n;
    	
    	while(j<n)
    	{
            char endChar=gene.charAt(j);  
            //向右扩展字符串
            j++;
            if(map.containsKey(endChar))//不为空，则减少一个值
            {
            	map.put(endChar, map.get(endChar)-1);
            	 
            	if(map.get(endChar)<=steady)
                 {
            		 countmap.put(endChar, 1);
                 }
            }
            if(!isSteady(map,countmap,steady))
            {
            	continue;//继续向右扩展
            }
            
            
            while(isSteady(map,countmap,steady))
            {
           	//则开始从左边收缩
            char startChar=gene.charAt(i);
            i++;
            if(map.containsKey(startChar))
            {
            	map.put(startChar, map.get(startChar)+1);
            	if(map.get(startChar)>=steady)//当前子串已经开始缺少字母了，需要向右扩展
            	{
            		countmap.put(startChar, 0);
            	}
            	
            }
            
            }//end while
            
            if((j-i)<min)
            {
            	right=j;
            	left=i;
            	min=right-left+1;
            }
           
            
    	}
    
    	   	  	
    	
        return min;
    }
    
    
    

}

public class BearSteadyGene {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = BearSteadyGeneResult.steadyGene(gene);


        bufferedReader.close();
    }
}
