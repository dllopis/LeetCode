package com.llopis.challenges;

import java.util.Map;
import java.util.TreeMap;

/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKLists {

	/* Two pass solution */
    /* Treemap keeps elements in order after insertion by key */
    /* Second parameter is the count of each key to handle duplicates */
    
    /* First pass collects elements from each list into a treemap */
    /* Second pass will add values to linked list by iterating through map */
    /* This solution is optimal when the values are NOT sorted */
    
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> map = new TreeMap<>();
        ListNode result = new ListNode(0);
        ListNode curr = result;
        
        for(int i = 0;i<lists.length;i++)   {
            ListNode head = lists[i];
            
            while(head != null) {
                if(map.containsKey(head.val))   {
                    map.put(head.val, map.get(head.val) + 1);
                }else   {
                    map.put(head.val, 1);
                }
                head = head.next;
            }
        }
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int val = entry.getKey();
            
            while(count-- > 0)    {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
        }
        return result.next;
    }
}
