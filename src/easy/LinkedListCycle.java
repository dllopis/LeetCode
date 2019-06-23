package easy;

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
		next = null;
	}
}

/* 	LEETCODE PROBLEM #141	*/
public class LinkedListCycle {


    public boolean hasCycle(ListNode head) {
    	if(head == null || head.next == null)
    		return false;
    	
    	ListNode current = head;
    	ListNode runner = head.next;
    	
    	while(current != runner)	{
    		if(runner == null || runner.next == null)
    			return false;
    		
    		current = current.next;
    		runner = runner.next.next;
    	}
		return true;
    }

	public static void main(String[] args) {
		
		LinkedListCycle node = new LinkedListCycle(); 
		ListNode n0 = new ListNode(3);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(-4);
		
		// Linked-List: {3,2,0,-4} -- Tail points to position 1 -- Cycle encountered -- must return true;
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;
		
		System.out.println("Has Cycle? : " + node.hasCycle(n0));
	}

}
