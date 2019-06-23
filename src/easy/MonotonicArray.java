package easy;

public class MonotonicArray {

	/* 	LEETCODE PROBLEM #896	*/
	public boolean isMonotonic(int[] A) {
        if(A.length < 2)
            return true;
        
        for(int i = 0;i<A.length-1;i++)   {
            if(A[i+1] >= A[i])
                continue;
            else    {
                for(int j = 0;j<A.length-1;j++)   {
                    if(A[j+1] <= A[j])
                        continue;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
