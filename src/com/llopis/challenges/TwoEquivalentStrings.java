package com.llopis.challenges;

/*
 * 	Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 *	Output: true
	
 *	Explanation:
 *	word1 represents string "ab" + "c" -> "abc"
 *	word2 represents string "a" + "bc" -> "abc"
 *	
 *	The strings are the same, so return true.
 */
public class TwoEquivalentStrings {
	
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for(int i = 0;i<word1.length;i++)    {
            s1.append(word1[i]);
        }
        for(int i = 0;i<word2.length;i++)    {
            s2.append(word2[i]);
        }
        return s1.length() != s2.length() ? false : String.valueOf(s1).equals(String.valueOf(s2));
    }
}
