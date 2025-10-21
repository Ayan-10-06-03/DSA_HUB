import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);

        // 1) Compute maximum overlap of intervals [nums[i]-k, nums[i]+k]
        //    using sweep-line (events at L: +1, at R+1: -1)
        TreeMap<Integer, Integer> events = new TreeMap<>();
        for (int x : nums) {
            int L = x - k;
            int R = x + k;
            events.put(L, events.getOrDefault(L, 0) + 1);
            // use R + 1 to make intervals inclusive [L, R]
            long rp1 = (long)R + 1L; // keep as long to be safe
            // but TreeMap key must be Integer, so if rp1 fits in int, cast
            if (rp1 > Integer.MAX_VALUE) {
                // extremely unlikely for constraints, but handle defensively
                // we won't put that event (no integer point beyond Integer.MAX_VALUE)
            } else {
                int R1 = (int) rp1;
                events.put(R1, events.getOrDefault(R1, 0) - 1);
            }
        }

        int overlapMax = 0;
        int cur = 0;
        for (Map.Entry<Integer, Integer> e : events.entrySet()) {
            cur += e.getValue();
            overlapMax = Math.max(overlapMax, cur);
        }

        // candidate from non-existing t: we can convert at most numOperations elements
        int ans = Math.min(overlapMax, numOperations);

        // 2) For each unique existing value v, compute:
        //    cnt_range_total(v) = number of nums in [v - k, v + k]
        //    cnt_eq(v) = frequency of v in nums
        // Use binary search (Arrays.binarySearch or custom) for counts in range
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        for (int v : freq.keySet()) {
            int left = lowerBound(nums, v - k);
            int right = upperBound(nums, v + k); // returns index of first > v+k
            int cntRangeTotal = right - left;
            int cntEq = freq.get(v);
            int possible = Math.min(cntRangeTotal, cntEq + numOperations);
            ans = Math.max(ans, possible);
        }

        // Also it's possible no operations at all (numOperations == 0),
        // but the above covers that case (cntEq + 0).
        return Math.min(ans, n);
    }

    // returns first index i such that nums[i] >= target
    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // returns first index i such that nums[i] > target
    private int upperBound(int[] nums, int target) 
    {
        int l = 0, r = nums.length;
        while (l < r) 
        {
            int m = l + (r - l) / 2;
            if (nums[m] > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
