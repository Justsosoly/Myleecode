package Mytest;

import java.io.*;
import java.util.*;


public class ReverseLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

public static class Result {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode reverse2(SinglyLinkedListNode head) {
    // Write your code here
    	SinglyLinkedListNode reversehead=null;
    	
    	
    	
    	while(head!=null)
    	
    	{
    		
    		SinglyLinkedListNode node=head;
    		
    		head=node.next;
    		
    		node.next=reversehead;
    		
    		reversehead=node;
    		
    		
    	}
    	
    	while (reversehead!=null)

    	{
    		System.out.println(reversehead.data);
    		reversehead=reversehead.next;
    	}
    	
    	return reversehead;

    	
    }
    //pass the test
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        // Write your code here
    	SinglyLinkedListNode reverseNode=null;
    	//reverseNode.next=null;
        while(head!=null)
        {
          SinglyLinkedListNode node=head; 
          
          head=head.next;
          
          node.next=reverseNode;
          
          reverseNode=node;
                   
          
        }
        
        
        return reverseNode;   

        }

}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }
           
           SinglyLinkedListNode llist1 = ReverseLinkedList.Result.reverse(llist.head);
     //       SinglyLinkedListNode llist1 = reverse(llist.head);

        //    printSinglyLinkedList(llist1, " ", bufferedWriter);
      //      bufferedWriter.newLine();
        }

    //    bufferedWriter.close();

        scanner.close();
    }


}
