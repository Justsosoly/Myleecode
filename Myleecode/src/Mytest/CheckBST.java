package Mytest;

import java.util.Scanner;


/*
7
3 5 2 1 4 6 7


这个类里保证了在构建2叉查找树的时候，按照标准规则构建，所以一定是个2叉查找树。
所以并不是Trees: Is This a Binary Search Tree?里的默认类和方法

*/
public class CheckBST {
	
	public static void main(String args[])
	{
		Scanner sanner=new Scanner(System.in);
		
		int line =sanner.nextInt();
		
		Node root=new Node(sanner.nextInt()) ;
		
		for(int i=1;i<line;i++)
		{
		
			int data=sanner.nextInt();
			
			root.insertNode(root,data );
			
		}
		
		//preOrder(root);
		//height(root);
        checkBST(root);
	}
	
	
	//判断是否为排序树 方法有问题，并不能保证左边所有的子节点都小于根节点。只能保证当前的子节点小于当前的根节点
	   public static boolean  checkBST(Node root)
	    {
	        boolean  flag=true;
	   
	            if(root.left!=null)
	            {
	              
	             if(root.left.data <= root.data)
	               {
	                 
	                    flag=checkBST(root.left);
	               }
	               else
	            	   return false;
	            }
	            if(root.right!=null)
	            {	
	                if(root.right.data >= root.data)
	                {
	                     flag=checkBST(root.right);
	                }
	                else
	                	return false;
	            }	                   
	          
	        
	        return flag;
	    }// end of checkBST
	
	
	//先序遍历
	public static void preOrder(Node root)
	
	{
		if(root!=null)
			System.out.print(root.data+" ");
		
		if(root.left!=null)
			preOrder(root.left);
		
	    if(root.right!=null)
	    	preOrder(root.right);
	}
	//数的高度
	
	public static int height(Node root)
	{
		int height=0;
		if(root==null)
			return 0;
		else
		{
			if(root.left!=null)
			{
				height=height(root.left)+1;
			}
		    if(root.right!=null)
			{
				height=height(root.right)+1;
			}	
		}
		return height;
	}
	

}//end of CheckBST


class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int d)
	{
		this.data=d;
		left=null;
		right=null;
	}
   //构建二叉查找数
  public static  Node insertNode(Node root,int d)
  
  {
	  
	  if(root==null)
	  {
		  Node cur=new Node(d);
		  return cur;
	  }
	  else
	  {
		if( root.data>d) //construct to left 
		{
			Node cur=insertNode(root.left,d);
			root.left=cur;
		}
		else
		if( root.data<d) //construct to right 
		{
			Node cur=insertNode(root.right,d);
			root.right=cur;
		}
		
		  return root;
		  
	  }  
	
  }//end of insertNode

}//end of Node
