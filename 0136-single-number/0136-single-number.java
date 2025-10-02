class Solution 
{
    public int singleNumber(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
        {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count+1);
        }

        int ans = 0;
        for (int i : map.keySet())
        {
            if (map.get(i) != 2)
            {
                ans = i;
                break;
            }
        }

        return ans;
    }
}