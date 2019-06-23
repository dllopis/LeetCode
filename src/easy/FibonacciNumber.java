package easy;

/* 	LEETCODE PROBLEM #509	*/
public class FibonacciNumber {

	 public int fib(int N) {
	        /*
	        if(N == 0)
	            return 0;
	        if(N == 1)
	            return 1;
	        return fib(N-1) + fib(N-2);
	        */
	        
	        if(N <= 1)
	            return N;
	        
	        int current = 1;
	        int previous = 1;
	        
	        for(int i = 2;i<N;i++)  {
	            int tmp = current;
	            current += previous;
	            previous = tmp;
	        }
	        return current;
	    }
}
