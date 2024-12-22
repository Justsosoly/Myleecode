package Mytest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
2
1 2 4 3 5 6 7

            3
        2       6
      1   4   5    7 
 */
//这个是按题意 反向构建出来的方法，输入的节点顺序是按中间的为根节点，
//左边的数组中间值为左子数的根，右边的数组中间值为右子数的根
public class CheckBST2 {
    
	
	
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	
	//存在问题，只会判断当前根节点大于左节点，小于右节点
	
    void checkBST(Node root) {
        // type your code here
       //boolean flag=false;
       
       if(root==null) return ;
       
       else
       {
           
       if(root.left!=null)
           checkBST(root.left);
       
       list.add(root.data);
       System.out.println(root.data);
       
       if(root.right!=null)
           checkBST(root.right);  
           
        } 
       
     
    }
    

    
    
    

    class Node {
        int data;
        Node left;
        Node right;
    }
    
    public Node buildTree(String [] arr, int from, int to) {
        int middle = from + (to - from) / 2;
        Node node = new Node();
        node.data = Integer.valueOf(arr[middle]);
        if (middle > from) {
            node.left = buildTree(arr, from, middle - 1);
            node.right = buildTree(arr, middle + 1, to);
        }
        return node;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int maxHeight = Integer.valueOf(in.readLine());
            String [] line = in.readLine().split(" ");
            CheckBST2 solution = new CheckBST2();
            Node root = solution.buildTree(line, 0, line.length);
            
            List<String> sortlist= Arrays.asList(line);
            List<Integer> sortl=new ArrayList<>();
  
            
            for(int i=0;i<line.length;i++)
            {
            	sortl.add( Integer.valueOf( sortlist.get(i) ) );
            }
           
            
            int count=0;
            solution.checkBST( root);
            Collections.sort(sortl);
            
            for(int j=1;j<sortl.size();j++)
            {
            	if(sortl.get(j-1)==sortl.get(j))
            	{
            	out.println("No");
            	return ;
            	}
            }
            
            
            
            for(int i=0;i<line.length;i++)
            {
          
            	
            	
            	if( Integer.valueOf( sortl.get(i).toString() )==list.get(i))
            		
            		{
            		count++;
            		continue;
            		}
            	else
            		{
            		  out.println("No");
            		  break;
            		}
            	
            }
            
            if(count==line.length)
            {
            	out.println("Yes");
            }
       
        }//end of try
    }
}//end of class 