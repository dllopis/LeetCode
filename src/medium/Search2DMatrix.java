package medium;

/* LeetCode Problem 74: Search a 2D Matrix */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetColumn = binarySearchColumn(matrix, target);
        return binarySearchRow(matrix, target, targetColumn);
    }

    /* Binary search on first column to find target row*/
    private int binarySearchColumn(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while(low <= high) {
            int middle = low + (high-low) / 2;

            if(matrix[middle][0] <= target && matrix[middle][matrix[middle].length-1] >= target) {
                return middle;
            } else if(matrix[middle][0] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
    /* Binary Search on target Row to find if target exist */
    private boolean binarySearchRow(int[][] matrix, int target, int targetRow) {
        if(targetRow == -1) return false;

        int low = 0;
        int high = matrix[targetRow].length - 1;

        while(low <= high) {
            int middle = low + (high - low) / 2;
            if(matrix[targetRow][middle] == target) {
                return true;
            } else {
                if(matrix[targetRow][middle] < target) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();

        int[][] t1 = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 20;

        System.out.printf("Does %d exist in matrix: %b", target, solution.searchMatrix(t1, target));
    }
}