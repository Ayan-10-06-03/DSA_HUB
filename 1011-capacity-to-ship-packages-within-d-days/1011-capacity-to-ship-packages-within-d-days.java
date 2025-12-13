// class Solution 
// {
//     private int finddays(int[] weights, int cap)
//     {
//         int load = 0;
//         int day = 1;    //1st day
//         for (int i=0; i<weights.length; i++)
//         {
//             if (load+weights[i] <= cap)
//             {
//                 load = load+weights[i];
//             }
//             else
//             {
//                 day = day+1;
//                 load = weights[i];
//             }
//         }

//         return day;
//     }


//     public int shipWithinDays(int[] weights, int days) 
//     {
//         int min = 0;
//         int max = 0;

//         //first find the range
//         for (int i=0; i<weights.length; i++)
//         {
//             min = Math.max(min, weights[i]);   //minimum itna weight to load kerna hi hai to complete within days
//             max = max + weights[i];            //maximum itna ker sakte hai (i.e ki ek hi din me sab load ker de)
//         }

//         //main logic starts from here
//         for (int cap = min; cap<=max; cap++)
//         {
//             int reqdays = finddays(weights, cap);
//             if (reqdays <= days)
//             {
//                 return cap;
//             }
//         }

//         return max;  //worst case me sara load ek din me hi ker do
//     }
// }

//optimized code (binary search approach)
class Solution 
{
    private int findDays(int[] weights, int cap)
    {
        int load = 0;
        int days = 1;

        for (int w : weights)
        {
            if (load + w <= cap)
            {
                load += w;
            }
            else
            {
                days++;
                load = w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) 
    {
        int low = 0, high = 0;

        // define search space
        for (int w : weights)
        {
            low = Math.max(low, w);  // minimum possible capacity
            high += w;               // maximum possible capacity
        }

        // binary search
        while (low < high)
        {
            int mid = low + (high - low) / 2;

            int requiredDays = findDays(weights, mid);

            if (requiredDays <= days)
            {
                high = mid;   // try smaller capacity
            }
            else
            {
                low = mid + 1; // increase capacity
            }
        }

        return low; // minimum capacity
    }
}
