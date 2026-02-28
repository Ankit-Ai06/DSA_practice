class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int Start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while (sum >= target) {
                minLength = Math.min(minLength, i - Start + 1);
                sum -= nums[Start];
                Start++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minLength;
        }
    }
}