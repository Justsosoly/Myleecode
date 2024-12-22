package Mytest;

import java.io.*;
import java.util.*;
import java.util.stream.*;



public class CityBlindingLights {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] roadNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int roadNodes = Integer.parseInt(roadNodesEdges[0]);
        int roadEdges = Integer.parseInt(roadNodesEdges[1]);

        List<Integer> roadFrom = new ArrayList<>();
        List<Integer> roadTo = new ArrayList<>();
        List<Integer> roadWeight = new ArrayList<>();

        IntStream.range(0, roadEdges).forEach(i -> {
            try {
                String[] roadFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                roadFrom.add(Integer.parseInt(roadFromToWeight[0]));
                roadTo.add(Integer.parseInt(roadFromToWeight[1]));
                roadWeight.add(Integer.parseInt(roadFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int x = Integer.parseInt(firstMultipleInput[0]);

                int y = Integer.parseInt(firstMultipleInput[1]);
          
               int result=CityBlindingLightsSolution(x,y,roadNodes,roadFrom,roadTo,roadWeight);
            
            System.out.println(result);
            
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        

        bufferedReader.close();
    }
    
    
    //时间复杂度没有通过测试
    
    public static int CityBlindingLightsSolution(int x,int y,int n,List<Integer> roadFrom, List<Integer> roadTo, List<Integer> roadWeight)
    {
    	int result=0;
    	int shortest=0;
    	List<Integer> visited=new ArrayList<Integer>();
    	visited.add(x);
    	
    	
    	List<List<Integer>> nodedge=new ArrayList<List<Integer>>();
    	
    	int rematrix[][]=new int[n][n];
    
    	
    	
    	
    	PriorityQueue<List<Integer>> que=new PriorityQueue<>((a,b)->a.get(2)-b.get(2));
    	
    	for (int p=0;p<roadWeight.size();p++)
    	{
    		List<Integer> temp=new ArrayList<Integer>();
    		int u=roadFrom.get(p);
    		int v=roadTo.get(p);
    		int weight=roadWeight.get(p);
    		temp.add(u);
    		temp.add(v);
    		temp.add(weight);
    		nodedge.add(temp);
    		rematrix[u][v]=weight;
    		if(u==x&&v==y) result=weight;
    	
    	}
    	
    	que.addAll(nodedge);
    
    	PriorityQueue<List<Integer>> quebackup=new PriorityQueue<>((a,b)->a.get(2)-b.get(2));
    	
    	
    	
    	while(!(visited.contains(x)&&visited.contains(y)))
    	{
    		
    		List<Integer> temp=new ArrayList<Integer>();
    		
    		
    		
    		while(!que.isEmpty())
    		{
    			temp=que.poll();
    			
    			int u=temp.get(0);
    			int v=temp.get(1);
    			int weight=temp.get(2);
    			
    			
    			
    			if(visited.contains(u))
    			{
    				visited.add(v);
    				shortest+=weight;
    				
    				break;
    			}
    			

    			else
    			{
    				quebackup.add(temp);
    				
    			}
    			
    			
    		}//end while que
    		
    		if(que.isEmpty()) return -1;
    		
    		que.addAll(quebackup);
    		quebackup.clear();
    		
    	}//end while find the way
    	
    	if(result!=0)
    		shortest=Math.min(result, shortest);
    	
    	return shortest;
    }
    
    
}
