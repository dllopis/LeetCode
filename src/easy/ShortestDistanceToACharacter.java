package easy;

public class ShortestDistanceToACharacter {
/*
 * Became a code-magician here...
 * 
 */
	/* 	LEETCODE PROBLEM #771	*/
    public int[] shortestToChar(String S, char C) {
        
        // result array to be returned
        int[] r = new int[S.length()];
        
        // this will keep track of the left and right bounds of where each character ( C ) is in the string
        // so that we can distinguish which is closest to our current position
        int boundL = -1;
        int boundR = -1;
        
        // We will calcute the difference for the closest bound and store them to compare
        int distL = 0;
        int distR = 0;
        
        // Keep track of where we are in the string
        int position = -1;
        
        for(int i = 0;i<S.length();i++) {
            // initialize our position
            if(position == -1)  {
                position = i;
            }       
            // we found C
            if(S.charAt(i) == C)    {
                // set left bound location
                if(boundL == -1)
                    boundL = i;
                // set right bound location
                else if(i > boundL && boundR == -1)  {
                    boundR = i;
                // set both left and right bounds
                }else   {
                    boundL = boundR;
                    boundR = i;
                }
                //System.out.println("BoundL: " + boundL +"\n"+ "BoundR: " + boundR);
                
                while(S.charAt(position) != C)  {
                    // only one boundary found
                    if(boundR == -1)    {
                        r[position] = Math.abs(boundL - position);
                    }else   {
                        // Here we will calculate our distance between both boundaries and take the shortest
                        distL = Math.abs(position-boundL);
                        distR = Math.abs(position-boundR);
                        // ternary operator -- will set the shortest distance to C
                        r[position] = distL < distR ? distL : distR;
                    }
                    position++;
                }
                // distance to C is zero here
                r[position] = 0;
                
                
                // reset position to -1, next iteration will set position again
                position = -1;
            }
        }
        // edge case--  S = abaa : C = b -- notice that we have to take care of positions after b
        if(position != -1)
            while(position < S.length())    {
                if(boundR == -1)    {
                            r[position] = Math.abs(boundL - position);
                        }else   {
                            // Here we will calculate our distance between both boundaries and take the shortest
                            distL = Math.abs(position-boundL);
                            distR = Math.abs(position-boundR);
                            // ternary operator -- will set the shortest distance to C
                            r[position] = distL < distR ? distL : distR;
                        }
                        position++;
            }  
        return r;
    }
}
