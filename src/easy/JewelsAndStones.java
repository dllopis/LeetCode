package easy;
import java.util.HashSet;
import java.util.Set;

/* 	LEETCODE PROBLEM #771	*/
public class JewelsAndStones {
	
	private String jewels;
	private String stones;
	
	/* Constructor */
	public JewelsAndStones(String newJewels, String newStones)	{
		this.jewels = newJewels;
		this.stones = newStones;
	}
	
	/* Method to return number of jewels within stones */
    public int numJewelsInStones() {
    	
        Set<Character> hashSet = new HashSet<Character>();
        int jewelCount = 0;
        
        for(int i = 0;i<jewels.length();i++)	{
            hashSet.add(jewels.charAt(i));
            //System.out.println("Does HashSet contain " + jewels.charAt(i) + ": " + hashSet.contains(jewels.charAt(i)));
		}
		for(int i = 0;i<stones.length();i++)	{
			if(hashSet.contains(stones.charAt(i)))	{
				jewelCount++;
			}
		}
        return jewelCount;
    }
    
	public static void main(String[] args) {
		/* Testcase 1 */
		String jewels = " aA";
		String stones = "aAAbbbb";
		
		JewelsAndStones t1 = new JewelsAndStones(jewels,stones);
		System.out.println("Jewel Count: " + t1.numJewelsInStones());
	}

}
