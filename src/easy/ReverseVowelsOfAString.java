package easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

	/* 	LEETCODE PROBLEM #345	*/
    public String reverseVowels(String s) {
        
        Set<Character> vowels = new HashSet<>();
        char[] c = s.toCharArray();
        
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int i = 0;
        int j = s.length()-1;
        while(i < j)    {
            if(vowels.contains(c[i]) && vowels.contains(c[j]))    {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
            if(!vowels.contains(c[i]))
                i++;
            if(!vowels.contains(c[j]))
                j--;
        }
        return new String(c);
    }
}
