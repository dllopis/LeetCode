package easy;

public class SingleNumber {

	/* 	LEETCODE PROBLEM #136 - no extra memory used	*/
    public int singleNumber(int[] nums) {
        int n = 0;
        
        for(int i : nums)  {
            n ^= i;
        }
        
        return n;
    }
}
