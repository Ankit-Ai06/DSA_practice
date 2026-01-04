import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;
        
        int time = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean fresh_found = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();
                
                for (int[] dir : directions) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2; 
                        queue.offer(new int[]{r, c});
                        freshCount--;
                        fresh_found = true;
                    }
                }
            }
            if (fresh_found) time++;
        }
        return freshCount == 0 ? time : -1;
    }
}