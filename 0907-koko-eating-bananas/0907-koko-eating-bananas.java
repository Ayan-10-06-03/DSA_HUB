class Solution 
{
    private int max(int[] piles)
    {
        int max = piles[0];
        for (int i : piles)
        {
            if (i > max)
            {
                max = i;
            }
        }
        return max;
    }

    private int findspeed(int[] piles, int mid)
    {
        int h = 0;         // hours needed for this pile
        int hr = 0;        // leftover bananas
        int totalh = 0;      // total hours needed for all piles
        for (int i : piles)
        {
            if (i >= mid)
            {
                h = i/mid;     // full hours eaten
                hr = i%mid;    // leftover bananas
                if (hr > 0)
                {
                    h = h+1;    // need 1 extra hour to eat leftover
                }
            }
            else
            {
                h = 1;          // pile smaller than speed → finishes in 1 hour
            }

            totalh = totalh + h;    // add to total hours
        }

        return totalh;
    }

    public int minEatingSpeed(int[] piles, int h) 
    {
        //both these low and high are refering the speed with which Koko can eat the banana
        int low = 1;           
        int high = max(piles);
        int mid = (low+high)/2;     //mid is like probable speed of Koko

        while (low < high)
        {
            mid = (low+high)/2;
            int temptime = findspeed(piles, mid);
            if (temptime <= h)
            {
                high = mid;    // try slower speed
            }
            else
            {
                low = mid+1;   // speed too slow, increase
            }
        }

        return low;
    }
}