package medium;
import java.util.Arrays;

/* 	LEETCODE PROBLEM #34 - MEDIUM	*/
public class FindFirstandLastPositionofElement {

/*	My first attempt(Naive):
 * 	Searches for left target first and then breaks to find right target.
 *  Numbers in between aren't checked, but if problem set is large and target values are small -- time is wasted.
    
 *  Example 1 2 3 4 5 -------> 1 million
    target is 5 -- a lot of checks happening from the right. 
    
 *  Modified Binary Search will be attempted next since input is sorted.
 *  Or traverse the J pointer at the same time to cut down on comparison checks,
 */
	
	 public static int[] searchRange(int[] nums, int target) {
	     int i = 0;
	     int j = nums.length-1;
	     int[] result = {-1,-1};
	
	     for(i = 0;i<nums.length;i++)    {
	         if(nums[i] == target)   {
	             result[0] = i;
	             break;
	         }
	     }
	     while(j >= i)    {
	         if(nums[j] == target)   {
	             result[1] = j;
	             break;
	         }
	         j--;
	     }
	     return result;
	 }
	 
	public static void main(String[] args) {
		
		// Test case 1
		int[] t1 = {5,7,7,8,8,10};
		int t1Target = 8;	//	Output: [3,4]
		System.out.println("Array: " + Arrays.toString(t1) + "\nTarget: " + t1Target + "\nResult: " + Arrays.toString(searchRange(t1,t1Target)) + "\n");
		
		int[] t2 = {5,7,7,8,8,10};
		
		// Test case 2
		int t2Target = 6;	//	Output: [-1,-1]
		System.out.println("Array: " + Arrays.toString(t2) 
				+ "\nTarget: " 
				+ t2Target + "\nResult: " 
				+ Arrays.toString(searchRange(t2,t2Target)) 
				+ "\n");
	}
}
