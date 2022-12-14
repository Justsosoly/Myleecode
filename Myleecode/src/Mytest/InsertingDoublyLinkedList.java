package Mytest;

import java.io.*;
import java.util.*;

public class InsertingDoublyLinkedList {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	class InsertingDoublyLinkedListResult {

		/*
		 * Complete the 'sortedInsert' function below.
		 *
		 * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST. The
		 * function accepts following parameters: 1. INTEGER_DOUBLY_LINKED_LIST llist 2.
		 * INTEGER data
		 */

		/*
		 * For your reference:
		 *
		 * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
		 * DoublyLinkedListNode prev; }
		 *
		 */

		public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
			// Write your code here
			
			DoublyLinkedListNode head = llist;
			while (llist.data <= data&&llist.next!=null) {
				llist = llist.next;
			}
			
			DoublyLinkedListNode node = new DoublyLinkedListNode(data);
			
			if(llist.next==null&&llist.data<=data)//insert to the last node
			{
				llist.next=node;
				node.prev=llist;
				return head;
			}
 
			else if(llist.prev!=null)
			{
			llist.prev.next = node;
			llist.prev = node;
			node.next = llist;
		
			}
			else 
				if(llist.prev==null)//insert to the first node
			{
				llist.prev = node;
				node.next=llist;
				head=node;
			}
			return head;
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = InsertingDoublyLinkedListResult.sortedInsert(llist.head, data);

         
        }


        scanner.close();
    }
}
