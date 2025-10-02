//this code is for left rotation but the question is asking right rotation (just a minor change)
// class Solution 
// {
//     private void reverse(int[] nums, int left, int right)
//     {
//         while (left < right)
//         {
//             int temp = nums[left];
//             nums[left] = nums[right];
//             nums[right] = temp;
//             left++;
//             right--;
//         }
//     }

//     public void rotate(int[] nums, int k) 
//     {
//         int n = nums.length;
//         if (n == 0) return;
//         k = k % n;

//         reverse(nums, 0, k-1);   // Step 1: reverse first k
//         reverse(nums, k, n-1);   // Step 2: reverse last n-k
//         reverse(nums, 0, n-1);   // Step 3: reverse whole array
//     }
// }

class Solution 
{
    private void reverse(int[] nums, int left, int right)
    {
        while (left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) 
    {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;

        reverse(nums, 0, n-1);   // Step 3: reverse whole array
        reverse(nums, 0, k-1);   // Step 1: reverse first k
        reverse(nums, k, n-1);   // Step 2: reverse last n-k
    }
}

