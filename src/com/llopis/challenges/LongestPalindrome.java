package com.llopis.challenges;

/* Given a string s, return the longest palindromic substring in s. */

/* Example:1
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */

/* Not the optimal solution, such as the expand from center approach, but I was determined to make
 * this approach work without hitting the time-out exceeded error. 
 * 
 * This solution works with the constraint s.length <= 1000
 * 
 * Using conditional checks with the current max palindrome length, we can cut operations down to pass
 * the time requirement.
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder max = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            for (int j = i+1; j <= s.length(); j++) {
                if(max.length() > j)
                    continue;
                sb.setLength(0);
                sb.append(s.substring(i,j));

                if(sb.length() > max.length() && isPal(sb.toString()))   {
                    max.setLength(0);
                    max.append(sb.toString());
                }
            }
        }
        sb = null;
    return max.toString();
   }
    private boolean isPal(String s) {
        int j = s.length()-1;
        for(int i = 0;i<s.length()/2;i++)
            if(s.charAt(i) != s.charAt(j--))
                return false;
        return true;
    }
}
