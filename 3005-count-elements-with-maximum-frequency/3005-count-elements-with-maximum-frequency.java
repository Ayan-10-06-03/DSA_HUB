class Solution 
{
    public int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);

        int maxFreq = 1;
        int currFreq = 1;

        // Step 1: Find maximum frequency
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currFreq++;
            } else {
                maxFreq = Math.max(maxFreq, currFreq);
                currFreq = 1;
            }
        }
        maxFreq = Math.max(maxFreq, currFreq); // last element group

        // Step 2: Count total occurrences of all elements with maximum frequency
        currFreq = 1;
        int total = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currFreq++;
            } else {
                if (currFreq == maxFreq) total += currFreq;
                currFreq = 1;
            }
        }

        if (currFreq == maxFreq) total += currFreq; // last group

        return total;
    }
}