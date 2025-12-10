class Solution 
{
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // count frequencies
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int maxFreq = 0;

        // find max frequency
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int total = 0;

        // count total occurrences of elements having max frequency
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                total += freq;
            }
        }

        return total;
    }

}