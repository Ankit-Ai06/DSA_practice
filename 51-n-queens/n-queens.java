class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); 
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0, n, board, result, cols, diag1, diag2);
        return result;
    }
    private void backtrack(int row, int n, char[][] board,
                           List<List<String>> result,
                           Set<Integer> cols,
                           Set<Integer> diag1,
                           Set<Integer> diag2) {
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board) {
                temp.add(new String(r));
            }

            result.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            // check if safe
            if (cols.contains(col) ||
                diag1.contains(row - col) ||
                diag2.contains(row + col)) {
                continue;
            }

            // place queen
            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // next row
            backtrack(row + 1, n, board, result, cols, diag1, diag2);

            // backtrack
            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}