package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	/* 	LEETCODE PROBLEM #202	*/
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        
        while(set.add(n))   {

            int sum = 0;
            
            while(n > 0)    {
                int r = n % 10;
                sum += r * r;
                n = n / 10;
            }
            if(sum == 1)
                return true;
            else
                n = sum;
        }
        return false;
    }
}
