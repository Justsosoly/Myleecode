package Mytest;
import java.util.*;





class Postorder {

	class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	    
		public  Node insert(Node root, int data) {
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
	}

 public static void postOrder(Node root) {
	 
	 
	
	 
	 if(root.left!=null)
		 postOrder(root.left);
	 if(root.right!=null)
		 postOrder(root.right);
	 
	 System.out.println(root.data);

    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            
            root = root.insert(root, data);
        }
        scan.close();
        postOrder(root);
    }	
}