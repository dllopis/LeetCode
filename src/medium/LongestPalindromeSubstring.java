package medium;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String t1 = "abba";
		String t2 = "abca";
		String t3 = "racecar";
		String t4 = null;
		String t5 = "";
		
		System.out.println(isPalindrome(t1));
		System.out.println(isPalindrome(t2));
		System.out.println(isPalindrome(t3));
		System.out.println(isPalindrome(t4));
		System.out.println(isPalindrome(t5));
		longestPalindromeSubstring(t3);
	}
	
	public static String longestPalindromeSubstring(String s)	{
		if(s == null || s.length() < 2)
			return "";
		int left = s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2;
		int right = s.length() % 2 == 0 ? s.length() / 2 + 1 : s.length() / 2;
		
		System.out.println("left: " + left + "\n" + "right: " + right);
		return "";
	}
	
	private static boolean isPalindrome(String s)	{
		if(s == null)
			return false;
		if(s.length() < 2)
			return true;
		
		int j = s.length() - 1;
		
		for(int i = 0;i<s.length();i++)	{
			if(s.charAt(i) != s.charAt(j--))
				return false;
		}
		return true;
	}
	
	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}
}
