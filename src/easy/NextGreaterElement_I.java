package easy;

public class NextGreaterElement_I {

	/* Better space complexity, but bad time-complexity.
    Runtime: 4 ms, faster than 39.81% of Java online submissions for Next Greater Element I.
    Memory Usage: 36.8 MB, less than 99.48% of Java online submissions for Next Greater Element I.
    */
	
	/* 	LEETCODE PROBLEM #496	*/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // use of boolean to check if we found next greater element
        boolean flag = false;
        
        // iterate through each element of nums1
        for(int i = 0;i<nums1.length;i++)   {
            // iterate through each element of nums2 searching for nums1[i]
            for(int j = 0;j<nums2.length;j++)   {
                // we found a match here
                if(nums1[i] == nums2[j])    {
                    // next we search to the right to find the next greater element
                    for(int k = j;k<nums2.length;k++) {
                            // here we found the next greater
                            if(nums2[k] > nums1[i]) {
                              //set out boolean to true since we found next greater
                            flag = true;
                              // assign next greater to nums1[i] and break to stop searching right of element
                            nums1[i] = nums2[k];
                            break;
                        }
                    }
                }
                // Here we can make use of the flag to stop the 2nd for-loop from iterating all the way
                // since we already had found a match.
                  if(flag)
                      break;
            }
            // Here we check if our flag returned false - meaning no greater element was found
            // and setting nums1[i] to -1 as a result.
            // reset flag to false for our next check.
            if(!flag)
                nums1[i] = -1;
            flag = false;
        }
            return nums1;
    }
}
