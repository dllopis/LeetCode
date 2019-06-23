package easy;

import java.util.HashMap;
import java.util.Map;

/* 	LEETCODE PROBLEM #961	*/
public class N_RepeatedElementsInSize_2N_Array {

	// Quick solution using extra memory
    public int repeatedNTimes(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i<A.length;i++)   {
            if(map.containsKey(A[i]))
               return A[i];
            map.put(A[i],1);
        }
        return -1;
    }
}
