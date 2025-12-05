class Solution 
{
    private int leftsum(int[] nums, int i)
    {
        int sum = 0;
        for (int j=0; j<=i; j++)
        {
            sum += nums[j];
        }
        return sum;
    }

    private int rightsum(int[] nums, int i)
    {
        int sum=0;
        for (int j=i; j<nums.length; j++)
        {
            sum += nums[j];
        }
        return sum;
    }

    public int countPartitions(int[] nums) 
    {
        int count = 0;
        for (int i=0; i<nums.length-1; i++)
        {
            int ls = leftsum(nums, i);
            int rs = rightsum(nums, i+1);

            if (Math.abs(ls-rs) % 2 == 0)
            {
                count++;
            }
        }
        return count;
    }
}