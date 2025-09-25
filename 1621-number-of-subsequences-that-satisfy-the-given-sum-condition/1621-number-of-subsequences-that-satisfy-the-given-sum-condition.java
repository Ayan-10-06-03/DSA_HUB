//Your code is correct but it will give "Memory Limit Exceed" error because i am generating all the subsequence then checking which is satisfying the condition
// class Solution 
// {
//     ArrayList<ArrayList<Integer>> list = new ArrayList<>();

//     private void satisfy(int index, int[] nums, ArrayList<Integer> temp)
//     {
//         if (index == nums.length)
//         {
//             list.add(new ArrayList<>(temp));
//             return;
//         }

//         //exclude
//         satisfy(index+1, nums, temp);

//         //include
//         temp.add(nums[index]);
//         satisfy(index+1, nums, temp);

//         //backtracking
//         temp.remove(temp.size()-1);
//     }

//     public int numSubseq(int[] nums, int target) 
//     {
//         ArrayList<Integer> temp = new ArrayList<>();
//         satisfy(0, nums, temp);

//         System.out.println(list);
//         int count = 0;
//         for (ArrayList<Integer> arr : list)
//         {
//             if (arr.size() == 0) continue;

//             int max = Collections.max(arr);
//             int min = Collections.min(arr);

//             if (max+min <= target)
//             {
//                 count++;
//             }
//         }

//         return count;
//     }
// }


//This code is totally correct will give TLE error
// class Solution 
// {
//     int count = 0;

//     private void satisfy(int index, int[] nums, ArrayList<Integer> temp, int target) 
//     {
//         if (index == nums.length) 
//         {
//             if (!temp.isEmpty())
//             {
//                 int max = Collections.max(temp);
//                 int min = Collections.min(temp);
//                 if (max + min <= target) 
//                 {
//                     count++;
//                 }
//             }
//             return;
//         }

//         // Include
//         temp.add(nums[index]);
//         satisfy(index + 1, nums, temp, target);

//         //backtracking
//         temp.remove(temp.size()-1);

//         // Exclude
//         satisfy(index + 1, nums, temp, target);
//     }

//     public int numSubseq(int[] nums, int target) 
//     {
//         ArrayList<Integer> temp = new ArrayList<>();
//         int index = 0;
//         satisfy(index, nums, temp, target);
//         return count;
//     }
// }

class Solution
{
    public int numSubseq(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1000000007;

        //precompute 
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i=1; i<n; i++)
        {
            pow[i] = (pow[i-1] * 2) % mod;
        }

        int left = 0;
        int right = n-1;
        int result = 0;
        while (left <= right)
        {
            if (nums[left] + nums[right] <= target)
            {
                result = (result + pow[right-left]) % mod;
                left++;
            }
            else
            {
                right--;
            }
        }

        return result;
    }
}
