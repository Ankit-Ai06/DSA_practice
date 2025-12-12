class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // Calculate left sum
            for (int left = 0; left < i; left++) {
                leftSum += nums[left];
            }

            // Calculate right sum
            for (int right = i + 1; right < n; right++) {
                rightSum += nums[right];
            }

            // Check if pivot index
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;   // no pivot index found
    }
}
