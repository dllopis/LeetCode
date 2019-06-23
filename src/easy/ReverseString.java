package easy;

/* 	LEETCODE PROBLEM #344	*/
public class ReverseString {

    int count = 0;
    // Recursive solution
    public void reverseString(char[] s) {
        if(count == s.length/2)
            return;
        
        char temp = s[count];
        s[count] = s[s.length-count-1];
        s[s.length-count-1] = temp;
        count++;
        
        reverseString(s);
        
    }
}
