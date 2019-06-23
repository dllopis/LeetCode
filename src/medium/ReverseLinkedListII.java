package medium;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
}
/* 	LEETCODE PROBLEM #92	*/
public class ReverseLinkedListII {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
        /* if there exist only one node or m and n have the same value */
        if(m == n || head.next == null)
            return head;
    /**
     * 3 nodes:
     * one to traverse
     * one to hold position previous of reversed nodes
     * one to hold end position after reversed nodes
     */
        ListNode current = head;
        ListNode previous = null;
        ListNode after = null;
    
    /* Stack will help reverse the nodes when popping */
        Stack<ListNode> stack = new Stack<>();
    /* Position will help keep track of where we are in the list */
        int position = 0;
        
        while(current != null)  {
            position++;
            /* previous will be assigned when we reach the node before the first required reversal node is found */
            if(position == m-1)	{
                previous = current;
            }
            /* after will be assigned when we reach the node after the last required reversal node is found */
            if(position == n+1)	{
                after = current;
            }
            /* Nodes between position m through n will be pushed into stack for reversal */
            if(position >= m && position <= n)	{
                stack.push(current);
                current = current.next;
            }else	{
                /* when outside the boundary of [ position < m ||| position > n ], we will continue traversing list */
                current = current.next;  
            }
        }
        /* Empty stack while linking to the previous node/before the reversed nodes */
        if(previous != null)	{
	        while(!stack.isEmpty())	{
	            previous.next = stack.pop();
	            previous = previous.next;
	        }
	        /* Link the end of the reversed nodes to the correct position*/
	        previous.next = after;
        }else	{
        	/* first node is part of reversal and so previous is null */
        	ListNode temp = stack.pop();
        	/* This will hold the position of the first node when we are done linking nodes together*/
        	head = temp;
        	while(!stack.isEmpty())	{
        		temp.next = stack.pop();
        		temp = temp.next;
        	}temp.next = after;
        }
        return head;
    }
	
	//display linkedlist
	public static void displayList(ListNode head, String msg)	{
		if(head == null)	{
			msg = "Empty list.";
			return;
		}
		
		ListNode current = head;
		
		while(current != null)	{
			System.out.print(current.val + " --> ");
			current = current.next;
		}
		System.out.print("null\n");
	}
	  
	public static void main(String[] args) {
		
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		int m = 1;
		int n = 4;
		
		System.out.println("Reverse nodes from " + m + " and " + n + ".");
		displayList(n0,"Original-list: ");
		ListNode current = reverseBetween(n0,m,n);
		displayList(current,"Result-list: ");
	}
}
