class Solution 
{
    private int helper0(int index, int[] nums, int[] dp)
    {
        if (index == 0) return nums[index];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + helper0(index-2, nums, dp);
        int notpick = 0 + helper0(index-1, nums, dp);

        return dp[index] = Math.max(pick, notpick);
    }

    private int helpern(int index, int[] nums, int[] dp)
    {
        if (index == 1) return nums[index];
        if (index < 1) return 0;
        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + helpern(index-2, nums, dp);
        int notpick = 0 + helpern(index-1, nums, dp);

        return dp[index] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) 
    {
        int n = nums.length;
        if (n == 1) return nums[0];  //spacial case

        // Case 1: rob houses [0 … n-2]
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int first = helper0(n-2, nums, dp1);

        // Case 2: rob houses [1 … n-1]
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int last = helpern(n-1, nums, dp2);

        return Math.max(first, last);
    }
}