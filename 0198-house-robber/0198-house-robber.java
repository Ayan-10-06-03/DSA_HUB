class Solution 
{
    private int helper(int index, int[] nums, int[] dp)
    {
        if (index == 0) return nums[index];

        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + helper(index-2, nums, dp);

        int notpick = 0 + helper(index-1, nums, dp);

        return dp[index] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) 
    {
        int i = nums.length-1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(i, nums, dp);
    }
}