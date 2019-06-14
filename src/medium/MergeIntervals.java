package medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static int[][] merge(int[][] intervals) {
		/* short hand Java 8 sort with a comparator*/
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		
		if(intervals.length <= 1)
			return intervals;
		/* count will help keep track of size for the returned array */
		int count = 0;
		
		/* keep track of our start and end intervals as we compare */
	    int start = intervals[0][0];
	    int end = intervals[0][1];
	    
	    /* Two list holding corresponding start and end values
	     * This will populate the return array accordingly */
		List<Integer> s = new ArrayList<Integer>();
		List<Integer> e = new ArrayList<Integer>();
		
		/*
		 * First we will check if the intervals overlap.
		 * If so, change our end value to the current intervals end
		 * else, we have encountered a new interval.
		 * 	So, add to corresponding list and then update start and end intervals.
		 * 	Increment our count value (size of new array)
		 * 
		 * The print-outs were a guide to check if intervals were correct.
		 */
	    for(int i = 1;i<intervals.length;i++)   {
	            if(intervals[i][0] <= end && intervals[i][1] >= end)	{
	            	//System.out.println(start + " : " + intervals[i][1] + " -- merged --");
	            	end = intervals[i][1];
	            	/* End interval [i][1] merges since it's less than current end*/
	            }	else if(intervals[i][1] < end)
	            		continue;
	            	else	{
	            	//System.out.println("New Interval: " + start + " : " + end);
	            	s.add(start);
	            	e.add(end);
	            	start = intervals[i][0];
	            	end = intervals[i][1];
	            	count++;
	            }
	    }
	    //System.out.println("New Interval: " + start + " : " + end);
	    //System.out.println("size of new interval array: " + count);
	    
	    /* Add our last interval once we break the loop and increment count*/ 
	    s.add(start);
	    e.add(end);
	    count++;
	    
	    /* return array initialized with correct size */
	    int[][] result = new int[count][2];
	    
	    /* Two pointers to help fill result array */
	    int p1 = 0;
	    int p2 = 0;
	    
	    /* Fill result array with each list */
	    for(int i = 0;i<count;i++)	{
	    	result[i][0] = s.get(p1++);
	    	result[i][1] = e.get(p2++);
	    }
		return result;
}
	 
	public static void main(String[] args) {
		
		/* testcase 1 - sorted Input */
		int[][] a = {	
				{1,3},
				{2,6},
				{8,10},
				{15,18}
		};
		
		/* testcase 2 - Needs to be sorted first */
		int[][] b = {
				{1,4},
				{0,4}
		};
		
		/* testcase 3 - second end interval is the issue here */
		int[][] c = {
				{1,4},
				{2,3}
		};
		
		int[][] result = merge(a);
		
		for (int[] x : result)
		{
		   for (int y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}

	}

}
