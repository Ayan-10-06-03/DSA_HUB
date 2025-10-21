class Solution 
{
    public int search(int[] nums, int target) 
    {
        if (nums[0]==target) return 0;
        int left = 0;
        int right = nums.length-1;
        while (left <= right)
        {
            int mid = (left+right)/2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (target < nums[mid])
            {
                right = mid-1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return -1;
    }
}