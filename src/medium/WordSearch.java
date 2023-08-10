package medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (generateWord(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean generateWord(char[][] board, int i, int j, String word, int count) {
        /* Found word - Base Case */
        if (count == word.length()) {
            return true;
        }
        /* Store temp value, so that we can restore it when we backtrack */
        char temp = board[i][j];
        /* Mark this position as visited */
        board[i][j] = '#';
        boolean isWord = false;

        /*
         * Check all four directions: up, down left, right
         * If we encounter a matching letter, increase count and recurse
         */
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(count)) {
            isWord = generateWord(board, i - 1, j, word, count + 1);
        }
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(count)) {
            isWord = generateWord(board, i + 1, j, word, count + 1);
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(count)) {
            isWord = generateWord(board, i, j - 1, word, count + 1);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(count)) {
            isWord = generateWord(board, i, j + 1, word, count + 1);
        }

        board[i][j] = temp; /* Restore value */
        return isWord;
    }
}
