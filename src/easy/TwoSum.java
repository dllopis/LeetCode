package easy;

import java.util.HashMap;

/* 	LEETCODE PROBLEM #1	*/
public class TwoSum {

	//optimal approach - Time O(n) | Space O(n)
	public int[] twoSum(int[] n, int t) {
	    HashMap<Integer,Integer> map = new HashMap<>();
	    
	    for(int i = 0;i<n.length;i++)   {
	        map.put(n[i],i);
	    }
	    
	    for(int i = 0;i<n.length;i++)  {
	        //search the map for value = target - current value and check for unique index
	        if(map.containsKey(t-n[i]) && i != map.get(t-n[i]))
	            return new int[]{i, map.get(t-n[i])};
	    }
	    return new int[]{-1,-1};
	}
	 /* naive approach - Time: O(n^2) | Space:O(1)
	  * 
	    public int[] twoSum(int[] n, int t) {
	      for(int i = 0;i<n.length;i++) {
	          for(int j = i+1;j<n.length;j++)   {
	              if(n[i] + n[j] == t)
	                  return new int[]{i,j};
	          }
	      }
	        return new int[]{-1,-1};
	    }
	*/
}
