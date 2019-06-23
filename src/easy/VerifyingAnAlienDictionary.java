package easy;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {

	/*
	 * Should have commented code, but the gist:
	 * 
	 * 1. Iterate through each in words
	 * 2. Compare ith string with jth string - 2nd loop targets jth string
	 * 3. Compare ith string characters with jth string character for lexicographic ordering
	 * Brute-force checks
	 * 		example: App and Apple - edge case check
	 */
	/* 	LEETCODE PROBLEM #953	*/
	 public boolean isAlienSorted(String[] words, String order) {
	        HashMap<Character,Integer> map = new HashMap<>();
	        
	        for(int i = 0;i<order.length();i++) {
	            map.put(order.charAt(i),i);
	        }
	        
	        for(int i = 0;i<words.length;i++)   {
	            for(int j = i+1;j<words.length;j++)  {
	                int k = 0;
	                int l = 0;
	                
	                while(k < words[i].length())    {
	                    if(l >= words[j].length())  {
	                        if(k < words[i].length()){
	                            while(k < words[i].length())    {
	                                if(map.get(words[i].charAt(k)) > map.get(words[j].charAt(l-1)));
	                                    return false;
	                            }
	                        }
	                        break;
	                    }else   {
	                    
	                        if(map.get(words[i].charAt(k)) > map.get(words[j].charAt(l)))
	                           return false;
	                        if(map.get(words[i].charAt(k)) < map.get(words[j].charAt(l)))
	                            break;
	                        if(map.get(words[i].charAt(k)) == map.get(words[j].charAt(l)))  {
	                            k++;
	                            l++;
	                            continue;
	                        }
	                    }
	                    k++;
	                    l++;
	                }
	            }
	        }
	        return true;
	    }
}
