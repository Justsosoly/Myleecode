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



class ComponentGraphResult {

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here
  
    	int n=gb.size();
    	Map<Integer,Set> nodemap=new HashMap<Integer,Set> ();
    	
    	List<Integer> number=new ArrayList<Integer>();
    	List<Integer> resultnumber=new ArrayList<Integer>();
    
    	//change the gb from list-list to map(key,(value,value……))
    	for(int i=0;i<n;i++)
    	{
    		int u=gb.get(i).get(0);
    		int v=gb.get(i).get(1);
    		Set tempforu=new HashSet();
    		Set tempforv=new HashSet();
    		tempforu.add(v);
    		tempforv.add(u);
    		
    		if(nodemap.get(u)!=null)
    		{
    			nodemap.get(u).addAll(tempforu);//map里已经有了，把这个端点增加进去
    		}
    		else
    			{
    			nodemap.put(u, tempforu);//第一次放进map里
    			}
    		if(nodemap.get(v)!=null)
    		{
    			nodemap.get(v).addAll(tempforv);
    		}
    		else
    		{
    			nodemap.put(v, tempforv);
    		}
    		
    		
    	}
   
    	//开始处理nodemap
    	 while(nodemap.size()>0)
      {
    		
    	 int u= nodemap.entrySet().iterator().next().getKey();
    	 Set v= nodemap.entrySet().iterator().next().getValue();
    	 
    	 Set<Integer> result=new HashSet<Integer>();//put the u node in the result
    	  LinkedList<Integer> templist=new LinkedList<Integer>();//put the v node 
    	  
    	  nodemap.remove(u); //delete for loop 
    	  result.add(u);//add the map key element u
    	  templist.addAll(v);
    	  
    	  while(!templist.isEmpty())
    	  {
    		 int tempvalue=templist.getFirst();//get the map value element
    		
    		 templist.removeFirst();
    		 if(nodemap.containsKey(tempvalue)&&!result.contains(tempvalue))//已经有这个端点了，则不进入
    		 {
    			 templist.addAll(nodemap.get(tempvalue));//
    			 result.add(tempvalue);// add the map value element
    			 nodemap.remove(tempvalue);//除掉map里的边，可以防止重复判断
    		 }
    		 else
    			continue;
    		 
    	  }
    	  number.add(result.size());
    
      
      }
    	 resultnumber.add( Collections.min(number));
    	 resultnumber.add( Collections.max(number));
    	return resultnumber ;

    }
    
    
    
    
    public static List<Integer> componentsInGraph2(List<List<Integer>> comp)
    {
            List<Integer> li = new LinkedList<>();
            li.add(Integer.MAX_VALUE);
            li.add(Integer.MIN_VALUE);
            Map<Integer,Set<Integer>> map = new HashMap<>();
            for(List<Integer> q : comp)
            {
                Set<Integer> set0 = map.getOrDefault(q.get(0),new HashSet<>());
                set0.add(q.get(1));
                map.put(q.get(0),set0);
                Set<Integer> set1 = map.getOrDefault(q.get(1),new HashSet<>());
                set1.add(q.get(0));
                map.put(q.get(1),set1);
            }
            while(map.size()>0)
            {
                Set<Integer> dis = new HashSet<>();
                LinkedList<Integer> bfs = new LinkedList<>();
                Map.Entry<Integer,Set<Integer>> ent = map.entrySet().iterator().next();
                map.remove(ent.getKey());//进入的第一个手工删除掉
                dis.add(ent.getKey());
                bfs.addAll(ent.getValue());
                while(bfs.size()>0)
                {
                    int pop=bfs.removeFirst();
                    if(map.containsKey(pop))
                    {
                        dis.add(pop);
                        bfs.addAll(map.get(pop));
                        map.remove(pop);//目标端点作为map的key删除掉
                    }
                }
                li.set(0,Integer.min(li.get(0),dis.size()));
                li.set(1,Integer.max(li.get(1),dis.size()));
            }
            return li;
    }
}

public class ComponentGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = ComponentGraphResult.componentsInGraph(gb);

        bufferedReader.close();
    }
}
