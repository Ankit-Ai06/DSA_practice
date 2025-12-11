class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
    
        int[] rowMinY = new int[n + 1];
        int[] rowMaxY = new int[n + 1];
        int[] colMinX = new int[n + 1];
        int[] colMaxX = new int[n + 1];

      
        Arrays.fill(rowMinY, Integer.MAX_VALUE);
        Arrays.fill(colMinX, Integer.MAX_VALUE);

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            rowMinY[x] = Math.min(rowMinY[x], y);
            rowMaxY[x] = Math.max(rowMaxY[x], y);
            colMinX[y] = Math.min(colMinX[y], x);
            colMaxX[y] = Math.max(colMaxX[y], x);
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            if (rowMinY[x] < y && y < rowMaxY[x] &&
                colMinX[y] < x && x < colMaxX[y]) {
                ans++;
            }
        }
        return ans;
    }
}
