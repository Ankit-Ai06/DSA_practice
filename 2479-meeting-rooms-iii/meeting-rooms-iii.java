import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available =
            new PriorityQueue<>();

        PriorityQueue<long[]> busy =
            new PriorityQueue<>((a, b) ->
                a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
            );

        for (int i = 0; i < n; i++) available.offer(i);

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0], end = m[1];
            long duration = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            int room;
            if (!available.isEmpty()) {
                room = available.poll();
                busy.offer(new long[]{end, room});
            } else {
                long[] top = busy.poll();
                room = (int) top[1];
                busy.offer(new long[]{top[0] + duration, room});
            }

            count[room]++;
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}
