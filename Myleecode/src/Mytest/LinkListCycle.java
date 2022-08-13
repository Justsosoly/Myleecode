package Mytest;

public class LinkListCycle {
//leetcode 141 判断是否有环
	public boolean hasCycle(ListNode head) {
		ListNode slow=head ;
		ListNode fast=head;
		if(head==null)return false; //该链表没有后续了，则没有环
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		return true;
	}

//leetcode 142 返回循环的头节点	
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
             if(fast==slow)  return slow.next;//返回开始循环的节点
             
            if (slow==null) return null;//没有循环
        }
        return null;
    }
//删除链表指定节点
    public ListNode  deletNode(ListNode head,int m) {
    	
    	
    	ListNode node =head;
    	
    	for(int i=0;i<m-2;i++)
    	{
    		//走m步开始后开始删除
    		node=node.next;
    	}
    	
    	ListNode prenode=node;//保存要删除掉node的上个个节点
    	
    	System.out.println("被删除掉的是："+prenode.next.val);
    	ListNode nextnode=node.next.next;//保存要删除掉node的下个节点
    	
    	prenode.next=nextnode;//连接上前后2个节点
	
    	return head;
    }
    
    //计算整个循环链表的长度
    public int lengthCycle(ListNode head)
    { int length=0;
      int count=1;
      ListNode slow=head;
   
      while(slow!=null&&slow.next!=null)
      {
    	  slow=slow.next;
          if(slow!=head)
    		  count++;
      }
     
      length=count;
      System.out.println("the lenght is"+length);
      return length;	
    }
    
    
	// 创建List
	public static void main(String args[]) {
		int value[] = { 1,2,3,4,5,6,7,8,9,-4};

		ListNode headnode = new ListNode(value[0]);

		ListNode nextnode;// 移动的节点
		nextnode = headnode;// 初始化指向头节点

		for (int i = 1; i < value.length; i++) {
			ListNode node = new ListNode(value[i]);// 创建新的Node
			nextnode.next = node;// 把新节点连接进来
			nextnode = nextnode.next;// 移动节点往后挪
		}
		//System.out.println(headnode.next.val);
		//	nextnode.next=headnode.next.next;//按例子中指向第二个节点
		nextnode=headnode;//指向头节点
     /*
		while(headnode!=null)
		{
			System.out.print(headnode.val);
			headnode=headnode.next;
					
		}
		*/
		LinkListCycle llc=new LinkListCycle();
		//llc.hasCycle(headnode);
		//llc.detectCycle(headnode);
		//llc.deletNode(headnode, 3);
		llc.lengthCycle(headnode);
	 
	
		
		
	  
	}

}
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
