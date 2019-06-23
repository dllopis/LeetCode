package easy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveAllDAdjacentDuplicatesInString {

/*	My solution -- LEETCODE PROBLEM #1047	*/
	public static String removeDuplicates(String S) {

		if(S.length() < 2)
			return S;
		
		boolean done = true;
		
		StringBuilder sb = new StringBuilder();
		sb.append(S);
		
		for(int i = 1;i<sb.length();i++)	{
			if(sb.charAt(i) == sb.charAt(i-1))	{
				sb.delete(i-1, i+1);
				
				done = false;
				break;
			}
		}
		if(!done)	{
			return removeDuplicates(sb.toString());
		}
		return sb.toString();
}
	
/*
 * Methods below are from others who did a nice job with this problem.
 * Placed them here for future reference
 */
    public static String removeDuplicatesStack(String S) {
		Stack<Character> st = new Stack<>();
		
		for(char c : S.toCharArray()) {
			if(!st.isEmpty()) {
				if(c == st.peek()) st.pop();
				else st.push(c);
			} else st.push(c);
		}
		
		StringBuilder builder = new StringBuilder();
		for(char c : st)
			builder.append(c);
		
		return builder.toString();    
	}
    public static String removeDuplicatesDequeue(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) { 
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }
    public static String removeDuplicatesStringBuilder(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) { 
                sb.deleteCharAt(size - 1); 
            }else { 
                sb.append(c); 
            }
        }
        return sb.toString();
    }
    public static String removeDuplicatesTwoPointers(String S) {
        char[] a = S.toCharArray();
        int end = -1;
        for (char c : a) {
            if (end >= 0 && a[end] == c) { 
                --end; 
            }else { 
                a[++end] = c; 
            }
        }
        return String.valueOf(a, 0, end + 1);
    }
	public static void main(String[] args) {
		String input = "abbaca";
		
		System.out.println(removeDuplicatesStack(input));
		System.out.println(removeDuplicatesDequeue(input));
		System.out.println(removeDuplicatesStringBuilder(input));
		System.out.println(removeDuplicatesTwoPointers(input));
	}

}
