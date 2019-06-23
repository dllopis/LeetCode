package medium;

/* 	LEETCODE PROBLEM #3	*/
public class LongestSubstringWithoutRepeatingCharacters {
	
	/*
	 * Start collecting characters while appending to string builder
	 * If a repeat is found compare the size of SB and update max accordingly
	 */
	 public int lengthOfLongestSubstring(String s) {
	        int max = 0;
	        
	        for(int i = 0;i<s.length();i++)  {
	            StringBuilder sb = new StringBuilder();
	            sb.append(s.charAt(i));
	            for(int j = i+1;j<s.length();j++) {
	                if(sb.indexOf(s.charAt(j) + "") == -1) {
	                    sb.append(s.charAt(j));
	                }else   {
	                    if(sb.length() > max)
	                        max = sb.length();
	                    break;
	                }
	            }
	            if(sb.length() > max)   {
	                max = sb.length();
	            }
	        }
	        return max;
	    }
}
