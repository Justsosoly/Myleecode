package Mytest;

import java.util.*;
import java.io.*;

class HeightofaBinaryTree {

	  public static int leftheight=0;
	  public static int rightheight=0;
	public static int height(Node root) {
      	// Write your code here.
	
//		if(root.left!=null)
//		{
//			height(root.left);
//			leftheight++;
//			
//			System.out.println(root.data+" leftheight is :"+leftheight);
//		}
//			
//		if(root.right!=null)
//		{
//			height(root.right);
//			rightheight++;
//			System.out.println(root.data+" rightheight is :"+rightheight);
//		}

		
	return root!=null? Math.max(height(root.left)+1, height(root.right)+1):-1;
		
	//	return Math.max(rightheight, leftheight);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
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