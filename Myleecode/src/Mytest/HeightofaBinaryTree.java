package Mytest;

import java.util.*;
import java.io.*;

class HeightofaBinaryTree {

	  public static int leftheight=0;
	  public static int rightheight=0;
	public static int height(Node root) {
      	// Write your code here.
	
		 int height=0;
	        if(root==null)
	        {
	          return 0;
	        }
	        else
	        {
	          if(root.left!=null)
	          height=height(root.left)+1;
	          
	          if(root.right!=null)
	          height= height(root.right)+1;
	          
	        }
	        
	        return height;
		
	//return root!=null? Math.max(height(root.left)+1, height(root.right)+1):-1;
		
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);//新建左节点给cur
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}