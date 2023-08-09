package easy;

public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2

        /* Utilize frequency array since constraint is 1 <= id <= 1000 */
        /* Otherwise, use a hashmap */
        int[] count = new int[1001]; /* Utilize frequency array since constraint is 1 <= id <= 1000 */
        int idCount = 0;

        while(i < nums1.length && j < nums2.length) {
            /* if both id's are equal: sum values & increment both pointers */
            /* else check which id is smaller: add and increment corresponding pointer */
            if(nums1[i][0] == nums2[j][0]) {
                count[nums1[i][0]] = nums1[i++][1] + nums2[j++][1];
            } else if(nums1[i][0] < nums2[j][0]) {
                count[nums1[i][0]] = nums1[i++][1];
            } else {
                count[nums2[j][0]] = nums2[j++][1];
            }
            idCount++;
        }

        /* Make sure to exhaust each array of id's */
        while(i < nums1.length) {
            count[nums1[i][0]] = nums1[i++][1];
            idCount++;
        }
        while(j < nums2.length) {
            count[nums2[j][0]] = nums2[j++][1];
            idCount++;
        }

        /* Populate resulting array with the frequency array */
        int[][] result = new int[idCount][2];
        int idx = 0;
        for(int k = 1; k < count.length; k++) {
            if(count[k] != 0) {
                result[idx][0] = k;
                result[idx++][1] = count[k];
            }
        }
        return result;
    }
}