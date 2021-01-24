package com.llopis.challenges;

import java.util.HashSet;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 	Input: s = "abcabcbb"
 * 	Output: 3
 * 	Explanation: The answer is "abc", with the length of 3.
 */

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 1)
			return 1;
		int max = 0;
		for(int i = 0;i<s.length();i++)  {
			for(int j = i;j<s.length();j++)  {
				String str = s.substring(i,j+1);
            	if(!isRepeat(str))
            		if(str.length() > max)
	            	   max = str.length();
	       }
	   }
        return max;
    }
    
    private boolean isRepeat(String s) { 
        HashSet<Character> set = new HashSet<>(); 
  
        for (int i=0; i<s.length(); i++) 
        { 
            char c = s.charAt(i);
            if(set.contains(c)) 
                return true;
            else
                set.add(c);
        } 
        return false;
    }
}
