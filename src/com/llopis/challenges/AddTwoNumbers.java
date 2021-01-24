package com.llopis.challenges;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
	
	/* Definition for singly-linked list. */
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        boolean carry = false;
        
        // Traverse nodes in parallel until one or none return null;
        // Account for carry with flag
        while(l1 != null && l2 != null) {
            int num = carry ? l1.val + l2.val + 1 : l1.val + l2.val;
            if(num > 9) {
                head.next = new ListNode(num % 10);
                carry = true;
            }   else    {
                head.next = new ListNode(num);
                carry = false;
            }
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // These two whiles will only run if l1 length != l2 length
        while(l1 != null)   {
            int num = carry ? l1.val + 1 : l1.val;
            if(num > 9) {
                head.next = new ListNode(num % 10);
                carry = true;
            }   else    {
                head.next = new ListNode(num);
                carry = false;
            }
            head = head.next;
            l1 = l1.next;
        }
         while(l2 != null)   {
            int num = carry ? l2.val + 1 : l2.val;
            if(num > 9) {
                head.next = new ListNode(num % 10);
                carry = true;
            }   else    {
                head.next = new ListNode(num);
                carry = false;
            }
             head = head.next;
             l2 = l2.next;
        }
        if(carry)
            head.next = new ListNode(1);
        return result.next;
    }
}
