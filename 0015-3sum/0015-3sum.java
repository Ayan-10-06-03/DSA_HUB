// code is correct but will give TLE error

// class Solution 
// {
//     public List<List<Integer>> threeSum(int[] nums) 
//     {
//         Set<List<Integer>> set = new HashSet<>();

//         for (int i=0; i<nums.length-2; i++)
//         {
//             for (int j=i+1; j<nums.length-1; j++)
//             {
//                 for (int k=j+1; k<nums.length; k++)
//                 {
//                     if (nums[i]+nums[j]+nums[k] == 0)
//                     {
//                         List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
//                         Collections.sort(triplet);
//                         set.add(triplet);
//                     }
//                 }
//             }
//         }
        
//         return new ArrayList<>(set);
//     }
// }

class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
       Arrays.sort(nums);
       List<List<Integer>> ANS = new ArrayList<>();
       int n = nums.length;
       for(int i = 0;i < n - 2;i++)
       {
        int j = i+1,k = n - 1;
        
        if(i > 0 && nums[i] == nums[i-1]) continue;
        
        while(j < k)
        {
            int sum = nums[i] + nums[j] + nums[k];
            if(sum == 0)
            {
                ANS.add(Arrays.asList(nums[i],nums[j],nums[k]));
                j++;
                k--;
                while(j < k && nums[j] == nums[j-1]) j++;
            }
            else if(sum < 0) j++;
            else k--;
        }
       }

       return ANS;
    }
}
